package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class WiseSaying {

    Sentence sentence = new Sentence();
    Writer writer = new Writer();
    static Integer index = 0;
    BufferedReader bf;
    BufferedReader fr;
    FileWriter fw;
    BufferedWriter bw;

    public WiseSaying(BufferedReader bf, FileWriter fw, BufferedWriter bw, BufferedReader fr){
        this.bf = bf;
        this.fr = fr;
        this.fw = fw;
        this.bw = bw;
    }

    public void insertObject() throws IOException {
        ++index;

        System.out.print("명언 : ");
        String words = bf.readLine();
        sentence.addSentence(words, index);

        System.out.print("작가 : ");
        String author = bf.readLine();
        writer.addWriter(author, index);

        System.out.println(index + "번 명언이 등록되었습니다.");
    }

    public void printWiseSaying() throws IOException {
        // 파일에서 읽어서 Sentence, Writer 저장 그럼 목록을 칠때마다 파일에서 로드를 계속함? 너무 비효율적임
        // 여기서 fr로 파일에서 한줄씩 읽고, "," 구분자 이용해서 Writer, Sentence에 index에 함께 넣어주기.
        // 마지막 줄은 개행이므로 이것도 예외체크 해서 안넣어줄수 있도록 함.
        String read;
        while((read = fr.readLine()) != null){
            String[] split = read.split(",");
            sentence.addSentence(split[1], Integer.parseInt(split[0]));
            writer.addWriter(split[2], Integer.parseInt(split[0]));
        }
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
//        int size = writer.getSize();
//        for (int i = size; i > 0; i--) {
//            System.out.println(i + " / " + writer.getWriter(i) + " / " + sentence.getSentence(i));
//        }
        Set<Integer> allKey = sentence.getAllSentence();
        for (Integer key : allKey) {
            System.out.println(key + " / " + writer.getWriter(key) + " / " + sentence.getSentence(key));
        }
    }

    public void removeWiseSaying(int index) {
        boolean checkIndex = validateIndex(index);
        if (checkIndex) {
            sentence.removeSentence(index);
            writer.removeWriter(index);
            System.out.println(index + "번 명언이 삭제되었습니다.");
        }
        if (!checkIndex) {
            System.out.println(index + "번 명언은 존재하지 않습니다.");
        }
    }

    private boolean validateIndex(int index) {
        if (sentence.existSentence(index)) {
            return true;
        }
        return false;
    }

    public void editWiseSaying(int index) throws IOException {
        System.out.println("명언(기존) : " + sentence.getSentence(index));
        System.out.print("명언 : ");
        String words = bf.readLine();
        sentence.editSentence(words, index);

        System.out.println("작가(기존) : " + writer.getWriter(index));
        System.out.print("작가 : ");
        String author = bf.readLine();
        writer.editWriter(author, index);
    }

    public void saveWiseSaying() throws IOException {
        Set<Integer> allKey = sentence.getAllSentence();
        for (Integer key : allKey) {
            bw.write(key+","+sentence.getSentence(key)+","+writer.getWriter(key));
            bw.write("\n");
        }
        bw.close();
    }

}
