package com.coursera.specialization.gladlib.test;

import com.coursera.specialization.gladlib.WordsInFiles;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordInFilesTest {

    private WordsInFiles toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new WordsInFiles();
    }

    @Test
    public void testWordInFilesMethod() throws IOException {

        URL resourceUrl = getClass().getClassLoader().getResource("data/briefs");
        File baseResource = new File(resourceUrl.getFile());
        File[] files = baseResource.listFiles((sourceDir, fileName) -> fileName.endsWith(".txt"));

        toTest.buildWordFileMap(files);

        toTest.wordsInNumFiles(2);
        toTest.printFilesIn("cats");
        System.out.printf("Max number in file: %d\n", toTest.maxNumber());

        System.out.println("Words");

        Map<String, ArrayList<String>> wordMap = toTest.getWordsInFile();

        for (String key : wordMap.keySet()) {

            System.out.printf("Word: %s\n", key);

            List<String> wordInFiles = wordMap.get(key);

            for (String wordInFile : wordInFiles) {
                System.out.printf("\t-%s\n", wordInFile);
            }

        }

    }
}
