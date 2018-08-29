package com.coursera.specialization.gladlib.test;

import com.coursera.specialization.gladlib.GladLib;
import com.coursera.specialization.gladlib.GladLibMap;
import org.junit.Before;
import org.junit.Test;

public class GladLibTest {

    private GladLib toTest;
    private GladLibMap toTest2;

    @Before
    public void setUp() throws Exception {
        toTest = new GladLib();
        toTest2 = new GladLibMap();
    }


    @Test
    public void testGladLib() {
        toTest.makeStory("madtemplate2.txt");
        System.out.println("\nWords replaced = " + toTest.countWordsReplaced());
    }

    @Test
    public void testGladLibMap() {
        toTest2.makeStory("madtemplate2.txt");
        System.out.printf("\nThere are %d words from you can pick up!",toTest2.totalWordsInMap());
        System.out.printf("\nWords that could be used by category %d\n",toTest2.totalWordsConsidered());
    }
}
