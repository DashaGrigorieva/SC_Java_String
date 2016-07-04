package by.sc.strings.main;

import by.sc.strings.entity.TextParser;
import by.sc.strings.exception.DataCheckException;
import by.sc.strings.input.ReadFromFileToString;
import by.sc.strings.logic.Logic1;
import by.sc.strings.logic.Logic2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by User on 07.06.2016.
 */
public class Main {

    static final String INFILE_NAME = "Data/input.txt";
    static final String OUTFILE_NAME_1 = "Data/output1.txt";
    static final String OUTFILE_NAME_2 = "Data/output2.txt";

    public static void main(String[] args) throws IOException, DataCheckException {

        ReadFromFileToString readFromFile = new ReadFromFileToString(INFILE_NAME);
        String fullText = readFromFile.getFullText();

        Logic1 logic1 = new Logic1(fullText);
        logic1.printSort(OUTFILE_NAME_1);

        Logic2 logic2 = new Logic2(fullText);
        logic2.printWord(OUTFILE_NAME_2);
    }
}
