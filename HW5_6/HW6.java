package demo;

import java.util.Scanner;

class HW6 {
    private static boolean has_line(char[][] Board, char target) {
        for (int i = 0; i < 3; i++) {
            boolean vertical = true, horizontal = true;
            for (int j = 0; j < 3; j++) {
                if (Board[i][j] != target) horizontal = false;
                if (Board[j][i] != target) vertical = false;
            }
            if (horizontal || vertical) return true;
        }
        boolean slash1 = true, slash2 = true;
        for (int i = 0; i < 3; i++) {
            if (Board[i][i] != target) slash1 = false;
            if (Board[i][2 - i] != target) slash2 = false;
        }
        if (slash1 || slash2) return true;

        return false;
    }

    private static boolean check(char[][] Board) {
        int cnt_O = 0, cnt_X = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Board[i][j] == 'O') cnt_O++;
                if (Board[i][j] == 'X') cnt_X++;
            }
        }
        if (cnt_X - cnt_O == 1) {
            return true;
        } else if (cnt_X - cnt_O == 0 && !has_line(Board, 'X')) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        char[][] Board = new char[3][3];
        String input = scanner.nextLine();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Board[i][j] = input.charAt(i * 3 + j);
            }
        }

        boolean result = check(Board);
        System.out.println(result ? "valid" : "invalid");
    }
}