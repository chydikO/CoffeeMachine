package com.chudnovskiy.coffeemachine;

import com.chudnovskiy.coffee.Coffee;

public class AmericanoAndEspresso extends CoffeeMachine {
    public AmericanoAndEspresso(String name, int coffee, int water, int wasteTank) {
        super(name, coffee, water, wasteTank);
    }

    @Override
    public void cleaningTheWasteCoffeeTank() {
    }
}
