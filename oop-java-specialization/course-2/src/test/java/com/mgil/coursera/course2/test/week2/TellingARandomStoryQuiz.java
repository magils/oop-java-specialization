package com.mgil.coursera.course2.test.week2;

import com.mgil.cousera.course2.week2.CharactersInPlay;
import com.mgil.cousera.course2.week2.WordFrequencies;
import org.junit.Test;

public class TellingARandomStoryQuiz {

    private WordFrequencies wordFrequencies = new WordFrequencies();
    private CharactersInPlay charactersInPlay = new CharactersInPlay();


    @Test
    public void printUniqueWords() {
        String fileResource = getClass().getClassLoader().getResource("likeit.txt").getFile();
        wordFrequencies.findUnique(fileResource);
    }

    @Test
    public void uniqueWordsInLikeIt() {

        String fileResource = getClass().getClassLoader().getResource("likeit.txt").getFile();
        int count = wordFrequencies.countUniqueWordsInFile(fileResource);
        System.out.println(count);
    }

    @Test
    public void mostOccurrenceInLikeIt() {

        String fileResource = getClass().getClassLoader().getResource("likeit.txt").getFile();
        String result = wordFrequencies.getMostOccurrenceWordInFile(fileResource);

        System.out.println(result);

    }

    @Test
    public void mostSpeakingCharacterInLikeIt() {

        String fileResource = getClass().getClassLoader().getResource("likeit.txt").getFile();
        String result = charactersInPlay.findTheMostSpeakingCharacterInFile(fileResource);

        System.out.println(result);
    }

    @Test
    public void characterBetween10And15Speaking() {

        String fileResource = getClass().getClassLoader().getResource("likeit.txt").getFile();
        charactersInPlay.charactersWithNumPartsInFile(fileResource,10,15);

    }
}
