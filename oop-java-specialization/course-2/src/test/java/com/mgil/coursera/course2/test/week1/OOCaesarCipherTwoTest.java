package com.mgil.coursera.course2.test.week1;

import com.mgil.cousera.course2.week1.OOCaesarCipherTwo;
import edu.duke.FileResource;
import org.junit.Before;
import org.junit.Test;

public class OOCaesarCipherTwoTest {


    private OOCaesarCipherTwo toTest;

    @Before
    public void setUp() throws Exception {

        toTest = new OOCaesarCipherTwo(17,3);
    }


    @Test
    public void simpleTest() {

        String file = getClass().getClassLoader().getResource("smallHamlet.txt").getFile();
        FileResource resource = new FileResource(file);

        String fileContent = resource.asString();

        String encrypted = toTest.encrypt(fileContent);
        String decrypted = toTest.decrypt(encrypted);

        System.out.println("Encrypted:\n" + encrypted);
        System.out.println("Decrypted: \n" + decrypted);

        System.out.println("Keys: " + toTest.breakCaesarCipher(encrypted));

    }
}
