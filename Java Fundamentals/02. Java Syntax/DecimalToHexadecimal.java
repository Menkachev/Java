import java.util.Scanner;

/**
 * Write a program that enters a positive integer number num and converts and prints it in hexadecimal form.
 */
public class DecimalToHexadecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int convertedInt = input.nextInt();

        System.out.printf("%X\n", convertedInt); // Converting decimal to hexadecimal (with capital letters)
    }
}
