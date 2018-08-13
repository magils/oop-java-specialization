package com.mgil.cousera.course2.week1;


import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Excercise {

    public void countWords(FileResource resource, Map<Integer, List<String>> counts){

        for(String word : resource.words()){

            String wordCleaned = cleanUp(word);

            int indexLength = wordCleaned.length();

            if (counts.get(indexLength) == null) {
                counts.put(indexLength,new ArrayList<String>());
            }

            counts.get(indexLength).add(wordCleaned);


        }

        for(int key : counts.keySet()){

            System.out.printf("%d word(s) of length %d : %s\n", counts.get(key).size(), key , counts.get(key).toString());

        }

    }

    public int indexMaxOf(Collection<List<String>> values){

        int maxValue = 0;

        for (List<String> value : values){

            if (value.size() > maxValue) {
                maxValue = value.size();
            }
        }

        return maxValue;

    }

    private String cleanUp(String word){

        StringBuilder stringBuilder = new StringBuilder();

        for(char c : word.toCharArray()){

            if(c == '\'' || Character.isLetter(c))
                stringBuilder.append(c);
        }


        return stringBuilder.toString();

    }

}
