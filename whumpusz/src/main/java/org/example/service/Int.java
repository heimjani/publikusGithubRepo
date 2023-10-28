package org.example.service;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Int input biztosítása.
 */
public class Int {
    /**
     * Függvény.
     *
     * @return szám.
     */
    public static int getIntInput() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Ez nem szám volt...");
            }
        }
    }
}
