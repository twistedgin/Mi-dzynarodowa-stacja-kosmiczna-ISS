package main;

import database.entity.IssLocation;
import database.utils.HibernateUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HibernateUtils
                .getInstance()
                .getSessionFactory()
                .close();
        System.out.println("a - Podaj predkosc ISS");
        System.out.println("b - Wyswietl liste nadchodzacych przebiegow ISS dla okreslonej lokalizacji");
        System.out.println("c - Wyswietl liczbe osob przebywajacych w kosmosie w ramach ISS");
        System.out.println("d - Wyjdz");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        switch (choice) {
            case "a":
                System.out.println("Predkosc ISS wynosi: ");
                break;
            case "b":
                IssLocation location = new IssLocation();
                System.out.println(location);
                System.out.println("Lista: ");
                break;
            case "c":
                System.out.println("W kosmosie przebywa  " + " osob");
                break;
            default:
                System.out.println("Zły wybor");
        }
    }
}



