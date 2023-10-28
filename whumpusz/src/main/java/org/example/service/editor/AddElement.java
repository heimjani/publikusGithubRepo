package org.example.service.editor;

import java.util.Scanner;

import org.example.service.Inicializalas;

/**
 * Hozzáadás.
 */
public class AddElement {

    public static int N = Editor.N;

    /**
     * Függvény.
     *
     * @param element elem.
     */
    public static void addElement(char element) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add meg a pozíciót (pl. 'c3'): ");
        String position = scanner.nextLine().toUpperCase();
        if (position.length() != 2 || !Character.isLetter(position.charAt(0)) || !Character.isDigit(position.charAt(1))) {
            System.out.println("Érvénytelen pozíció formátum. Használj pl. 'a1' formátumot.");
            return;
        }

        int x = position.charAt(0) - 'A' + 1;
        int y = Character.getNumericValue(position.charAt(1));

        if (x < 1 || x >= N - 1 || y < 1 || y >= N - 1) {
            System.out.println("Nem módosíthatsz a szélekhez közeli pozíciókat.");
            return;
        }

        if (Inicializalas.board[y][x] == ' ') {
            Inicializalas.board[y][x] = element;
        } else {
            System.out.println("A megadott pozíció már foglalt.");
        }
    }
}
