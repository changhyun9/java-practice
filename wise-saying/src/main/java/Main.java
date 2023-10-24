import domain.WiseSaying;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("== 명언 앱 ==");
        String input = "";
        String filePath ="/Users/munchanghyeon/Desktop/javaProject/practice1/wise-saying/file/명언.txt";
        File file = new File(filePath);
        file.createNewFile();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader fr = new BufferedReader(new FileReader(filePath));


        WiseSaying wiseSaying = new WiseSaying(bf,fw,bw,fr);
        while (true) {
            System.out.print("명령) ");
            input = bf.readLine();
            if (input.equals("종료")) {
                wiseSaying.saveWiseSaying();
                break;
            }
            if (input.equals("등록")) {
                wiseSaying.insertObject();
            }
            if(input.equals("목록")){
                // 여기서 파일
                wiseSaying.printWiseSaying();
            }
            if (input.contains("삭제")) {
                int index = input.charAt(input.length()-1) - '0';
                wiseSaying.removeWiseSaying(index);
            }
            if (input.contains("수정")) {
                int index = input.charAt(input.length()-1) - '0';
                wiseSaying.editWiseSaying(index);
            }
        }
        bw.close();
    }
}