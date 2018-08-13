package com.mgil.cousera.course2.week1;

public class CaesarCipher {

    public String encrypt(String string, int key) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {

            char cipherChar = string.charAt(i);

            if (Character.isUpperCase(cipherChar)) {
                cipherChar = calculateCipher(cipherChar, 65, key);
            } else if (Character.isLowerCase(cipherChar)) {
                cipherChar = calculateCipher(cipherChar, 97, key);
            }

            stringBuilder.append(cipherChar);

        }


        return stringBuilder.toString();

    }


    public String encryptTwoKeys(String string, int key1, int key2) {


        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {

            char currentChar = string.charAt(i);

            if (Util.isEven(i)) {

                if (Character.isUpperCase(currentChar)) {
                    currentChar = calculateCipher(currentChar, 65, key1);
                } else if (Character.isLowerCase(currentChar)) {
                    currentChar = calculateCipher(currentChar, 97, key1);
                }

            } else {

                if (Character.isUpperCase(currentChar)) {
                    currentChar = calculateCipher(currentChar, 65, key2);
                } else if (Character.isLowerCase(currentChar)) {
                    currentChar = calculateCipher(currentChar, 97, key2);
                }
            }


            encrypted.append(currentChar);
        }


        return encrypted.toString();

    }




    private char calculateCipher(char character, int constant, int key) {

        return (char) (((int) character + key - constant) % 26 + constant);

    }
}
