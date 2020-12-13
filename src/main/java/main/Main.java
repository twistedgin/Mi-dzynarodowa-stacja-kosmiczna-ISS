package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("a - Podaj predkosc ISS");
        System.out.println("b - Wyswietl liste nadchodzacych przebiegow ISS dla okreslonej lokalizacji");
        System.out.println("c - Podaj liczbe osob przebywajacych w kosmosie w ramach ISS");
        System.out.println("d - Wyjdz");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        switch (choice) {
            case "a":
                System.out.println("Predkosc ISS wynosi: ");
                break;
            case "b":
                System.out.println("Lista: ");
                break;
            case "c":
                System.out.println("W kosmosie przebywa " + " osob");
                break;
            default:
                System.out.println("Zły wybor");
        }
    }
}



