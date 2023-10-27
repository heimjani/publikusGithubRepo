package org.example.service;

import java.util.Scanner;


public class Editor {
    private static char[][] board;
    public static int N;
    private static int wumpusCount;
    private static boolean hasGold;
    private static int heroX;
    private static int heroY;
    private static String heroDirection;

    public static void editMap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add meg a pálya méretét: ");
        N = scanner.nextInt();
        if (N < 6 || N > 20) {
            System.out.println("Érvénytelen szám, minimum 6, maximum 20 nagyságú lehet");
            return;
        }
        Inicializalas.initializeBoard();
        wumpusCount = N <= 8 ? 1 : (N <= 14 ? 2 : 3);
        hasGold = false;

        System.out.println("Pálya szerkesztése:");
        Board.printBoard();

        boolean editing = true;
        while (editing) {
            System.out.println("\nSzerkesztési lehetőségek:");
            System.out.println("1 FAL hozzáadása");
            System.out.println("2 VEREM hozzáadása");
            System.out.println("3 WUMPUSZ hozzáadása (" + wumpusCount + " db maradt)");
            System.out.println("4 ARANY hozzáadása");
            System.out.println("5 HŐS hozzáadása");
            System.out.println("6 Szerkesztés befejezése");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            switch (choice) {
                case 1:
                    addElement('W');
                    break;
                case 2:
                    addElement('P');
                    break;
                case 3:
                    if (wumpusCount > 0) {
                        addElement('U');
                        wumpusCount--;
                    } else {
                        System.out.println("Nincs több wumpusz hozzáadható.");
                    }
                    break;
                case 4:
                    if (!hasGold) {
                        addElement('G');
                        hasGold = true;
                    } else {
                        System.out.println("Már van arany a pályán.");
                    }
                    break;
                case 5:
                    addHero();
                    break;
                case 6:
                    editing = false;
                    break;
                default:
                    System.out.println("Érvénytelen választás.");
                    break;
            }

            Board.printBoard();
        }
    }

    private static void addElement(char element) {
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

        if (Inicializalas.board[y][x] == ' ') {
            Inicializalas.board[y][x] = element;
        } else {
            System.out.println("A megadott pozíció már foglalt.");
        }
    }

    private static void addHero() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add meg a HŐS kezdő pozícióját (pl. 'c3'): ");
        String position = scanner.nextLine().toUpperCase();
        if (position.length() != 2 || !Character.isLetter(position.charAt(0)) || !Character.isDigit(position.charAt(1))) {
            System.out.println("Érvénytelen pozíció formátum. Használj pl. 'a1' formátumot.");
            return;
        }

        int x = position.charAt(0) - 'A' + 1;
        int y = Character.getNumericValue(position.charAt(1));

        if (x < 1 || x >= N - 1 || y < 1 || y >= N - 1) {
            System.out.println("A HŐS nem helyezhető a szélekhez vagy a falhoz közel.");
            return;
        }

        if (Inicializalas.board[y][x] == ' ') {
            Inicializalas.board[y][x] = 'H';
            heroX = x;
            heroY = y;

            System.out.print("Add meg a HŐS kezdő irányát (felfelé, lefelé, balra, jobbra): ");
            heroDirection = scanner.nextLine();
            System.out.println("HŐS hozzáadva!");
        } else {
            System.out.println("A megadott pozíció már foglalt.");
        }
    }
}
