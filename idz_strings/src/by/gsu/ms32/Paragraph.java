package by.gsu.ms32;

import java.util.List;

public class Paragraph {
    private String oneParagraph;
    private List<Sentence> sentences;

    public Paragraph(String oneParagraph){
        this.oneParagraph = oneParagraph;
    }

    public Paragraph(String oneParagraph, List<Sentence> sentences) {
        this.oneParagraph = oneParagraph;
        this.sentences = sentences;
    }

    public String getOneParagraph() {
        return oneParagraph;
    }

    public void setOneParagraph(String oneParagraph) {
        this.oneParagraph = oneParagraph;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "'" + oneParagraph + '\''+'}';
    }
}
