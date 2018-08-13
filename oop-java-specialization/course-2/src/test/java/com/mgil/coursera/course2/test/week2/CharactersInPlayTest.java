package com.mgil.coursera.course2.test.week2;

import com.mgil.cousera.course2.week2.CharactersInPlay;
import org.junit.Before;
import org.junit.Test;

public class CharactersInPlayTest {

    private CharactersInPlay toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new CharactersInPlay();
    }

    @Test
    public void findAllCharactersTest(){

        String resourcePath = getClass().getClassLoader().getResource("macbethSmall.txt").getFile();

        toTest.findAllCharacters(resourcePath);

    }

    @Test
    public void characterWithNumPart() {
        String resourcePath = getClass().getClassLoader().getResource("macbethSmall.txt").getFile();
        toTest.findAllCharacters(resourcePath);
        toTest.charactersWithNumParts(2,4);
    }
}
