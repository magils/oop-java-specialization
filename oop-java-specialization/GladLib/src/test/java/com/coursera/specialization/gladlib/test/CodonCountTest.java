package com.coursera.specialization.gladlib.test;

import com.coursera.specialization.gladlib.CodonCount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CodonCountTest {

    private CodonCount toTest;

    @Before
    public void setUp() throws Exception {
        toTest = new CodonCount();
    }


    @After
    public void tearDown() throws Exception {
        toTest = null;
    }


    @Test
    public void testCodonCountMethods() {

        String dna = "CGTTCAAGTTCAA".toUpperCase();

        for (int startFrom = 0; startFrom < 3; startFrom++) {

            toTest.buildCodonMap(startFrom, dna);
            int uniqueCodonsCount = toTest.getCodonCountMap().size();
            System.out.printf("Reading frame starting from %d results in %d uniques codons\n", startFrom, uniqueCodonsCount);
            System.out.println("The most common codon is " + toTest.getMostCommonCodon());
            toTest.printCodonCounts(1, 5);

        }

    }
}
