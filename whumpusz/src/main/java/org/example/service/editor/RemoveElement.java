package org.example.service.editor;

import java.util.Scanner;

import org.example.service.Inicializalas;

/**
 * Elem eltávolítása.
 */
public class RemoveElement {
    public static int N = Editor.N;

    /**
     * Függvény.
     *
     * @param element elem.
     */
    public static void removeElement(char element) {
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
            System.out.println("Nem módosíthatsz a szélekhez vagy a falhoz közeli pozíciókat.");
            return;
        }

        if (Inicializalas.board[y][x] == element) {
            Inicializalas.board[y][x] = ' ';
            System.out.println("Elem eltávolítva!");
        } else {
            System.out.println("A megadott pozíció nem tartalmazza a megadott elemet.");
        }

    }

}
