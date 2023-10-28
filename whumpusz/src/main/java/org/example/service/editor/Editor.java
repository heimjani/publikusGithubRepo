package org.example.service.editor;

import org.example.service.Board;
import org.example.service.Inicializalas;
import org.example.service.Int;


/**
 * Pályaszerkesztő.
 */
public class Editor {
    public static int N;
    public static int wumpusCount;
    private static boolean hasGold;
private static boolean hasHero;

    /**
     * Szerkesztés kezdete.
     */
    public static void editMap() {


        System.out.print("Add meg a pálya méretét: ");


        N = Int.getIntInput();
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
            System.out.println("3 WUMPUSZ hozzáadása (" + AddWumpusz.wumpusCount + " db maradt)");
            System.out.println("4 ARANY hozzáadása");
            System.out.println("5 HŐS hozzáadása");
            System.out.println("6 FAL eltávolítása");
            System.out.println("7 VEREM eltávolítása");
            System.out.println("8 WUMPUSZ eltávolítása");
            System.out.println("9 ARANY eltávolítása");
            System.out.println("10 HŐS eltávolítása");
            System.out.println("11 Szerkesztés befejezése");

            int choice = Int.getIntInput();

            switch (choice) {
                case 1:
                    AddElement.addElement('W');
                    break;
                case 2:
                    AddElement.addElement('P');
                    break;
                case 3:
                    if (AddWumpusz.wumpusCount > 0) {
                        AddWumpusz.addWumpusz();
                    } else {
                        System.out.println("Nincs több wumpusz hozzáadható.");
                    }
                    break;
                case 4:
                    if (!hasGold) {
                        AddElement.addElement('G');
                        hasGold = true;
                    } else {
                        System.out.println("Már van arany a pályán.");
                    }
                    break;
                case 5:
                    if (!hasHero) {
                        AddHero.addHero();
                        hasHero = true;
                    } else {
                        System.out.println("Már van Hős a pályán!");
                    }
                    break;
                case 6:
                   RemoveElement.removeElement('W');
                    break;
                case 7:
                    RemoveElement.removeElement('P');
                    break;
                case 8:
                    RemoveElement.removeElement('U');
                    break;
                case 9:
                    RemoveElement.removeElement('G');
                    hasGold = false;
                    break;
                case 10:
                    RemoveElement.removeElement('H');
                    hasHero = false;
                    break;
                case 11:
                    editing = false;
                    break;
                default:
                    System.out.println("Érvénytelen választás.");
                    break;
            }

            Board.printBoard();
        }
    }
}

