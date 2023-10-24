package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WiseSaying {

    Map<Integer, String> sentence = new HashMap<>();
    Map<Integer, String> writer = new HashMap<>();
    static Integer index = 0;


    public void insertObject(String words, String person) {
        ++index;
        sentence.put(index, words);
        writer.put(index, person);
        System.out.println(index + "번 명언이 등록되었습니다.");
    }

    public void printWiseSaying() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        int size = sentence.size();
        for (int i = size; i >= 1; i--) {
            System.out.println(i + " / " + writer.get(i) + " / " + sentence.get(i));
        }
    }

    public void removeWiseSaying(int index) {
        boolean existIndex = validateIndex(index);
        if(existIndex){
            sentence.remove(index);
            sentence.remove(index);
            System.out.println(index +"번 명언이 삭제되었습니다.");
        }
        if(!existIndex){
            System.out.println(index + "번 명언은 존재하지 않습니다.");
        }
    }

    private boolean validateIndex(int index){
        if(sentence.containsKey(index)){
            return true;
        }
        return false;
    }


}
