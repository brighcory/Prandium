package com.merlin.bright.cory.prandium.models;

/**
 * Created by cory on 6/9/17.
 */

public class Calender {
    private int day;
    private String month;
    private int year;
    private String[] meal = {"Breakfast", "Lunch", "Dinner"};

    public Calender(int day, String month, int year, String[] meal) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.meal = meal;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String[] getMeal() {
        return meal;
    }

    public void setMeal(String[] meal) {
        this.meal = meal;
    }
}
