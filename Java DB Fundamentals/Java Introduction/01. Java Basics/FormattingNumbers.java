/**
 * Write a program that reads 3 numbers: an integer a (0 ≤ a ≤ 500), a floating-point b and a floating-point c
 and prints them in 4 virtual columns on the console. Each column should have a width of 10 characters.
 The number a should be printed in hexadecimal, left aligned; then the number a should be printed in binary
 form, padded with zeroes, then the number b should be printed with 2 digits after the decimal point, right aligned
 , the number c should be printed with 3 digits after the decimal point, left aligned.
 */

import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();

        if (0 <= a && a <= 500){ // Checking if the first number is in the requested range

            float b = input.nextFloat();
            float c = input.nextFloat();

            String aAsString = String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0');

            System.out.printf("|%-10X|%10s|%10.2f|%-10.3f|", a, aAsString, b, c);
        } else {
            System.out.println("Number a - out of range");
        }
    }
}
