import com.google.gson.Gson;
import domain.WiseSaying;
import domain.WiseSayingCollection;
import domain.WiseSayingDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Application {

    public static void main(String[] args) throws IOException {

        String txtFilePath = "/Users/munchanghyeon/Desktop/javaProject/practice2/practice2/file/test.txt";
        String jsonFilePath = "/Users/munchanghyeon/Desktop/javaProject/practice2/practice2/file/data.json";
        File txtFile = new File(txtFilePath);
        File jsonFile = new File(jsonFilePath);
        FileWriter fileWriter = new FileWriter(jsonFile);

        WiseSayingCollection wiseSayingCollection = new WiseSayingCollection();

        BufferedReader reader = new BufferedReader(new FileReader(txtFile));

        String line = "";
        while((line = reader.readLine()) != null){
            String[] split = line.split(",");
            wiseSayingCollection.insertFileWiseSaying(split);
        }
        reader.close();

        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("명령) ");
            String input = sc.nextLine();
            if (input.equals("종료")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(txtFile));
                Set<Entry<Integer, WiseSaying>> allWiseSaying = wiseSayingCollection.getAllWiseSaying();

                String words = "";
                for (Entry<Integer, WiseSaying> integerWiseSayingEntry : allWiseSaying) {

                    Integer key = integerWiseSayingEntry.getKey();
                    WiseSaying value = integerWiseSayingEntry.getValue();

                    words = key + "," + value.getAuthor() + "," + value.getSentence();
                    writer.write(words);
                    writer.newLine();
                }
                writer.close();
                fileWriter.close();
                break;
            }
            if (input.equals("등록")) {

                System.out.print("명언 : ");
                String words = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                int index = wiseSayingCollection.addWiseSaying(words, author);

                System.out.println(index + "번 명언이 등록되었습니다.");
            }

            if (input.equals("목록")) {
                wiseSayingCollection.printList();
            }

            if(input.startsWith("삭제")){
                int index = input.charAt(input.length() - 1) - '0';
                wiseSayingCollection.removeWiseSaying(index);
            }

            if(input.startsWith("수정")){
                int index = input.charAt(input.length() - 1) - '0';
                String words = wiseSayingCollection.printOneSentence(index);
                System.out.println("명언(기존) : " + words);
                System.out.print("명언 : ");
                String editWords = sc.nextLine();

                String author = wiseSayingCollection.printOneAuthor(index);
                System.out.println("작가(기존) : " + author);
                System.out.print("작가 : ");
                String editAuthor = sc.nextLine();

                wiseSayingCollection.editWiseSaying(index, editWords, editAuthor);
            }

            if(input.equals("빌드")){
                Set<Entry<Integer, WiseSaying>> allWiseSaying = wiseSayingCollection.getAllWiseSaying();

                List<WiseSayingDTO> list = new ArrayList<>();
                Gson gson = new Gson();

                for (Entry<Integer, WiseSaying> integerWiseSayingEntry : allWiseSaying) {

                    Integer key = integerWiseSayingEntry.getKey();
                    WiseSaying value = integerWiseSayingEntry.getValue();

                    WiseSayingDTO dto = new WiseSayingDTO(key, value.getSentence(), value.getAuthor());
                    list.add(dto);
                }
                String s = gson.toJson(list);

                fileWriter.write(s);
                System.out.println("data.json 파일의 내용이 갱신되었습니다.");
            }
        }
    }
}
