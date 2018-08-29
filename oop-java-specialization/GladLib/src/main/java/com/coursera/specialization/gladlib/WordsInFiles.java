package com.coursera.specialization.gladlib;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsInFiles {

    private Map<String, ArrayList<String>> wordsInFile;

    public WordsInFiles() {

        wordsInFile = new HashMap<>();

    }

    public void buildWordFileMap() {

        DirectoryResource directoryResource = new DirectoryResource();

        for (File file : directoryResource.selectedFiles()) {
            addWordsFromFile(file);
        }

    }

    public void buildWordFileMap(File... files) {

        for (File file : files) {
            addWordsFromFile(file);
        }
    }


    public void addWordsFromFile(File file) {

        FileResource fileResource = new FileResource(file);

        for (String word : fileResource.words()) {

            if (wordsInFile.containsKey(word)) {

                List<String> list = wordsInFile.get(word);

                if (!list.contains(file.getName())) {
                    list.add(file.getName());
                }

            } else {

                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(file.getName());

                wordsInFile.put(word, arrayList);

            }

        }


    }


    public int maxNumber() {

        int maxNumber = 0;

        for (String key : wordsInFile.keySet()) {


            int fileSize = wordsInFile.get(key).size();

            if (fileSize > maxNumber) {
                maxNumber = fileSize;
            }

        }

        return maxNumber;
    }

    public void wordsInNumFiles(int number) {

        int total = 0;

        System.out.println("Words in files: ");

        for (String key : wordsInFile.keySet()) {

            int fileSize = wordsInFile.get(key).size();

            if (fileSize == number) {
                System.out.printf("\t-%s\n", key);
                total+=1;
            }

        }

        System.out.println("Words total = "+ total);
    }


    public void printFilesIn(String word) {

        List<String> files = wordsInFile.get(word);

        if(files == null){
            System.out.printf("No entries for word '%s' \n",word);
            return;
        }

        System.out.printf("Word '%s' in files:\n",word);

        for (String fileName : files) {
            System.out.printf("\t-%s\n", fileName);
        }

    }


    public Map<String, ArrayList<String>> getWordsInFile() {
        return new HashMap<>(wordsInFile);
    }
}
