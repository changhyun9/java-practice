package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sentence {
    private Map<Integer, String> sentence;

    public Sentence() {
        this.sentence = new HashMap<>();
    }

    public void addSentence(String words, int index){
        this.sentence.put(index, words);
    }

    public String getSentence(int index) {
        return sentence.get(index);
    }

    public void removeSentence(int index){
        sentence.remove(index);
    }

    public boolean existSentence(int index){
        return sentence.containsKey(index);
    }

    public void editSentence(String words, int index){
        sentence.put(index, words);
    }

    public Set<Integer> getAllSentence(){
        return sentence.keySet();
    }

}
