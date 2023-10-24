package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WiseSaying {

    Map<Integer, String> sentence= new HashMap<>();
    Map<Integer, String> writer = new HashMap<>();
    static Integer index =0;


    public void enterObject(BufferedReader bf) throws IOException{
        System.out.print("명언) ");
        String words = bf.readLine();
        System.out.print("작가) ");
        String person = bf.readLine();

        insertObject(words, person);

        System.out.println(index + "번 명언이 등록되었습니다.");
    }

    private void insertObject(String words, String person){
        ++index;
        sentence.put(index, words);
        writer.put(index, person);
    }

    public void printWiseSaying() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        int size = sentence.size();
        for(int i=size; i >=1; i--){
            System.out.println(i + " / " + writer.get(i) + " / " + sentence.get(i));
        }
    }


}
