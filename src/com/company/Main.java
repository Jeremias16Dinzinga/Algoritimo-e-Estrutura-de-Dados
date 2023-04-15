package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option;
        Scanner reader = new Scanner(System.in);
        StaticStructure<Currency> stackCurrency = new StaticStructure<>();
        Operations operation = new Operations();

        stackCurrency = operation.InitializeStack();

        do {
            System.out.println("\n===== Centro de contagem de moeda nacional =====");
            System.out.println("1 - Adionar moeda.");
            System.out.println("2 - Contar e organizar as moedas.");
            option = reader.nextInt();


            switch (option) {
                case 1:
                    System.out.println("******* Adicionar moeda ********");
                    System.out.println("O valor da moeda:");
                    stackCurrency.Add(new Currency(reader.nextFloat()));
                    break;
                case 2:
                    System.out.println("******* Contagem e organizacao das moedas ********");
                    stackCurrency = operation.sortCurrency(stackCurrency);
                    operation.StartToCount(stackCurrency, new StaticStructure<>());
                    break;
            }
            System.out.println("---------------------------------");
            System.out.println("0 - Sair \n1 - Continuar");
            option = reader.nextInt();
        } while (option != 0);
    }


}
