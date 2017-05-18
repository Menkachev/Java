/**
 * Write a program that reads three floating point numbers from the console and calculates their result
 * with the following formulae: ((a2 + b2) / (a2 – b2))(a + b + c) / √c         (a2 + b2 - c3)(a – b)

 * Then calculate the difference between the average of the three numbers and the average of the two formulae.
 * Average (a, b, c) – Average (f1, f2)
 */

import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        float a = console.nextFloat();
        float b = console.nextFloat();
        float c = console.nextFloat();

        double f1 = Math.pow((a*a + b*b) / (a*a - b*b),((a + b + c) / Math.sqrt(c)));

        double f2 = Math.pow((a*a + b*b - c*c*c), (a - b));

        double average = Math.abs((f1 + f2) / 2) - Math.abs(a + b + c) / 3;

        System.out.printf("F1 result: %.2f; ", f1);
        System.out.printf("F2 result: %.2f; ", f2);
        System.out.printf("Diff: %.2f", average);
    }
}
