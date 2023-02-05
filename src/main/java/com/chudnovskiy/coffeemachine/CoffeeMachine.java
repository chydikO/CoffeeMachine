package com.chudnovskiy.coffeemachine;

import com.chudnovskiy.util.Errors;

public class CoffeeMachine {
    private int coffee;
    private int water;
    private int wasteTank;
    private Errors error;

    public CoffeeMachine(int coffee, int water, int wasteTank, Errors error) {
        this.coffee = coffee;
        this.water = water;
        this.wasteTank = wasteTank;
        this.error = error;
    }

    public Errors getError() {
        return error;
    }

    public void setError(Errors error) {
        this.error = error;
    }

    public boolean on() {
        return false;
    }
    public boolean shutdown() {
        return false;
    }
    public boolean cleaningTheWasteCoffeeTank() {
        return false;
    }

    public boolean makeCoffee() {
        return false;
    }

    public void addCoffee() {

    }

    public void addWater() {

    }
}
