package com.chudnovskiy.coffeemachine;

import com.chudnovskiy.coffee.Coffee;
import com.chudnovskiy.util.Errors;
import com.chudnovskiy.util.Status;

public abstract class CoffeeMachine {
    private String name;
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

    public boolean makeCoffee(Coffee coffee) {
        //TODO: хватает ли мне всего для приготовления кофе
        if (!(restOfWasteTank(coffee) && isRemainderCoffee(coffee) && restOfTheWater(coffee))) return false;

        if (status.status && error.status) {
            this.coffee -= coffee.getCoffee();
            this.water -= coffee.getWater();
            this.wasteTank -= coffee.getCoffee();
            System.out.print(coffee);
            timeSleep();
            System.out.println("\t*-= Кофе готово =-* !!!");
            return true;
        } else {
            System.out.println("-".repeat(20));
            System.out.println(status.label);
//            System.err.println(error.label);
            System.out.println("-".repeat(20) + "\n");
        }
        //TODO: проверка всех индиградиентов, если чего-то закончилось - ошибка
        return false;
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

    private void timeSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
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
}
