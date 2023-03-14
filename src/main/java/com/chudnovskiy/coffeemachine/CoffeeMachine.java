package com.chudnovskiy.coffeemachine;

import com.chudnovskiy.coffee.Coffee;
import com.chudnovskiy.util.Errors;
import com.chudnovskiy.util.Helper;
import com.chudnovskiy.util.Status;

public abstract class CoffeeMachine {
    private final String name;
    private int coffee;
    private int water;
    private int wasteTank;
    private int wasteTankWhenEmpty;
    private Status status;
    private Errors error;

    public CoffeeMachine(String name, int coffee, int water, int wasteTank) {
        this.name = name;
        this.coffee = coffee;
        this.water = water;
        this.wasteTank = wasteTank;
        this.wasteTankWhenEmpty = wasteTank;
        this.status = Status.OFF;
        this.error = Errors.NO_ERROR;
    }

    public void on() {
        status = Status.ON;
        System.out.println(status.label + "\t" + this.getClass().getSimpleName());
    }

    public void off() {
        status = Status.OFF;
        System.out.println(status.label + "\t" + this.getClass().getSimpleName());
    }

    public void setError(Errors error) {
        this.error = error;
    }

    public Errors getError() {
        return error;
    }

    public int getCoffee() {
        return coffee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean makeCoffee(Coffee coffee) {
        //TODO: хватает ли мне всего для приготовления кофе
        if (!(restOfWasteTank(coffee) && isRemainderCoffee(coffee) && restOfTheWater(coffee))) return false;

        if (status.status && error.status) {
            this.coffee -= coffee.getCoffee();
            this.water -= coffee.getWater();
            this.wasteTank -= coffee.getCoffee();
            printCoffee(coffee);
            Helper.timeSleep();
            System.out.println("\t*-= Кофе готово =-* !!!");
            return true;
        } else {
            System.out.println("-".repeat(20));
            System.out.println(status.label);
            System.out.println("-".repeat(20) + "\n");
        }
        return false;
    }

    private void printCoffee(Coffee coffee) {
        System.out.print(coffee);
    }

    private boolean restOfWasteTank(Coffee coffee) {
        boolean restOfWasteTank = this.wasteTank - coffee.getCoffee() > 0;
        if (!restOfWasteTank) {
            error = Errors.TANK_FULL;
            System.out.println("-".repeat(20));
            System.out.println(error.toString());
            return false;
        }
        return true;
    }

    private boolean restOfTheWater(Coffee coffee) {
        boolean restOfTheWater = this.water - coffee.getWater() > 0;
        if (!restOfTheWater) {
            error = Errors.NO_WATER;
            System.out.println("-".repeat(20));
            System.out.println(error.toString());
            return false;
        }
        return true;
    }

    private boolean isRemainderCoffee(Coffee coffee) {
        boolean isRemainderCoffee = this.coffee - coffee.getCoffee() > 0;
        if (!isRemainderCoffee) {
            error = Errors.NO_COFFEE;
            System.out.println("-".repeat(20));
            System.out.println(error.toString());
            return false;
        }
        return true;
    }

    public void addCoffee(int amountOfCoffee) {
        coffee += amountOfCoffee;
        if (Errors.NO_COFFEE == error) {
            error = Errors.NO_ERROR;
        }
        System.out.println("Добавлено кофе в аппарат:\t" + amountOfCoffee);
    }

    public void addWater(int amountOfWater) {
        water += amountOfWater;
        if (Errors.NO_WATER == error) {
            error = Errors.NO_ERROR;
        }
        System.out.println("Добавлена вода в аппарат:\t" + amountOfWater);
    }

    public void cleaningTheWasteCoffeeTank() {
        wasteTank = wasteTankWhenEmpty;
        if (Errors.TANK_FULL == error) {
            error = Errors.NO_ERROR;
        }
        System.out.println("очищен контейнер с отходами в аппарате:");
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("CoffeeMachine:\t")
                .append("name=")
                .append(name)
                .append(" coffee=")
                .append(coffee)
                .append(" water=")
                .append(water)
                .append(" wasteTank=")
                .append(wasteTank)
                .append(" wasteTankWhenEmpty=")
                .append(wasteTankWhenEmpty)
                .append(" status=")
                .append(status)
                .append(" error=")
                .append(error)
                .toString();
    }
}
