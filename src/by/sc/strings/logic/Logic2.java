package by.sc.strings.logic;

import by.sc.strings.entity.TextComposite;
import by.sc.strings.entity.TextPart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by User on 17.06.2016.
 */

// Найти  такое  слово  в  первом  предложении,  которого  нет  ни  в  одном
// из остальных предложений.

public class Logic2 {

    private TextComposite result;
    private String keyWord;

    public TextComposite getResult() {
        return result;
    }

    public void setResult(TextComposite textComposite) {
        result = textComposite;
    }

    static final String SENTENCE_SPLIT = "[.?!]+[\\t\\s]*";
    static final String WORD_SPLIT = "[\\s\",.!?;-]+";

    public boolean findEqualWord(String word, TextComposite sentenceWords) {
        for (int i = 0; i < sentenceWords.getParts().size(); i++) {
            if (word.toLowerCase().equals(sentenceWords.getParts().get(i).getText().toLowerCase()))
                return true;
        }
        return false;
    }

    public Logic2(String text) {

        TextComposite allSentences = new TextComposite(text);
        String[] splitText = text.split(SENTENCE_SPLIT);
        for (int i = 0; i < splitText.length; i++) {
            allSentences.addTextPart(new TextComposite(splitText[i]));
        }

        TextComposite words = new TextComposite(allSentences.getParts().get(0).getText());
        String[] splitSentence = allSentences.getParts().get(0).getText().split(WORD_SPLIT);
        for (int i = 0; i < splitSentence.length; i++) {
            words.addTextPart(new TextComposite(splitSentence[i]));
        }

        boolean flag = false;
        String keyWord = "";
        for (int k = 0; k < words.getParts().size(); k++) {
            String key = words.getParts().get(k).getText();
            for (int j = 1; j < allSentences.getParts().size(); j++) {
                TextComposite word = new TextComposite(allSentences.getParts().get(j).getText());
                String[] splitSent = allSentences.getParts().get(j).getText().split(WORD_SPLIT);
                for (int i = 0; i < splitSent.length; i++) {
                    word.addTextPart(new TextComposite(splitSent[i]));
                }
                if (findEqualWord(key, word)) {
                    flag = true;
                    continue;
                }
            }
            if (!flag) {
                keyWord = key;
                break;
            } else
                flag = false;
        }
        this.keyWord = keyWord;
    }


    public void printWord(String fileName) {
        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file);
            if (keyWord != "")
                fw.write("Unique word : " + keyWord);
            else
                fw.write("No such word!");
            fw.close();
        } catch (IOException e) {
            System.err.println("File error: " + e);
        }
    }
}
