package com.chudnovskiy.coffee;

public class Latte extends CoffeeWithMilk {

    public Latte(int milk) {
        super(milk);
    }

    @Override
    public String toString() {
        return super.toString() + this.getClass().getSimpleName();
    }
}
