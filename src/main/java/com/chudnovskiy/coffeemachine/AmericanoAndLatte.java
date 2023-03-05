package com.chudnovskiy.coffeemachine;

public class git  extends CappuccinoAndLatte {

    private int notGroundCoffee;

    public AmericanoAndLatte(String name, int coffee, int notGroundCoffee, int water, int wasteTank, int milkContainer) {
        super(name, coffee, water, wasteTank, milkContainer);
        this.notGroundCoffee = notGroundCoffee;
    }
}
