package org.example.service;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Üdvözöllek a Wumpusz játékban!");
        System.out.print("Kérlek, add meg a felhasználóneved: ");
        String username = scanner.nextLine();

        System.out.println("Üdvözöllek, " + username + "!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nAlapmenü:");
            System.out.println("1 Pályaszerkesztés");
            System.out.println("2 Játék");
            System.out.println("3 Kilépés");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Editor.editMap();
                    break;
                case 2:
                    //TODO
                    // playGame();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Nincs ilyen lehetőség");
                    break;
            }
        }

        System.out.println("Köszönjük, hogy játszottál!");

    }
}