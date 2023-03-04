package com.chudnovskiy.coffee;

public abstract class CoffeeWithMilk extends Coffee {
    private final int milk;

    public CoffeeWithMilk(int milk) {
        super();
        this.setCoffee(22);
        this.setWater(100);
        this.milk = milk;
    }

    public int getMilk() {
        return milk;
    }
}
