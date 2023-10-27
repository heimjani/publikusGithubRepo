package org.example.service;

public class Inicializalas {

    public static int N = Editor.N;
    public static char[][] board;
    public static void main() {
        System.out.println(99);
    }
    public static void initializeBoard() {
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                    board[i][j] = 'W';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
    }
}
