package com.louhwz.sbdata.utils;


public class Sbdata {
    private String name;
    private String description;
    private int number;
    private int days;

    public int getDays() {
        return days;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
