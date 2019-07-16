import by.gsu.ms32.Paragraph;
import by.gsu.ms32.Sentence;
import by.gsu.ms32.SeparateAction;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static final String FILE_PATH = "src/in.txt";
    public static void main(String[] args) {
        SeparateAction sa = new SeparateAction();
        List<Paragraph> paragraphList;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(FILE_PATH));
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }

        paragraphList = sa.separateParagraphs(scanner);
        for (Paragraph aParagraphList : paragraphList) {
            aParagraphList.setSentences(sa.separateSentence(aParagraphList));
            for (Sentence s : aParagraphList.getSentences()) {
                s.setWordList(sa.separateWords(s));
            }
        }
        sa.showAll(paragraphList);
        String searchWord = "older";
        String newWord = "newer";
        System.out.println(paragraphList.get(0).getSentences().get(1).getOneSentence());
        String s = paragraphList.get(0).getSentences().get(1).getOneSentence();
        String newS = s.replace(searchWord,newWord);
        paragraphList.get(0).getSentences().get(1).setOneSentence(newS);
        System.out.println(paragraphList.get(0).getSentences().get(1).getOneSentence());
    }
}
