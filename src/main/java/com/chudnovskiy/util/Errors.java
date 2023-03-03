package com.chudnovskiy.util;

public enum Errors {
    NO_WATER("Отсутствует вода", false),
    NO_COFFEE("Отсутствует молотое кофе.", false),
    NO_ERROR("Ошибки отсутствуют.", true),
    TANK_FULL("Переполнен бак с отработанным кофе.", false);

    public final String label;
    public final boolean status;

    Errors(String label, boolean status) {
        this.label = label;
        this.status = status;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
