package by.gsu.ms32;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeparateAction {
    public List<Paragraph> separateParagraphs(Scanner scanner){
        List<Paragraph> tempList = new ArrayList<>();
        String newStr = null;
        StringBuilder sb;
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            if((int)s.charAt(0) == 0 || (int)s.charAt(0) == 65533){
                sb = new StringBuilder(s);
                newStr =  sb.deleteCharAt(0).toString();
            }
            if(!newStr.isEmpty()){
                tempList.add(new Paragraph(s));
            }
        }
        return tempList;
    }

    public List<Sentence> separateSentence(Paragraph paragraph){
        List<Sentence> tempList = new ArrayList<>();
        String[] s = paragraph.getOneParagraph().split("[.!?]");
        for(String value : s){
            tempList.add(new Sentence(value));
        }
        return tempList;
    }

    public List<Word> separateWords(Sentence sentence){
        List<Word> tempList = new ArrayList<>();
        StringBuilder sb = null;
        String newStr = null;
        String[] s = sentence.getOneSentence().split("[\\s,]");
        for(String value : s){
            if((int)value.charAt(0) == 0){
                sb = new StringBuilder(value);
                value = sb.deleteCharAt(0).toString();
            }
            if(!value.isEmpty())
                tempList.add(new Word(value));
        }
        return tempList;
    }

    public void showAll(List<Paragraph> paragraphList){
        System.out.println("-----------PARAGRAPHS------------");
        System.out.println("---------------------------------");

        for(Paragraph p : paragraphList){
            System.out.println(p);
        }

        System.out.println("\n------------SENTENCES------------");
        System.out.println("-----------------------------------");

        for(Paragraph p : paragraphList){
            System.out.println(p.getSentences());
        }

        System.out.println("\n--------------WORDS--------------");
        System.out.println("-----------------------------------");

        for(Paragraph p : paragraphList){
            for(Sentence s : p.getSentences()){
                System.out.println(s.getWordList());
            }
        }
    }
}
