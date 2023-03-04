package com.chudnovskiy.coffee;

public class Cappuccino extends CoffeeWithMilk{

    public Cappuccino(int milk) {
        super(milk);
    }

    @Override
    public String toString() {
        return super.toString() + this.getClass().getSimpleName();
    }
}
