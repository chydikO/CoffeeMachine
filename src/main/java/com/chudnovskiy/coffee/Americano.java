package com.chudnovskiy.coffee;

public class Americano extends Coffee {
    //американо – 22 г молотого кофе и 100 мл воды.
    public Americano(int coffee, int water) {
        super(coffee, water);
    }

    public Americano() {
        super(22, 100);
    }

    @Override
    public String toString() {
        return super.toString() + this.getClass().getSimpleName();
    }
}
