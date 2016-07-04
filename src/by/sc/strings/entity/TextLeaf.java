package by.sc.strings.entity;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by User on 16.06.2016.
 */
public class TextLeaf implements TextPart {

    private String text = "";

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public TextLeaf(String text) {
        this.text = text;
    }

    @Override
    public void print(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(text + " ");
            fw.close();
        } catch (IOException e) {
            System.err.println("File error: " + e);
        }
    }
}
