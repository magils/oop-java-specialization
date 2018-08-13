package com.mgil.cousera.course2.week1;

public class OOCaesarCipher {

    private final String ALPHABET;
    private final String SHIFTED_ALPHABET;
    private final int KEY;


    public OOCaesarCipher(int key){

        StringBuilder letters = new StringBuilder();

        for(char letter = 'a' ; letter <= 'z' ; letter++) {
            letters.append(letter);
        }

        ALPHABET = letters.toString();
        SHIFTED_ALPHABET = ALPHABET.substring(key) + ALPHABET.substring(0,key);
        KEY = key;
    }


    public String encrypt(String string) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {

            char cipherChar = string.charAt(i);

            if (Character.isUpperCase(cipherChar)) {
                cipherChar = calculateCipher(cipherChar, 65, KEY);
            } else if (Character.isLowerCase(cipherChar)) {
                cipherChar = calculateCipher(cipherChar, 97, KEY);
            }

            stringBuilder.append(cipherChar);

        }


        return stringBuilder.toString();

    }


    public String decrypt(String input){
        OOCaesarCipher self = new OOCaesarCipher(26 - KEY);
        return self.encrypt(input);
    }



    private char calculateCipher(char character, int constant, int key) {

        return (char) (((int) character + key - constant) % 26 + constant);

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

    public String getAlphabet() {
        return ALPHABET;
    }

    public String getShiftedAlphabet() {
        return SHIFTED_ALPHABET;
    }

    public int getKey() {
        return KEY;
    }
}
