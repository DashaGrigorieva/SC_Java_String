package by.sc.strings.logic;

import by.sc.strings.entity.TextComposite;
import by.sc.strings.entity.TextPart;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by User on 17.06.2016.
 */

// Ќапечатать слова текста в алфавитном пор€дке по первой букве.
// —лова, начинающиес€ с новой буквы, печатать с красной строки.

public class Logic1 {

    private TextComposite result;

    static final String WORD_SPLIT = "[\\s\",.!?:;-]+";

    public TextComposite getResult() {return result;}
    public void setResult(TextComposite textComposite) {result = textComposite;}

    public Logic1(String text) {
        result = new TextComposite(text);
        String [] splitText = text.split(WORD_SPLIT);
        for (int i = 0; i < splitText.length; i++) {
            result.addTextPart(new TextComposite(splitText[i]));
        }

        Collections.sort(result.getParts(), new Comparator<TextPart>() {
            public int compare(TextPart s1, TextPart s2) {
                return s1.getText().toLowerCase().toString().compareTo(s2.getText().toLowerCase().toString());
            }
        });
    }

    public void printSort(String fileName) {
        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write("Split by sorted words : \n");
            for (int i = 1; i < result.getParts().size(); i++) {
                if (i != 1 && (result.getParts().get(i).getText().toLowerCase().charAt(0) != result.getParts().get(i-1).getText().toLowerCase().charAt(0)))
                    fw.write("\n");
                fw.write(result.getParts().get(i).getText() + " ");
            }
            fw.close();
        } catch (IOException e) {
            System.err.println("File error: " + e);
        }
    }

}
