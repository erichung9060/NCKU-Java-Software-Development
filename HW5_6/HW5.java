package demo;
import java.util.Scanner;

class HW5 {
    static int dx[] = { 0, 1, 0, -1 };
    static int dy[] = { 1, 0, -1, 0 };
    static int n, m;
    static char[][] Matrix;
    static String target;

    static boolean dfs(int x, int y, int cur) {
        if (Matrix[x][y] != target.charAt(cur)) return false;
        if (cur == target.length() - 1) return true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (dfs(nx, ny, cur + 1))
                    return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        Matrix = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Matrix[i][j] = scanner.next().charAt(0);
            }
        }

        target = scanner.next();
        scanner.close();

        boolean find = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0)) {
                    find = true;
                    break;
                }
            }
        }

        System.out.println(find ? "true" : "false");
    }
}