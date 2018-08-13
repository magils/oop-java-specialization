package com.mgil.coursera.course2.test.week1;

import com.mgil.cousera.course2.week1.OOCaesarCipher;
import org.junit.Before;
import org.junit.Test;

public class OOCaesarCipherTest {


    private OOCaesarCipher toTest;

    @Before
    public void setUp() throws Exception {

        toTest = new OOCaesarCipher(18);
    }

    @Test
    public void simpleTests() {

        String encrypted = toTest.encrypt("FIRST LEGION ATTACK EAST FLANK!");
        String decrypted = toTest.decrypt(encrypted);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypte:  " + decrypted);

    }
}
