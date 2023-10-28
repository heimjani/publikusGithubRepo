package org.example.service.editor;

import java.util.Scanner;

import org.example.service.Inicializalas;

/**
 * Wumpusz hozzáadása.
 */
public class AddWumpusz {
    public static int N = Editor.N;
    public static int wumpusCount = Editor.wumpusCount;

    /**
     * Függvény.
     */
    public static void addWumpusz() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add meg a WUMPUSZ kezdő pozícióját (pl. 'c3'): ");
        String position = scanner.nextLine().toUpperCase();
        if (position.length() != 2 || !Character.isLetter(position.charAt(0)) || !Character.isDigit(position.charAt(1))) {
            System.out.println("Érvénytelen pozíció formátum. Használj pl. 'a1' formátumot.");
            return;
        }

        int x = position.charAt(0) - 'A' + 1;
        int y = Character.getNumericValue(position.charAt(1));

        if (x < 1 || x >= N - 1 || y < 1 || y >= N - 1) {
            System.out.println("A WUMPUSZ nem helyezhető a szélekhez közel.");
            return;
        }

        if (Inicializalas.board[y][x] == ' ') {
            Inicializalas.board[y][x] = 'U';
            wumpusCount--;
            System.out.println("Felkelt egy WUMPUSZ");
        } else {
            System.out.println("A megadott pozíció már foglalt.");
        }
    }
}
