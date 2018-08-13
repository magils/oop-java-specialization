package com.mgil.cousera.course2.week1;

public class OOCaesarCipherTwo {

    private final String ALPHABET;
    private final String SHIFTED_ALPHABET_1;
    private final String SHIFTED_ALPHABET_2;
    private final int KEY1;
    private final int KEY2;


    public OOCaesarCipherTwo(int key1,int key2){

        StringBuilder letters = new StringBuilder();

        for(char letter = 'a' ; letter <= 'z' ; letter++) {
            letters.append(letter);
        }

        ALPHABET = letters.toString();
        SHIFTED_ALPHABET_1 = ALPHABET.substring(key1) + ALPHABET.substring(0,key1);
        SHIFTED_ALPHABET_2 = ALPHABET.substring(key2) + ALPHABET.substring(0,key2);
        KEY1 = key1;
        KEY2 = key2;
    }



    public String encrypt(String string) {


        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {

            char currentChar = string.charAt(i);

            if (Util.isEven(i)) {

                if (Character.isUpperCase(currentChar)) {
                    currentChar = calculateCipher(currentChar, 65, KEY1);
                } else if (Character.isLowerCase(currentChar)) {
                    currentChar = calculateCipher(currentChar, 97, KEY1);
                }

            } else {

                if (Character.isUpperCase(currentChar)) {
                    currentChar = calculateCipher(currentChar, 65, KEY2);
                } else if (Character.isLowerCase(currentChar)) {
                    currentChar = calculateCipher(currentChar, 97, KEY2);
                }
            }


            encrypted.append(currentChar);
        }


        return encrypted.toString();

    }


    public String decrypt(String input){

        OOCaesarCipherTwo self = new OOCaesarCipherTwo(26 - KEY1, 26 - KEY2);

        return self.encrypt(input);

    }



    public String halfOfString(String string, int offset){

        StringBuilder stringBuilder = new StringBuilder();

        for(; offset < string.length(); offset+=2){

            stringBuilder.append(string.charAt(offset));

        }

        return stringBuilder.toString();
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


    public DecryptionKeys breakCaesarCipher(String encrypted){

        String firstEncrypted = halfOfString(encrypted,0);
        String secondEncrypted = halfOfString(encrypted,1);

        int key1 = getKey(firstEncrypted);
        int key2 = getKey(secondEncrypted);

        return new DecryptionKeys(key1,key2);

    }

    private int getKey(String encrypted){

        int[] freqs = countLetters(encrypted);
        int maxIndex = maxIndex(freqs);

        int  decryptionKey = maxIndex - 4;

        if(maxIndex < 4)
            decryptionKey = 26 - (4 - maxIndex);

        return decryptionKey;

    }



    private char calculateCipher(char character, int constant, int key) {

        return (char) (((int) character + key - constant) % 26 + constant);

    }






    public String getALPHABET() {
        return ALPHABET;
    }

    public String getSHIFTED_ALPHABET_1() {
        return SHIFTED_ALPHABET_1;
    }

    public String getSHIFTED_ALPHABET_2() {
        return SHIFTED_ALPHABET_2;
    }

    public int getKEY1() {
        return KEY1;
    }

    public int getKEY2() {
        return KEY2;
    }
}
