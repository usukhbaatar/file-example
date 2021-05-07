package mn.nest.oop;

public class WordCount {

    private String word;
    private int count;

    public WordCount(String word) {
        this.word = word;
        this.count = 1;
    }

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public void addCount() {
        this.count++;
    }

    public String toString() {
        return word + " " + count;
    }

    public String getWord() {return word;}
}
