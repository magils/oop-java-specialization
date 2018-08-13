package com.mgil.coursera.course2.test.week2;

import com.mgil.cousera.course2.week2.WordFrequencies;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordFrecuenciesTest {

    private WordFrequencies toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new WordFrequencies();
    }

    @Test
    public void findUniqueTest() {

        String testFilePath = getClass().getClassLoader().getResource("testwordfreqs.txt").getFile();
        toTest.findUnique(testFilePath);

    }

    @Test
    public void testFindMaxIndex() {

        String testFilePath = getClass().getClassLoader().getResource("testwordfreqs.txt").getFile();
        toTest.findUnique(testFilePath);
        int result = toTest.findIndexOfMax();

        Assert.assertEquals(3,result);

    }
}
