package com.mgil.cousera.course2.week1;

public class WordPlay {


    public boolean isVowel(char ch){

        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }

    }



    public String replaceVowel(String phrase, char ch){

        StringBuilder stringBuilder = new StringBuilder(phrase);
        char [] letters = stringBuilder.toString().toCharArray();

        for(int index = 0 ; index < letters.length ; index++){

            if(isVowel(letters[index])){

                stringBuilder.setCharAt(index, ch);

            }

        }

        return stringBuilder.toString();

    }

    public String emphize(String phrase, char ch ){

        StringBuilder stringBuilder = new StringBuilder(phrase);
        char [] letters = stringBuilder.toString().toCharArray();

        for(int index = 1 ; index <= letters.length ; index++){

                int arrayIndex = index - 1;

                if(Character.toLowerCase(letters[index - 1]) == Character.toLowerCase(ch) ) {

                    if(index % 2 == 0)
                         stringBuilder.setCharAt(arrayIndex, '+');
                    else
                        stringBuilder.setCharAt(arrayIndex ,'*');

                }


        }

        return stringBuilder.toString();

    }




}
