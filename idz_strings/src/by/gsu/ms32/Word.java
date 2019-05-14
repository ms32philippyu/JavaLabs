package by.gsu.ms32;

public class Word {
    private String oneWord;

    public Word(String oneWord) {
        this.oneWord = oneWord;
    }

    public String getOneWord() {
        return oneWord;
    }

    public void setOneWord(String oneWord) {
        this.oneWord = oneWord;
    }

    @Override
    public String toString() {
        return "Word{" +
                oneWord + "}" +
                "\n";
    }
}
