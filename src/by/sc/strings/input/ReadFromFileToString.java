package by.sc.strings.input;

import by.sc.strings.exception.DataCheckException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by User on 07.06.2016.
 */
public class ReadFromFileToString {

    private String fullText;

    public void setFullText(String fullText) { this.fullText = fullText; }
    public String getFullText() { return fullText; }

    public ReadFromFileToString(String fileName) throws DataCheckException, IOException {
        File inFile = new File(fileName);
        if (!inFile.exists() || inFile.isDirectory()) throw new DataCheckException("Invalid input file name : ", fileName);
        Path path = Paths.get(fileName);
        this.fullText = new String(Files.readAllBytes(path));
    }

}
