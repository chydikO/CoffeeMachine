package com.chudnovskiy.coffeemachine;

import com.chudnovskiy.util.Errors;
import com.chudnovskiy.util.Status;

public abstract class CoffeeMachine {
    private String name;
    private int coffee;
    private int water;
    private int wasteTank;
    private Status status;
    private Errors error;

    public CoffeeMachine(String name, int coffee, int water, int wasteTank) {
        this.name = name;
        this.coffee = coffee;
        this.water = water;
        this.wasteTank = wasteTank;
        this.status = Status.OFF;
        this.error = Errors.NO_ERROR;
    }

    public Errors getError() {
        return error;
    }

    public void setError(Errors error) {
        this.error = error;
    }

    public void on() {
        status = Status.ON;
    }
    public void off() {
        status = Status.OFF;
    }

    public abstract boolean cleaningTheWasteCoffeeTank();
    public abstract boolean makeCoffee() ;
    public abstract void addCoffee();
    public abstract void addWater();
}
