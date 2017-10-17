package com.example.top.myapplication;

/**
 * Created by top on 2017/10/17.
 */

public class Person extends Hero{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
