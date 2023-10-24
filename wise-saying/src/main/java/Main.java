import domain.WiseSaying;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("== 명언 앱 ==");
        String input = "";
        WiseSaying wiseSaying = new WiseSaying();

        while (!input.equals("종료")) {
            System.out.print("명령) ");
            input = bf.readLine();
            if (input.equals("등록")) {
                System.out.print("명언) ");
                String words = bf.readLine();

                System.out.print("작가) ");
                String person = bf.readLine();

                wiseSaying.insertObject(words, person);
            }
            if(input.equals("목록")){
                wiseSaying.printWiseSaying();
            }
            if (input.contains("삭제")) {
                int index = input.charAt(input.length()-1) - '0';
                wiseSaying.removeWiseSaying(index);
            }
        }
    }
}