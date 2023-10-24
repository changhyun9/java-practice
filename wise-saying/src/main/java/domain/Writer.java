package domain;

import java.util.HashMap;
import java.util.Map;

public class Writer {
    Map<Integer, String> writer;

    public Writer() {
        this.writer = new HashMap<>();
    }

    public void addWriter(String author, int index){
        writer.put(index, author);
    }

    public String getWriter(int index){
        return this.writer.get(index);
    }

    public void removeWriter(int index){
        writer.remove(index);
    }

    public void editWriter(String author, int index){
        writer.put(index, author);
    }

    public int getSize() {
        return writer.size();
    }
}
