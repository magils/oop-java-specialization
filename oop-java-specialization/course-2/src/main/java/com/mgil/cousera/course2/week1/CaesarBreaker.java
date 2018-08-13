package com.mgil.cousera.course2.week1;

public class CaesarBreaker {

    private final String ALPHABET;


    public CaesarBreaker(){

        StringBuilder letters = new StringBuilder();

        for(char letter = 'a' ; letter <= 'z' ; letter++) {
            letters.append(letter);
        }

        ALPHABET = letters.toString();
    }


    public String decrypt(String encrypted){

        int[] freqs = countLetters(encrypted);
        int maxIndex = maxIndex(freqs);

        int  decryptionKey = maxIndex - 4;

        if(maxIndex < 4)
            decryptionKey = 26 - (4 - maxIndex);

        CaesarCipher cipher = new CaesarCipher();

        return cipher.encrypt(encrypted , 26 - decryptionKey);

    }

    public int[] countLetters(String encrypted){
        int counts[] = new int[26];

        for(char c : encrypted.toCharArray()) {

            int letterIndex = ALPHABET.indexOf(Character.toLowerCase(c));

            if(letterIndex == -1)
                continue;

            counts[letterIndex] += 1;

        }

        return counts;
    }


    public int maxIndex(int[] freqs){

        int maxFreq = 0 ,maxIndex = 0;

        for(int index = 0 ; index < freqs.length ; index++) {

            if(freqs[index] > maxFreq) {
                maxFreq = freqs[index];
                maxIndex = index;
            }
        }

        return maxIndex;

    }

    public String halfOfString(String string, int offset){

        StringBuilder stringBuilder = new StringBuilder();

        for(; offset < string.length(); offset+=2){

            stringBuilder.append(string.charAt(offset));

        }

        return stringBuilder.toString();
    }

    public int getKey(String encrypted){

        int[] freqs = countLetters(encrypted);
        int maxIndex = maxIndex(freqs);

        int  decryptionKey = maxIndex - 4;

        if(maxIndex < 4)
            decryptionKey = 26 - (4 - maxIndex);

        return decryptionKey;

    }



    public DecryptionKeys decryptTwoKeys(String encrypted) {

        String firstEncrypted = halfOfString(encrypted,0);
        String secondEncrypted = halfOfString(encrypted,1);

        int key1 = getKey(firstEncrypted);
        int key2 = getKey(secondEncrypted);

        return new DecryptionKeys(key1,key2);
    }




}
