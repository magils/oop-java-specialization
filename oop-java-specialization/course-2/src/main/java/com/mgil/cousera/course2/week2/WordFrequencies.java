package com.mgil.cousera.course2.week2;

import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;

public class WordFrequencies {


    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    private final int NOT_EXIST = -1;


    public WordFrequencies() {

        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();

    }


    private void findUnique(Iterable<String> words) {

        myWords.clear();
        myFreqs.clear();


        for (String word : words) {

            word = word.toLowerCase();

            int wordIndex = myWords.indexOf(word);

            if (wordIndex == NOT_EXIST) {
                myWords.add(word);
                myFreqs.add(1);
            } else {

                int wordFreq = myFreqs.get(wordIndex);
                wordFreq += 1;
                myFreqs.set(wordIndex, wordFreq);

            }

        }

        printResult();

    }


    public int countUniqueWordsInFile(String file) {

        myWords.clear();
        myFreqs.clear();

        FileResource fileResource = new FileResource(file);

        for (String word : fileResource.words()) {

            word = word.toLowerCase();

            int wordIndex = myWords.indexOf(word);

            if (wordIndex == NOT_EXIST) {
                myWords.add(word);
            }

        }

        return myWords.size();
    }


    public int findIndexOfMax(){

        if(myFreqs.isEmpty()){
            return NOT_EXIST;
        }

        int max = 0;
        int maxIndex = 0;

        for(int index = 0 ; index < myFreqs.size() ; index++)  {

            if(myFreqs.get(index) > max) {
                max = myFreqs.get(index);
                maxIndex = index;
            }

        }

        return maxIndex;

    }


    public String getMostOccurrenceWordInFile(String file){

        myWords.clear();
        myFreqs.clear();

        FileResource fileResource = new FileResource(file);

        for (String word : fileResource.words()) {

            word = word.toLowerCase();

            int wordIndex = myWords.indexOf(word);

            if (wordIndex == NOT_EXIST) {
                myWords.add(word);
                myFreqs.add(1);
            } else {

                int wordFreq = myFreqs.get(wordIndex);
                wordFreq += 1;
                myFreqs.set(wordIndex, wordFreq);

            }

        }

        int maxOccurrenceIndex = findIndexOfMax();

        return  String.format("%s->%d",myWords.get(maxOccurrenceIndex),myFreqs.get(maxOccurrenceIndex));

    }

    private void printResult() {

        for (int index = 0; index < myWords.size(); index++) {
            System.out.printf("- %s -> %d\n", myWords.get(index), myFreqs.get(index));
        }

    }


    public void findUnique(String filePath) {
        FileResource fileResource = new FileResource(filePath);
        getWordsAndCallFindUnique(fileResource);
    }


    public void findUnique(File file) {
        FileResource fileResource = new FileResource(file);
        getWordsAndCallFindUnique(fileResource);

    }


    public void findUnique() {
        FileResource fileResource = new FileResource();
        getWordsAndCallFindUnique(fileResource);
    }


    private void getWordsAndCallFindUnique(FileResource fileResource) {
        Iterable<String> words = fileResource.words();
        this.findUnique(words);

    }


}
