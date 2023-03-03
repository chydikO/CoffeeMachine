package com.chudnovskiy.coffeemachine;

import com.chudnovskiy.coffee.Coffee;
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

    public abstract void cleaningTheWasteCoffeeTank();

    public void makeCoffee(Coffee coffee) {
        //TODO: хватает ли мне всего для приготовления кофе
        if (Status.ON.status && Errors.NO_ERROR.status) {
            this.coffee -= coffee.getCoffee();
            this.water -= coffee.getWater();
            this.wasteTank -= coffee.getCoffee();
            System.out.println(coffee);
        }
        //TODO: проверка всех индиградиентов, если чего-то закончилось - ошибка
    }

    public void addCoffee(int amountOfCoffee) {
        coffee += amountOfCoffee;
    }
    public void addWater(int amountOfWater) {
        water += amountOfWater;
    }
}
