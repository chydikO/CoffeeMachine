package com.chudnovskiy.coffee;

public class Espresso extends Coffee {
    //эспрессо – 22 г молотого кофе и 30 мл;
    public Espresso(int coffee, int water) {
        super(coffee, water);
    }

    public Espresso() {
        super(22, 30);
    }
    @Override
    public String toString() {
        return super.toString() + this.getClass().getSimpleName();
    }
}
