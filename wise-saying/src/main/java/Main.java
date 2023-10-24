import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("== 명언 앱 ==");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (!input.equals("종료")) {
            System.out.print("명령) ");
            input = bf.readLine();

        }
    }
}