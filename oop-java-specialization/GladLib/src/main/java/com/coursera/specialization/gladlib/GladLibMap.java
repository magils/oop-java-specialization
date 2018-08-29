package com.coursera.specialization.gladlib;

import edu.duke.FileResource;
import edu.duke.URLResource;

import java.util.*;

public class GladLibMap {

    private ArrayList<String> wordsUsed;

    private Map<String, ArrayList<String>> categories;
    private ArrayList<String> categoriesUsed;

    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public GladLibMap() {
        categories = new HashMap<>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        wordsUsed = new ArrayList<String>();
        categoriesUsed = new ArrayList<>();
    }

    public GladLibMap(String source) {
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {

        for (Category category : Category.values()) {

            ArrayList<String> list = readIt(source + "/" + category.getName());
            categories.put(category.name().toLowerCase(), list);

        }

    }

    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {

        if (label.equals("number")) {
            addCategoryUsed(label);
            return "" + myRandom.nextInt(50) + 5;
        } else if (categories.get(label) == null) {
            return "**UNKNOWN**";
        }

        ArrayList<String> list = categories.get(label);
        addCategoryUsed(label);
        return randomFrom(list);

    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);
        String sub;
        boolean isARepeatedWord = true;

        do {

            sub = getSubstitute(w.substring(first + 1, last));

            if (!wordsUsed.contains(sub)) {
                wordsUsed.add(sub);
                isARepeatedWord = false;
            }


        } while (isARepeatedWord);


        return prefix + sub + suffix;
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory() {
        wordsUsed.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate.txt");
        printOut(story, 60);
    }

    public void makeStory(String template) {
        wordsUsed.clear();
        System.out.println("\n");
        String story = fromTemplate("data/" + template);
        printOut(story, 60);
    }

    public int countWordsReplaced() {
        return wordsUsed.size();
    }

    public int totalWordsInMap(){

        int totalOfWords = 0;

        for(List<String> list: categories.values()){
            totalOfWords+=list.size();
        }

        return totalOfWords;
    }

    public int totalWordsConsidered(){

        int total = 0;

        for(String categoryUsed : categoriesUsed){
            total += categories.get(categoryUsed).size();
        }

        return total;
    }

    private void addCategoryUsed(String category){

        if(!categoriesUsed.contains(category) && !category.equals("number")){
            categoriesUsed.add(category);
        }

    }


}
