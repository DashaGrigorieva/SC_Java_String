package by.sc.strings.entity;

import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 16.06.2016.
 */
public class TextComposite implements TextPart {

    private ArrayList<TextPart> parts = new ArrayList<TextPart>();
    private String text = "";

    public ArrayList<TextPart> getParts() { return parts; }
    public String getText() { return text; }
    public void setParts(ArrayList<TextPart> parts) { this.parts = parts; }
    public void setText(String text) { this.text = text; }

    public TextComposite (String text) {
        this.text = text;
    }

    public void addTextPart(TextPart textPart) {
        parts.add(textPart);
    }

    @Override
    public void print(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            for (TextPart a : parts) {
                fw.write(a.getText() + " ");
            }
            fw.write("\n");
            fw.close();
        } catch (IOException e) {
        }
    }
}
