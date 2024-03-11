import java.math.BigDecimal;
import java.util.Scanner;

class HW1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        BigDecimal num1 = scanner.nextBigDecimal();
        BigDecimal num2 = scanner.nextBigDecimal();
        BigDecimal sum = num1.add(num2);
        
        System.out.println(sum);
        scanner.close();
    }
}