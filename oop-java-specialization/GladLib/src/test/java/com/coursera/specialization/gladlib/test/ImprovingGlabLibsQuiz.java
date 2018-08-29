package com.coursera.specialization.gladlib.test;

import com.coursera.specialization.gladlib.CodonCount;
import com.coursera.specialization.gladlib.WordsInFiles;
import edu.duke.FileResource;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class ImprovingGlabLibsQuiz {

    @Test
    public void uniqueCodonsOnDnaMystery1() {

        CodonCount codonCount = new CodonCount();

        String filePath = getClass().getClassLoader().getResource("data/dnaMystery1.txt").getFile();

        FileResource fileResource = new FileResource(filePath);

        String dna = fileResource.asString();

        for(int x = 0 ; x < 3 ; x++){
            codonCount.buildCodonMap(x,dna);
            System.out.printf("Frame #%d: %s uniques codons\n",x,codonCount.getCodonCountMap().size());
        }

    }

    @Test
    public void codonThatAppears4Times() {

        CodonCount codonCount = new CodonCount();

        String filePath = getClass().getClassLoader().getResource("data/dnaMystery1.txt").getFile();

        FileResource fileResource = new FileResource(filePath);

        String dna = fileResource.asString();

        codonCount.buildCodonMap(2,dna);

        codonCount.printCodonCounts(4,4);

    }

    @Test
    public void codonMostFrequently() {

        CodonCount codonCount = new CodonCount();

        String filePath = getClass().getClassLoader().getResource("data/dnaMystery1.txt").getFile();

        FileResource fileResource = new FileResource(filePath);

        String dna = fileResource.asString();

        codonCount.buildCodonMap(1,dna);

        codonCount.printCodonCounts(6,6);

    }

    @Test
    public void theMostInShakespeareFiles(){

        URL resourceUrl = getClass().getClassLoader().getResource("data/shakespeare");
        File baseResource = new File(resourceUrl.getFile());
        File[] files = baseResource.listFiles((sourceDir, fileName) -> fileName.endsWith(".txt"));

        WordsInFiles wordsInFiles = new WordsInFiles();

        wordsInFiles.buildWordFileMap(files);

        wordsInFiles.wordsInNumFiles(5);


    }

    @Test
    public void wordThatAppearsIn4Files(){

        URL resourceUrl = getClass().getClassLoader().getResource("data/shakespeare");
        File baseResource = new File(resourceUrl.getFile());
        File[] files = baseResource.listFiles((sourceDir, fileName) -> fileName.endsWith(".txt"));

        WordsInFiles wordsInFiles = new WordsInFiles();

        wordsInFiles.buildWordFileMap(files);

        wordsInFiles.wordsInNumFiles(4);

    }


    @Test
    public void wordSadDoesNotAppear(){

        URL resourceUrl = getClass().getClassLoader().getResource("data/shakespeare");
        File baseResource = new File(resourceUrl.getFile());
        File[] files = baseResource.listFiles((sourceDir, fileName) -> fileName.endsWith(".txt"));

        WordsInFiles wordsInFiles = new WordsInFiles();

        wordsInFiles.buildWordFileMap(files);

        wordsInFiles.printFilesIn("sad");

    }


    @Test
    public void wordRedAppears(){

        URL resourceUrl = getClass().getClassLoader().getResource("data/shakespeare");
        File baseResource = new File(resourceUrl.getFile());
        File[] files = baseResource.listFiles((sourceDir, fileName) -> fileName.endsWith(".txt"));

        WordsInFiles wordsInFiles = new WordsInFiles();

        wordsInFiles.buildWordFileMap(files);

        wordsInFiles.printFilesIn("red");

    }
}
