package com.mgil.cousera.course2.week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {

    private ArrayList<String> names;
    private ArrayList<Integer> freqs;


    public CharactersInPlay() {
        this.names = new ArrayList<>();
        this.freqs = new ArrayList<>();
    }



    public void findAllCharacters(){

        FileResource fileResource = new FileResource();
        this.findAllCharacters(fileResource.lines());

    }

    public void findAllCharacters(String filePath){
        FileResource fileResource = new FileResource(filePath);
        this.findAllCharacters(fileResource.lines());
    }

    public String findTheMostSpeakingCharacterInFile(String filePath) {


        load(filePath);


        int max = 0 , maxIndex = 0 ;


        for(int index = 0 ; index < freqs.size() ; index++){

            if(freqs.get(index) > max){
                max = freqs.get(index);
                maxIndex = index;
            }

        }


        return String.format("%s->%d\n",names.get(maxIndex),freqs.get(maxIndex));


    }


    private void load(String filePath){

        FileResource fileResource = new FileResource(filePath);

        names.clear();
        freqs.clear();

        for(String line : fileResource.lines()){

            int dotIndex = 0;
            int start = 0;

            while (true){

                dotIndex = line.indexOf(".",start);

                if(dotIndex == -1)
                    break;

                String linePart = line.substring(start,dotIndex);

                update(linePart);

                start = dotIndex + 1;

            }

        }

    }


    public void charactersWithNumPartsInFile(String file,int num1,int num2) {

        load(file);
        this.charactersWithNumParts(num1,num2);

    }


        public void charactersWithNumParts(int num1,int num2){

        for(int index = 0 ; index < names.size() ; index++){

            if(freqs.get(index) >= num1 && freqs.get(index) <= num2){

                System.out.printf("%s - %d\n",names.get(index),freqs.get(index));

            }

        }

    }


    public void findAllCharacters(Iterable<String> lines) {

        for(String line : lines){

            int dotIndex = 0;
            int start = 0;

            while (true){

                dotIndex = line.indexOf(".",start);

                if(dotIndex == -1)
                    break;

                String linePart = line.substring(start,dotIndex);

                update(linePart);

                start = dotIndex + 1;

            }

        }

        printResult();

    }

    private void printResult() {

        for(int index = 0 ; index < names.size() ; index++){

            if(freqs.get(index) > 1)
                 System.out.printf("%s - %d\n",names.get(index), freqs.get(index));

        }

    }


    private void update(String person){


        int index = names.indexOf(person);

        if( index == -1){
            names.add(person);
            freqs.add(1);
        }else{
            int count = freqs.get(index);
            count +=1;
            freqs.set(index,count);
        }

    }


}
