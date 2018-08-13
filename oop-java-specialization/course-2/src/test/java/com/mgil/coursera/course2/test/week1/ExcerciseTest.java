package com.mgil.coursera.course2.test.week1;

import com.mgil.cousera.course2.week1.Excercise;
import edu.duke.FileResource;
import org.junit.Assert;
import org.junit.Before;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcerciseTest {

    private Excercise toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new Excercise();
    }

    @org.junit.Test
    public void countWordsTest() throws FileNotFoundException {

        String pathToFile = getClass().getClassLoader().getResource("smallHamlet.txt").getFile();
        File file = new File(pathToFile);

        FileResource resource = new FileResource(file);

        Map<Integer,List<String>> counts = new HashMap<Integer, List<String>>(31);


        toTest.countWords(resource,counts);

    }


    @org.junit.Test
    public void countWordsAndIndexMaxOfTest() throws FileNotFoundException {

        String pathToFile = getClass().getClassLoader().getResource("smallHamlet.txt").getFile();
        File file = new File(pathToFile);
        Map<Integer,List<String>> counts = new HashMap<Integer, List<String>>(31);

        FileResource resource = new FileResource(file);
        toTest.countWords(resource,counts);

        final int EXPECTED= 3;
        int result = toTest.indexMaxOf(counts.values());

        Assert.assertEquals(EXPECTED,result);

    }
}
