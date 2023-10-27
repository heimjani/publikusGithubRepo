package org.example.service;

public class Board {
    public static int N = Editor.N;
    private static char[][] board = Inicializalas.board;

    public static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
