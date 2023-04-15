package com.company;

public class Currency<T> {
    private float value;

    public Currency(float value) {
        this.value = value;
    }

    public Currency() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


}
