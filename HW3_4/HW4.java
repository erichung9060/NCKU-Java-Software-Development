import java.util.Scanner;

class HW4 {
    static void Gaussian(double[][] A, int n) {
        for (int row = 0, col = 0; col < n; col++) {
            if (Math.abs(A[row][col]) <= 1e-9) { // A[row][col] == 0
                for (int i = row + 1; i < n; i++) {
                    if (Math.abs(A[row][col]) > 1e-9) {// A[row][col] > 0
                        double[] temp = A[row];
                        A[row] = A[i];
                        A[i] = temp;
                        break;
                    }
                }
            }
            if (Math.abs(A[row][col]) <= 1e-9) // A[row][col] == 0
                continue;

            for (int i = row + 1; i < n; i++) {
                double factor = A[i][col] / A[row][col];
                for (int j = col; j <= n; j++) {
                    A[i][j] -= factor * A[row][j];
                }
            }
            row++;
        }
    }

    static String SolutionType(double[][] A, int n) {
        int Rank_A = n, Rank_C = n;
        for (int i = 0; i < n; i++) {
            boolean allZeros = true;
            for (int j = 0; j < n; j++) {
                if (Math.abs(A[i][j]) > 1e-9) { // A[i][j] != 0
                    allZeros = false;
                    break;
                }
            }
            if (allZeros) Rank_A--;
            if (allZeros && Math.abs(A[i][n]) <= 1e-9) Rank_C--;
        }
        if(Rank_C > Rank_A) return "No solution";
        else if(Rank_C < n) return "Infinite solutions";
        else return "The only solution";
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double[][] A = new double[n][n + 1];

        int i = -1;
        while (scanner.hasNextDouble()) {
            double first = scanner.nextDouble();
            if (first == -999) break;
            A[++i][0] = first;
            for (int j = 1; j <= n; j++)
                A[i][j] = scanner.nextDouble();
        }
        scanner.close();

        Gaussian(A, n);
        // for (i = 0; i < n; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         System.out.print(A[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        String ans = SolutionType(A, n);
        System.out.println(ans);
    }
}