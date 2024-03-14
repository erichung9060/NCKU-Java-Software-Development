import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class HW2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String input1 = scanner.next();
            String input2 = scanner.next();
            int n = input1.split("\\.")[1].length();
            int m = input2.split("\\.")[1].length();
            BigDecimal num1 = processCycle(input1, m);
            BigDecimal num2 = processCycle(input2, n);
            BigDecimal sum = num1.add(num2).setScale(n * m, RoundingMode.DOWN);
            System.out.println(formatOutput(sum));
        }
        scanner.close();
    }
    
    private static BigDecimal processCycle(String cycle_num, int repeat_t) {
        String cycle = cycle_num.split("\\.")[1];
        for (int i = 0; i < repeat_t * 2 - 1; i++) cycle_num += cycle;
        return new BigDecimal(cycle_num);
    }

    private static String formatOutput(BigDecimal num) {
        String integer = num.toString().split("\\.")[0];
        String decimal = num.toString().split("\\.")[1];
        if (decimal.matches("9+")) return (num.add(new BigDecimal("1"))).toString().split("\\.")[0];
        if (decimal.matches("0+")) return integer;
        for (int i = 1; i < decimal.length(); i++) {
            String cycle = decimal.substring(0, i);
            String try_cycle = cycle;
            while (try_cycle.length() < decimal.length())  try_cycle += cycle;
            if (try_cycle.equals(decimal)) return integer + "." + cycle;
        }
        return num.toString();
    }
}
