package domain;

public class WiseSayingDTO {
    int id;
    String content;
    String author;

    public WiseSayingDTO(int index, String sentence, String author) {
        this.id = index;
        this.content = sentence;
        this.author = author;
    }
}
