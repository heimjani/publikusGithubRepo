package org.example.service;

/**
 * Tábla elkészítés.
 */
public class Board {
    /**
     * N megadása.
     */
    public static int N = Editor.N;
    private static char[][] board = Inicializalas.board;

    /**
     * Tábla kiírása.
     */
    public static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}