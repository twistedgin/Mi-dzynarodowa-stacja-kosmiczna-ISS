package main;

import database.entity.IssLocation;
import database.utils.HibernateUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

import static api.JsonReader.readJsonFromUrl;

public class Main {

    public static void main(String[] args)  throws IOException, JSONException {
            JSONObject json = readJsonFromUrl("http://api.open-notify.org/astros.json");


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

                break;
            case "c":

                System.out.println("W kosmosie przebywa " +json.get("number")+ " osob.") ;

/*
                System.out.println(json.toString()); do zedytowania lista zalogi
*/

                break;
            default:
                System.out.println("Zły wybor");
        }
    }
}



