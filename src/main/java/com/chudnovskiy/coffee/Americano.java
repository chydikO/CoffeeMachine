package com.chudnovskiy.coffee;

public class Americano extends Coffee {
    //американо – 22 г молотого кофе и 100 мл воды.
    public Americano() {
        setCoffee(22);
        setWater(100);
    }

    @Override
    public String toString() {
        return super.toString() + this.getClass().getSimpleName();
    }
}
