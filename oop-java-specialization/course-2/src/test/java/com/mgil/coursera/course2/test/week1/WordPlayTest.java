package com.mgil.coursera.course2.test.week1;

import com.mgil.cousera.course2.week1.WordPlay;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordPlayTest {

    private WordPlay toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new WordPlay();
    }


    @After
    public void tearDown() throws Exception {
        toTest = null;
    }

    @Test
    public void validOnlyVowelsTests() {

        char[] vowels = {'a', 'e', 'i'};

        for (char vowel : vowels) {
            boolean result = toTest.isVowel(vowel);
            System.out.printf("Testing with %c\n",vowel);
            Assert.assertTrue(result);
        }

    }


    @Test
    public void invalidNotVowelsTest() {

        char[] letters = {'x', 'y', 'p'};

        for (char letter : letters) {
            boolean result = toTest.isVowel(letter);
            System.out.printf("Testing with %c\n",letter);
            Assert.assertFalse(result);
        }

    }


    @Test
    public void shouldReplaceAlVowelsInString() {


        String original = "Hello World";
        String resultExpected = "H*ll* W*rld";
        char ch = '*';

        String result = toTest.replaceVowel(original , ch);

        System.out.println("Result = " + result);

        Assert.assertEquals(resultExpected, result);

    }


    @Test
    public void shouldReplaceCharacter() {

        String original = "Mary Bella Abracadabra";
        String resultExpected = "M+ry Bell+ +br*c*d*br+";
        char ch = 'a';

        String result = toTest.emphize(original, ch);

        System.out.println("Result = " + result);
        Assert.assertEquals(resultExpected, result);

    }
}
