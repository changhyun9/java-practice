package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WiseSayingCollection {
    private Map<Integer, WiseSaying> wiseSayingCollection;

    public WiseSayingCollection() {
        wiseSayingCollection = new HashMap<>();
    }

    public int addWiseSaying(String words, String author){
        WiseSaying wiseSaying = new WiseSaying(words, author);
        int index = wiseSaying.increaseIndex();
        wiseSayingCollection.put(index,wiseSaying);
        return index;
    }

    public void printList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        Integer[] keys = getKeysArray();
        int length = keys.length;

        for(int i = length-1; i>=0; i--){
            WiseSaying wiseSaying = getOneWiseSaying(keys[i]);
            System.out.println(keys[i] + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getSentence());
        }
    }

    private Integer[] getKeysArray() {
        Set<Integer> keySet = getKeySet();
        return keySet.toArray(new Integer[0]);
    }

    public void removeWiseSaying(int index){
        WiseSaying wiseSaying = getOneWiseSaying(index);
        if(hasElement(wiseSaying)){
            System.out.println(index +"번 명언은 존재하지 않습니다.");
        }
        if(!hasElement(wiseSaying)){
            wiseSayingCollection.remove(index);
            System.out.println(index + "번 명언이 삭제되었습니다.");
        }
    }

    private boolean hasElement(WiseSaying wiseSaying) {
        return wiseSaying == null;
    }

    private Set<Integer> getKeySet() {
        return wiseSayingCollection.keySet();
    }

    public void editWiseSaying(int index, String words, String author){
        WiseSaying wiseSaying = new WiseSaying(words, author);
        wiseSayingCollection.put(index, wiseSaying);
    }

    public String printOneSentence(int index) {
        WiseSaying wiseSaying = getOneWiseSaying(index);
        return wiseSaying.getSentence();
    }

    public String printOneAuthor(int index){
        WiseSaying wiseSaying = getOneWiseSaying(index);
        return wiseSaying.getAuthor();
    }

    private WiseSaying getOneWiseSaying(int index) {
        return wiseSayingCollection.get(index);
    }

    public void insertFileWiseSaying(String[] split) {
        int index = Integer.valueOf(split[0]);
        String author = split[1];
        String words = split[2];
        WiseSaying wiseSaying = new WiseSaying(words, author, index);
        wiseSayingCollection.put(index, wiseSaying);
    }

    public Set<Entry<Integer, WiseSaying>> getAllWiseSaying(){
        return wiseSayingCollection.entrySet();
    }
}
