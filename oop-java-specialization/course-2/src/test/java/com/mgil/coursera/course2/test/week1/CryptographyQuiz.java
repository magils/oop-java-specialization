package com.mgil.coursera.course2.test.week1;

import com.mgil.cousera.course2.week1.DecryptionKeys;
import com.mgil.cousera.course2.week1.Excercise;
import com.mgil.cousera.course2.week1.OOCaesarCipher;
import com.mgil.cousera.course2.week1.OOCaesarCipherTwo;
import edu.duke.FileResource;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptographyQuiz {


    @Test
    public void question1() {
        OOCaesarCipher cipher = new OOCaesarCipher(15);
        String encrypted = cipher.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");

        System.out.println(encrypted);
    }


    @Test
    public void question2() {


        OOCaesarCipherTwo cipher = new OOCaesarCipherTwo(21,8);

        String encrypted = cipher.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");

        System.out.println(encrypted);

    }


    @Test
    public void question4() {

        Excercise excercise = new Excercise();

        String pathToFile = getClass().getClassLoader().getResource("errors.txt").getFile();
        File file = new File(pathToFile);

        FileResource resource = new FileResource(file);

        Map<Integer,List<String>> counts = new HashMap<Integer, List<String>>(31);

        excercise.countWords(resource,counts);

    }


    @Test
    public void question5() {

        Excercise excercise = new Excercise();

        String pathToFile = getClass().getClassLoader().getResource("manywords.txt").getFile();
        File file = new File(pathToFile);

        FileResource resource = new FileResource(file);

        Map<Integer,List<String>> counts = new HashMap<Integer, List<String>>(31);

        excercise.countWords(resource,counts);

    }


    @Test
    public void question6() {

        OOCaesarCipherTwo cipher = new OOCaesarCipherTwo(14,24);

        String decrypted = cipher.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy");

        System.out.println(decrypted);

    }

    @Test
    public void question7() {

        OOCaesarCipherTwo cipher = new OOCaesarCipherTwo(0,0);

        String encrypted = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";

        DecryptionKeys keys = cipher.breakCaesarCipher(encrypted);

        OOCaesarCipherTwo cipherTwo = new OOCaesarCipherTwo(keys.getFirstKey(),keys.getSecondKey());

        System.out.println(cipherTwo.decrypt(encrypted));

    }


    @Test
    public void question8() {

        String pathToFile = getClass().getClassLoader().getResource("mysteryTwoKeysQuiz.txt").getFile();
        File file = new File(pathToFile);
        FileResource resource = new FileResource(file);

        OOCaesarCipherTwo cipher = new OOCaesarCipherTwo(0,0);

        String encrypted = resource.asString();

        DecryptionKeys keys = cipher.breakCaesarCipher(encrypted);

        OOCaesarCipherTwo cipherTwo = new OOCaesarCipherTwo(keys.getFirstKey(),keys.getSecondKey());

        System.out.println(cipherTwo.decrypt(encrypted));

    }

    @Test
    public void question9() {

        String pathToFile = getClass().getClassLoader().getResource("mysteryTwoKeysQuiz.txt").getFile();
        File file = new File(pathToFile);
        FileResource resource = new FileResource(file);

        OOCaesarCipherTwo cipher = new OOCaesarCipherTwo(0,0);

        String encrypted = resource.asString();

        DecryptionKeys keys = cipher.breakCaesarCipher(encrypted);

        System.out.println(keys);


    }

}
