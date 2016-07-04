package by.sc.strings.entity;

import java.util.ArrayList;

/**
 * Created by User on 16.06.2016.
 */
public class TextParser {

    static final String PARAGRAPH_SPLIT = "[\\n\\t\\r]+";
    static final String SENTENCE_SPLIT = "[.!?]+\\t\\s*";
    static final String LEXEME_SPLIT = " ";
    static final String WORD_SPLIT = "[\\s\",.!?;-]+";

    private TextComposite resultTextComposite;

    public TextComposite getResultTextComposite() {return resultTextComposite;}
    public void setResultTextComposite(TextComposite textComposite) {resultTextComposite = textComposite;}

    public TextParser(String text) {
        resultTextComposite = new TextComposite(text);
        String [] splitText = text.split(PARAGRAPH_SPLIT);
        for (int i = 0; i < splitText.length; i++) {
            resultTextComposite.addTextPart(sentenceParser(splitText[i]));
        }
    }

    public TextPart sentenceParser(String text) {
        TextComposite composite = new TextComposite(text);
        String [] splitText = text.split(SENTENCE_SPLIT);
        for (int i = 0; i < splitText.length; i++) {
            composite.addTextPart(lexemeParser(splitText[i]));
        }
        return composite;
    }

    public TextPart lexemeParser(String text) {
        TextComposite composite = new TextComposite(text);
        String [] splitText = text.split(LEXEME_SPLIT);
        for (int i = 0; i < splitText.length; i++) {
            composite.addTextPart(wordParser(splitText[i]));
        }
        return composite;
    }

    public TextPart wordParser(String text) {
        TextComposite composite = new TextComposite(text);
        String [] splitText = text.split(WORD_SPLIT);
        for (int i = 0; i < splitText.length; i++) {
            composite.addTextPart(symbolParser(splitText[i]));
        }
        return composite;
    }

    public TextPart symbolParser(String text) {
        TextComposite composite = new TextComposite(text);
        char [] splitText = text.toCharArray();
        for (int i = 0; i < splitText.length; i++) {
            if (Character.isLetter(splitText[i])) {
                composite.addTextPart(new TextLeaf(Character.toString(splitText[i])));
            }
        }
        return composite;
    }

}
