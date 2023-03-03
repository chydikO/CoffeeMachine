package com.chudnovskiy.util;

public enum Status {
    ON("Автомат включен", true),
    OFF("Автомат выключен", false);

    public final String label;
    public final boolean status;

    Status(String label, boolean status) {
        this.label = label;
        this.status = status;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
