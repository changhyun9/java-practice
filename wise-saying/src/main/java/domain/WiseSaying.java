package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WiseSaying {

    Sentence sentence = new Sentence();
    Writer writer = new Writer();
    static Integer index = 0;

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


    public void insertObject() throws IOException {
        ++index;
        System.out.print("명언 : ");
        String words = bf.readLine();
        sentence.addSentence(words,index);

        System.out.print("작가 : ");
        String author = bf.readLine();
        writer.addWriter(author, index);
                
        System.out.println(index + "번 명언이 등록되었습니다.");
    }

    public void printWiseSaying() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        int size = writer.getSize();
        for (int i = index; i > index-size; i--) {
            System.out.println(i + " / " + writer.getWriter(i) + " / " + sentence.getSentence(i));
        }
    }

    public void removeWiseSaying(int index) {
        boolean checkIndex = validateIndex(index);
        if(checkIndex){
            sentence.removeSentence(index);
            writer.removeWriter(index);
            System.out.println(index +"번 명언이 삭제되었습니다.");
        }
        if(!checkIndex){
            System.out.println(index + "번 명언은 존재하지 않습니다.");
        }
    }

    private boolean validateIndex(int index){
        if(sentence.existSentence(index)){
            return true;
        }
        return false;
    }

    public void editWiseSaying(int index) throws IOException {
        System.out.println("명언(기존) : " + sentence.getSentence(index));
        System.out.print("명언 : ");
        String words = bf.readLine();
        sentence.editSentence(words,index);

        System.out.println("작가(기존) : " +writer.getWriter(index));
        System.out.print("작가 : ");
        String author = bf.readLine();
        writer.editWriter(author,index);
    }


}
