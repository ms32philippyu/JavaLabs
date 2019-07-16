package by.gsu.ms32;

import java.util.List;

public class Sentence {
    private String oneSentence;
    private List<Word> wordList;

    public Sentence(String oneSentence) {
        this.oneSentence = oneSentence;
    }

    public Sentence(String oneSentence, List<Word> wordList) {
        this.oneSentence = oneSentence;
        this.wordList = wordList;
    }

    public String getOneSentence() {
        return oneSentence;
    }

    public void setOneSentence(String oneSentence) {
        this.oneSentence = oneSentence;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "'" + oneSentence + '\'' + '}' + "\n";
    }
}
