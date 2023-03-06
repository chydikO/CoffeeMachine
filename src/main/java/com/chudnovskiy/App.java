package com.chudnovskiy;

import com.chudnovskiy.coffee.Americano;
import com.chudnovskiy.coffee.Cappuccino;
import com.chudnovskiy.coffee.Espresso;
import com.chudnovskiy.coffee.Latte;
import com.chudnovskiy.coffeemachine.AmericanoAndEspresso;
import com.chudnovskiy.coffeemachine.AmericanoAndLatte;
import com.chudnovskiy.coffeemachine.CappuccinoAndLatte;
import com.chudnovskiy.coffeemachine.CoffeeMachine;

public class App {
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
//        CoffeeMachine coffeeMachineRainbow = new AmericanoAndEspresso(
//                "Rainbow-I",
//                100,
//                120,
//                120);
//        coffeeMachineRainbow.on();
//        coffeeMachineRainbow.makeCoffee(new Americano());
//        coffeeMachineRainbow.makeCoffee(new Espresso());
//        coffeeMachineRainbow.makeCoffee(new Americano());
//        coffeeMachineRainbow.addWater(300);
//        coffeeMachineRainbow.makeCoffee(new Espresso());
//
//        coffeeMachineRainbow.makeCoffee(new Americano());
//        coffeeMachineRainbow.addCoffee(25);
//        coffeeMachineRainbow.makeCoffee(new Espresso());
//        coffeeMachineRainbow.makeCoffee(new Americano());
//        coffeeMachineRainbow.makeCoffee(new Espresso());
//
//        coffeeMachineRainbow.makeCoffee(new Americano());
//        coffeeMachineRainbow.cleaningTheWasteCoffeeTank();
//        coffeeMachineRainbow.makeCoffee(new Espresso());
//
//        coffeeMachineRainbow.addCoffee(50);
//        coffeeMachineRainbow.makeCoffee(new Espresso());
//
//        coffeeMachineRainbow.off();
//        coffeeMachineRainbow = null;
//
//
//
//        CoffeeMachine coffeeMilkMachine = new CappuccinoAndLatte(
//                "Tefal-2243",
//                100,
//                220,
//                120,
//                200);
//        coffeeMilkMachine.on();
//
//        coffeeMilkMachine.makeCoffee(new Latte(50));
//        System.out.println(coffeeMilkMachine);
//
//        coffeeMilkMachine.makeCoffee(new Cappuccino(60));
//        System.out.println(coffeeMilkMachine);
//
//        coffeeMilkMachine.makeCoffee(new Cappuccino(200));
//        System.out.println(coffeeMilkMachine);
//
//
//        coffeeMilkMachine.addWater(300);
//        ((CappuccinoAndLatte) coffeeMilkMachine).addMilk(200);
//        System.out.println(coffeeMilkMachine);
//
//        coffeeMilkMachine.makeCoffee(new Cappuccino(200));

        AmericanoAndLatte americanoAndLatte = new AmericanoAndLatte(
                "Americano And Latte",
                50,
                100,
                300,
                350,
                200);
        americanoAndLatte.on();

        americanoAndLatte.makeCoffee(new Latte(50));
        americanoAndLatte.makeCoffee(new Americano());

        System.out.println(americanoAndLatte);
    }
}
