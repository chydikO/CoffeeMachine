package com.chudnovskiy.coffee;

public abstract class Coffee {
    private int coffee;
    private int water;

    public Coffee() {
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    @Override
    public String toString() {
        return "Готовится кофе:\t";
    }
}
