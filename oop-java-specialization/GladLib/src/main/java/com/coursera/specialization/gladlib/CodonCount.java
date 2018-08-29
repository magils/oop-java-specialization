package com.coursera.specialization.gladlib;

import java.util.HashMap;
import java.util.Map;

public class CodonCount {

    private Map<String, Integer> codonCountMap;

    public CodonCount() {
        codonCountMap = new HashMap<String, Integer>();
    }

    public void buildCodonMap(int start, String dna) {

        codonCountMap.clear();

        final int STEP = 3;
        int offset = start + STEP;

        for (; offset < dna.length(); offset = start + STEP ) {

            String codon = dna.substring(start, offset);

            if (!codonCountMap.containsKey(codon)) {
                codonCountMap.put(codon, 1);
            } else {
                Integer currentCount = codonCountMap.get(codon);
                codonCountMap.put(codon, ++currentCount);
            }


            start = offset;

        }

    }


    public String getMostCommonCodon() {

        String maxCodonKey = null;
        int maxCodon = 0;

        for (String key : codonCountMap.keySet()) {


            int codonCounter = codonCountMap.get(key);

            if (codonCounter > maxCodon) {
                maxCodon = codonCounter;
                maxCodonKey = key;
            }

        }

        return maxCodonKey;

    }


    public void printCodonCounts(int start, int end) {

        for (String key : codonCountMap.keySet()) {

            int codonCount = codonCountMap.get(key);

            if (codonCount >= start && codonCount <= end) {
                System.out.printf("%s %d\n", key, codonCountMap.get(key));
            }

        }

    }


    public Map<String, Integer> getCodonCountMap() {
        return codonCountMap;
    }
}
