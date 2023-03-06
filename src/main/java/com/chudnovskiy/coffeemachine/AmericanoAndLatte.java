package com.chudnovskiy.coffeemachine;

import com.chudnovskiy.coffee.Americano;
import com.chudnovskiy.coffee.Coffee;
import com.chudnovskiy.coffee.Latte;
import com.chudnovskiy.util.Errors;
import com.chudnovskiy.util.Helper;
import com.chudnovskiy.util.Status;

/**
 * Задание 3
 * После модернизации, завод начал выпускать новые кофе-
 * машины, в которые можно загружать, кроме молотого кофе,
 * еще и немолотый кофе. Машина сама мелет кофе. Размер
 * бака для немолотого кофе зависит от модели. Зерновое кофе
 * после помолки попадает в бак для молотого кофе и уже от-
 * туда идет в приготовление.
 * Чтобы удешевить машины, маркетинговый отдел приду-
 * мал сократить функции этих кофемашин.
 * Данные кофемашины умеют готовить только:
 * ■ американо;
 * ■ лате.
 * Протестировать новую кофемашину.
 * Предыдушие тесты должны быть зелеными.
 * Добавились ошибки:
 * ■ Отсутвует зерновое кофе.
 */
public class AmericanoAndLatte  extends CappuccinoAndLatte {

    private int coffeeBeans;

    public AmericanoAndLatte(String name, int coffee, int coffeeBeans, int water, int wasteTank, int milkContainer) {
        super(name, coffee, water, wasteTank, milkContainer);
        this.coffeeBeans = Math.max(coffeeBeans, 0);
        if (this.coffeeBeans == 0) {
            setError(Errors.NO_COFFEE_BEANS);
        } else {
            setStatus(Status.ON);
            grindingCoffee();
            setStatus(Status.OFF);
        }
    }

    public void grindingCoffee() {
        if (coffeeBeans > 0 && getStatus() == Status.ON) {
            System.out.println("-= Выполняется помол кофе =-");
            Helper.timeSleep();
            addCoffee(getCoffee() + coffeeBeans);
        } else {
            System.out.println(getStatus().label);
            System.out.println("Включите аппарат и повторите операцию");
        }
    }

    @Override
    public boolean makeCoffee(Coffee coffee) {
        if (coffee instanceof Latte || coffee instanceof Americano) {
            super.makeCoffee(coffee);
            return true;
        }
        return false;
    }
}
