package com.chudnovskiy.coffeemachine;

import com.chudnovskiy.coffee.Cappuccino;
import com.chudnovskiy.coffee.Coffee;
import com.chudnovskiy.coffee.CoffeeWithMilk;
import com.chudnovskiy.coffee.Latte;
import com.chudnovskiy.util.Errors;

/**
 * Задание 2
 * После модернизации, завод начал выпускать новые кофе-
 * машины, позволяющие кроме предыдуших функций гото-
 * вить капучино и лате.
 * Добавилась встроенная емкость для молока, размер емко-
 * сти зависит от марки кофемашины.
 * <p>
 * Добавилась ошибка:
 * ■ Отсутствует молоко.
 * <p>
 * Добавились кнопки:
 * ■ Приготовить лате;
 * ■ Приготовить капучино.
 * <p>
 * Количество молока, которое тратится на приготовление
 * капучино и лате, задается во время приготовления. Коли-
 * чество потребляемого кофе и воды, как при приготовлении
 * чашки эспрессо.
 * Протестировать новые модели кофемашин. Все предыду-
 * шие тесты должны быть зелеными. Переиспользовать код из
 * предыдушего задания.
 */
public class CappuccinoAndLatte extends AmericanoAndEspresso {
    private int milkContainer;
    private IMakingCoffee iMakingCoffee = coffee -> {
        //if (!restOfTheMilk(coffee)) return false;
    if (!CappuccinoAndLatte.super.makeCoffee(coffee)) return false;

    if (coffee instanceof Cappuccino) {
        makeCappuccino(coffee);
    } else if (coffee instanceof Latte) {
        makeLatte(coffee);
    } else {
        CappuccinoAndLatte.super.makeCoffee(coffee);
    }
    return true;
    };

    public CappuccinoAndLatte(String name, int coffee, int water, int wasteTank, int milkContainer) {
        super(name, coffee, water, wasteTank);
        this.milkContainer = milkContainer;
    }

    public void addMilk(int amountOfMilk) {
        milkContainer += amountOfMilk;
        if (Errors.NO_MILK == getError()) {
            setError(Errors.NO_ERROR);
        }
        System.out.println("Добавлено молоко в аппарат:\t" + amountOfMilk);
    }

    private void makeLatte(Coffee coffee) {
        this.milkContainer -= ((Latte) coffee).getMilk();
        System.out.println("Латте готово");
    }

    private void makeCappuccino(Coffee coffee) {
        this.milkContainer -= ((Cappuccino) coffee).getMilk();
        System.out.println("Каппучино готово");
    }

    private boolean restOfTheMilk(Coffee coffee) {
        if (!(coffee instanceof CoffeeWithMilk)) {
            System.out.println("Необходимо выбрать кофе с молоком");
            return false;
        }

        boolean isRestOfTheMilk = this.milkContainer - ((CoffeeWithMilk) coffee).getMilk() > 0;
        if (!isRestOfTheMilk) {
            setError(Errors.NO_MILK);
            System.out.println("-".repeat(20));
            System.out.println(getError().toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean makeCoffee(Coffee coffee) {
        return iMakingCoffee.makeCoffee(coffee);
    }

    //    @Override
//    public boolean makeCoffee(Coffee coffee) {
//        //if (!restOfTheMilk(coffee)) return false;
//        if (!super.makeCoffee(coffee)) return false;
//
//        if (coffee instanceof Cappuccino) {
//            makeCappuccino(coffee);
//        } else if (coffee instanceof Latte) {
//            makeLatte(coffee);
//        } else {
//            super.makeCoffee(coffee);
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append(" milkContainer=").append(milkContainer).toString();
    }
}
