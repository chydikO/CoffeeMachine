package com.chudnovskiy;

import com.chudnovskiy.coffee.Americano;
import com.chudnovskiy.coffee.Espresso;
import com.chudnovskiy.coffeemachine.AmericanoAndEspresso;
import com.chudnovskiy.coffeemachine.CoffeeMachine;

public class App {
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        CoffeeMachine coffeeMachineRainbow = new AmericanoAndEspresso(
                "Rainbow-I",
                100,
                120,
                120);
        coffeeMachineRainbow.on();
        coffeeMachineRainbow.makeCoffee(new Americano());
        coffeeMachineRainbow.makeCoffee(new Espresso());
        coffeeMachineRainbow.makeCoffee(new Americano());
        coffeeMachineRainbow.addWater(300);
        coffeeMachineRainbow.makeCoffee(new Espresso());

        coffeeMachineRainbow.makeCoffee(new Americano());
        coffeeMachineRainbow.addCoffee(25);
        coffeeMachineRainbow.makeCoffee(new Espresso());
        coffeeMachineRainbow.makeCoffee(new Americano());
        coffeeMachineRainbow.makeCoffee(new Espresso());

        coffeeMachineRainbow.makeCoffee(new Americano());
        coffeeMachineRainbow.cleaningTheWasteCoffeeTank();
        coffeeMachineRainbow.makeCoffee(new Espresso());

        coffeeMachineRainbow.addCoffee(50);
        coffeeMachineRainbow.makeCoffee(new Espresso());

        System.out.println();
    }
}
