package com.mgil.coursera.course2.test.week1;

import com.mgil.cousera.course2.week1.CaesarCipher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CeaserCipherTest {


    private CaesarCipher toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new CaesarCipher();
    }

    @After
    public void tearDown() throws Exception {
        toTest = null;
    }


    @Test
    public void checkEncryptMethod() {

        String original = "FIRST LEGION ATTACK EAST FLANK!";
        String resultExpected = "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!";

        String result = toTest.encrypt(original,23);

        Assert.assertEquals(resultExpected, result);

    }

    @Test
    public void checkEncryptedTwoKeys() {

        String original = "First Legion";
        String resultExpected = "Czojq Ivdzle";

        String result = toTest.encryptTwoKeys(original,23, 17);

        Assert.assertEquals(resultExpected,result);

    }
}
