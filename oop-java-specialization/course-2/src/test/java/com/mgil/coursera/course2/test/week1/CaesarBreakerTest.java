package com.mgil.coursera.course2.test.week1;

import com.mgil.cousera.course2.week1.CaesarBreaker;
import com.mgil.cousera.course2.week1.CaesarCipher;
import com.mgil.cousera.course2.week1.DecryptionKeys;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarBreakerTest {

    private CaesarBreaker toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new CaesarBreaker();
    }


    @Test
    public void decryptTest() {

        String original = "efgfoe uif fbtu xbmm pg uif dbtumf";
        String expectedResult = "defend the east wall of the castle";
        String result = toTest.decrypt(original);

        System.out.println(result);

        Assert.assertEquals(expectedResult,result);

    }

    @Test
    public void testHalfOfString() {

        String original;
        String expected;
        String result;

        //Test 1
        original = "Qbkm Zgis";
        expected = "Qk gs";

        result = toTest.halfOfString(original,0);

        Assert.assertEquals(expected,result);

        //Test 2
        expected = "bmZi";

        result = toTest.halfOfString(original,1);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void getTwoKeys(){

        String original = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";

        DecryptionKeys keys = toTest.decryptTwoKeys(original);

        int k1 = keys.getFirstKey();
        int k2 = keys.getSecondKey();

        Assert.assertEquals(23,k1);
        Assert.assertEquals(2,k2);
    }

    @Test
    public void decryptWithTwoKeys() {

        String original = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";

        DecryptionKeys keys = toTest.decryptTwoKeys(original);

        CaesarCipher cipher = new CaesarCipher();

        String result = cipher.encryptTwoKeys(original,26 - keys.getFirstKey(),26 - keys.getSecondKey());

        String expected = "Just a test string with lots of eeeeeeeeeeeeeeeees";

        Assert.assertEquals(expected,result);

    }


    @Test
    public void decryptMisteryFile() {

        String original = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";

        DecryptionKeys keys = toTest.decryptTwoKeys(original);

        CaesarCipher cipher = new CaesarCipher();

        String result = cipher.encryptTwoKeys(original,26 - keys.getFirstKey(),26 - keys.getSecondKey());

        String expected = "Just a test string with lots of eeeeeeeeeeeeeeeees";

        Assert.assertEquals(expected,result);

    }


}
