package com.chudnovskiy;

import com.chudnovskiy.coffee.Americano;
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
                500,
                500);
        coffeeMachineRainbow.makeCoffee(new Americano());

        System.out.println();
    }
}
