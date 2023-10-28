package org.example.model;

import java.util.Scanner;

import org.example.service.Int;
import org.example.service.editor.Editor;

/**
 * Menü implementálása.
 */
public class Menu {
    /**
     *  Játék kezdete, felhasználói input.

     * @param args név.

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Üdvözöllek a Wumpusz játékban!");
        System.out.print("Kérlek, add meg a felhasználóneved: ");
        String username = scanner.nextLine();

        System.out.println("Üdvözöllek, " + username + "!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenü:");
            System.out.println("1 Pályaszerkesztő");
            System.out.println("2 Játék");
            System.out.println("3 Kilépés");

            int choice = Int.getIntInput();
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