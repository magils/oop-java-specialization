package com.coursera.specialization.gladlib.test;

import com.coursera.specialization.gladlib.CodonCount;
import com.coursera.specialization.gladlib.WordsInFiles;
import com.mgil.cousera.course2.week2.CharactersInPlay;
import com.mgil.cousera.course2.week2.WordFrequencies;
import edu.duke.FileResource;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class GladLibQuiz {

    @Test
    public void uniqueWordsInError() {

        String filePath = getClass().getClassLoader().getResource("data/errors.txt").getFile();

        WordFrequencies wordFrequencies = new WordFrequencies();

        System.out.println(wordFrequencies.countUniqueWordsInFile(filePath));


    }


    @Test
    public void theMostFrequentsInError() {

        String filePath = getClass().getClassLoader().getResource("data/errors.txt").getFile();

        WordFrequencies wordFrequencies = new WordFrequencies();

        System.out.println(wordFrequencies.getMostOccurrenceWordInFile(filePath));

    }

    @Test
    public void thirdMostSpeakingPart(){
        String filePath = getClass().getClassLoader().getResource("data/errors.txt").getFile();
        CharactersInPlay charactersInPlay = new CharactersInPlay();
        charactersInPlay.findAllCharacters(filePath);
    }

    @Test
    public void speakingCharactersBetween10And15(){
        String filePath = getClass().getClassLoader().getResource("data/errors.txt").getFile();
        CharactersInPlay charactersInPlay = new CharactersInPlay();
        charactersInPlay.charactersWithNumPartsInFile(filePath,10,15);
    }

    @Test
    public void uniqueCodons() {

        CodonCount codonCount = new CodonCount();

        String filePath = getClass().getClassLoader().getResource("data/dnaMystery2.txt").getFile();

        FileResource fileResource = new FileResource(filePath);

        String dna = fileResource.asString();

        codonCount.buildCodonMap(1,dna);
        System.out.println(codonCount.getCodonCountMap().size());

    }

    @Test
    public void mostOccurrences() {

        CodonCount codonCount = new CodonCount();

        String filePath = getClass().getClassLoader().getResource("data/dnaMystery2.txt").getFile();

        FileResource fileResource = new FileResource(filePath);

        String dna = fileResource.asString();

        codonCount.buildCodonMap(2,dna);
        System.out.println(codonCount.getMostCommonCodon());

    }


    @Test
    public void occurs7Times() {

        CodonCount codonCount = new CodonCount();

        String filePath = getClass().getClassLoader().getResource("data/dnaMystery2.txt").getFile();

        FileResource fileResource = new FileResource(filePath);

        String dna = fileResource.asString();

        codonCount.buildCodonMap(0,dna);
        codonCount.printCodonCounts(7,7);

    }

    @Test
    public void wordThatOcursAll7Files(){

        URL resourceUrl = getClass().getClassLoader().getResource("data/quiz");
        File baseResource = new File(resourceUrl.getFile());
        File[] files = baseResource.listFiles((sourceDir, fileName) -> fileName.endsWith(".txt"));

        WordsInFiles wordsInFiles = new WordsInFiles();

        wordsInFiles.buildWordFileMap(files);

        wordsInFiles.wordsInNumFiles(7);

    }


    @Test
    public void wordsThatOccur4TimesInFiles(){

        URL resourceUrl = getClass().getClassLoader().getResource("data/quiz");
        File baseResource = new File(resourceUrl.getFile());
        File[] files = baseResource.listFiles((sourceDir, fileName) -> fileName.endsWith(".txt"));

        WordsInFiles wordsInFiles = new WordsInFiles();

        wordsInFiles.buildWordFileMap(files);

        wordsInFiles.wordsInNumFiles(4);

    }


    @Test
    public void filesInWhichSeaDoNotAppear(){

        URL resourceUrl = getClass().getClassLoader().getResource("data/quiz");
        File baseResource = new File(resourceUrl.getFile());
        File[] files = baseResource.listFiles((sourceDir, fileName) -> fileName.endsWith(".txt"));

        WordsInFiles wordsInFiles = new WordsInFiles();

        wordsInFiles.buildWordFileMap(files);

        wordsInFiles.printFilesIn("sea");

    }


    @Test
    public void filesInWhichTreeAppears(){

        URL resourceUrl = getClass().getClassLoader().getResource("data/quiz");
        File baseResource = new File(resourceUrl.getFile());
        File[] files = baseResource.listFiles((sourceDir, fileName) -> fileName.endsWith(".txt"));

        WordsInFiles wordsInFiles = new WordsInFiles();

        wordsInFiles.buildWordFileMap(files);

        wordsInFiles.printFilesIn("tree");

    }
}
