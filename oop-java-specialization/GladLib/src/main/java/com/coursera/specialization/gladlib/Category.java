package com.coursera.specialization.gladlib;

public enum Category {

    ADJECTIVE,
    NOUN,
    COLOR,
    COUNTRY,
    NAME,
    ANIMAL,
    TIMEFRAME,
    VERB,
    FRUIT;

    public String getName(){
        return this.name().toLowerCase()+".txt";
    }

}
