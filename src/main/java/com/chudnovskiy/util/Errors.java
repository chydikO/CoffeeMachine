package com.chudnovskiy.util;

public enum Errors {
    NO_WATER("Отсутствует вода"),
    NO_COFFEE("Отсутствует молотое кофе."),
    NO_ERROR("Ошибки отсутствуют."),
    TANK_FULL("Переполнен бак с отработанным кофе.");

    public final String label;

    Errors(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
