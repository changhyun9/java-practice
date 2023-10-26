package domain;

public class WiseSaying {
    private static int index = 0;
    private String sentence;
    private String author;

    public WiseSaying(String sentence, String author) {
        this(sentence,author,index);
    }
    public WiseSaying(String sentence, String author, int index){
        this.sentence = sentence;
        this.author = author;
        this.index = index;
    }

    public String getSentence() {
        return sentence;
    }

    public String getAuthor() {
        return author;
    }

    public int increaseIndex(){
        return ++index;
    }
}
