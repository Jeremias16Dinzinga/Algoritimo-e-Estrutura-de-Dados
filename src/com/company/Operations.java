package com.company;

public class Operations {

    //Verify if the currency was already counted
    public static boolean IsThere(float _value, StaticStructure<Currency> countedCurrency) {
        boolean v = false;
        if (countedCurrency.Size() != 0) {
            for (int i = 0; i < countedCurrency.Size(); i++) {
                if (countedCurrency.getElement(i).getValue() == _value) {
                    v = true;
                    break;
                } else {
                    v = false;
                }
            }
        }
        return v;
    }

    //Start to count all the currency
    public void StartToCount(StaticStructure<Currency> listCurrency, StaticStructure<Currency> countedCurrency) {
        for (int i = 0; i < listCurrency.Size(); i++) {
            int count = 0;
            if (!(IsThere(listCurrency.getElement(i).getValue(), countedCurrency))) {
                for (int j = 0; j < listCurrency.Size(); j++) {
                    if (listCurrency.getElement(i).getValue() == listCurrency.getElement(j).getValue()) {
                        count++;
                    }
                }
                countedCurrency.Add(listCurrency.getElement(i));
                System.out.println("* - Tem " + count + " moeda(s) de " + listCurrency.getElement(i).getValue() + " Kz");
            }
        }
    }

    //Sort all the currency by the value of each currency
    public StaticStructure<Currency> sortCurrency(StaticStructure<Currency> listCurrency) {
        for (int i = 0; i < listCurrency.Size(); i++) {
            for (int j = 0; j < listCurrency.Size(); j++) {
                if (listCurrency.getElement(i).getValue() < listCurrency.getElement(j).getValue()) {
                    Currency x = listCurrency.getElement(i);
                    listCurrency.setElement(i, listCurrency.getElement(j));
                    listCurrency.setElement(j, x);
                }
            }
        }
        return listCurrency;
    }

    //Initialize the stack of currency
    public StaticStructure<Currency> InitializeStack() {

        StaticStructure<Currency> stackCurrency = new StaticStructure<>();
        stackCurrency.Add(new Currency<>(100));
        stackCurrency.Add(new Currency<>(200));
        stackCurrency.Add(new Currency<>(50));
        stackCurrency.Add(new Currency<>(200));
        stackCurrency.Add(new Currency<>(10));
        stackCurrency.Add(new Currency<>(20));
        stackCurrency.Add(new Currency<>(10));

        return stackCurrency;
    }
}
