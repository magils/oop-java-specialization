package com.mgil.coursera.course2.test.week1;

import com.mgil.cousera.course2.week1.CaesarBreaker;
import com.mgil.cousera.course2.week1.CaesarCipher;
import com.mgil.cousera.course2.week1.DecryptionKeys;
import com.mgil.cousera.course2.week1.Excercise;
import edu.duke.FileResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizWeek1 {

    private Excercise toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new Excercise();
    }

    @org.junit.Test
    public void countWordsOnRomeo() throws FileNotFoundException {

        String pathToFile = getClass().getClassLoader().getResource("romeo.txt").getFile();
        File file = new File(pathToFile);

        FileResource resource = new FileResource(file);

        Map<Integer,List<String>> counts = new HashMap<Integer, List<String>>(31);

        toTest.countWords(resource,counts);

    }

    @org.junit.Test
    public void countWordsOnLotsOfWords() throws FileNotFoundException {

        String pathToFile = getClass().getClassLoader().getResource("lotsOfWords.txt").getFile();
        File file = new File(pathToFile);

        FileResource resource = new FileResource(file);

        Map<Integer,List<String>> counts = new HashMap<Integer, List<String>>(31);

        toTest.countWords(resource,counts);

    }

    @Test
    public void decryptMessage1() {

        String message = "Top ncmy qkff vi vguv vbg ycpx";

        CaesarCipher cipher = new CaesarCipher();

        String result = cipher.encryptTwoKeys(message,26 - 2, 26 - 20);

        System.out.println(result);

    }


    @Test
    public void decryptWithTwoKeys() {

        String original = "Akag tjw Xibhr awoa aoee xakex znxag xwko";

        DecryptionKeys keys = new CaesarBreaker().decryptTwoKeys(original);

        CaesarCipher cipher = new CaesarCipher();

        String result = cipher.encryptTwoKeys(original,26 - keys.getFirstKey(),26 - keys.getSecondKey());

        System.out.println(result);

    }

    @Test
    public void decryptMisteryFile() {


        String pathToFile = getClass().getClassLoader().getResource("mysteryTwoKeysPractice.txt").getFile();
        File file = new File(pathToFile);

        FileResource resource = new FileResource(file);

        String encrypted = resource.asString();

        DecryptionKeys keys = new CaesarBreaker().decryptTwoKeys(encrypted);

        System.out.printf("Keys= %d,%d\n",keys.getFirstKey(),keys.getSecondKey());

        CaesarCipher cipher = new CaesarCipher();

        String result = cipher.encryptTwoKeys(encrypted, 26 - keys.getFirstKey(), 26 - keys.getSecondKey());

        System.out.printf("%s ",result);



    }
}
