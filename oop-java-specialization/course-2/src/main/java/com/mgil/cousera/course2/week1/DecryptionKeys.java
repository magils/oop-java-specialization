package com.mgil.cousera.course2.week1;

public class DecryptionKeys {

    private int firstKey;
    private int secondKey;

    public DecryptionKeys(int firstKey, int secondKey) {
        this.firstKey = firstKey;
        this.secondKey = secondKey;
    }

    public int getFirstKey() {
        return firstKey;
    }

    public int getSecondKey() {
        return secondKey;
    }

    @Override
    public String toString() {
        return "DecryptionKeys{" +
                "firstKey=" + firstKey +
                ", secondKey=" + secondKey +
                '}';
    }
}
