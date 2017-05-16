import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that enters from the console number n and n strings, then sorts them alphabetically and prints them.
 */
public class SortArrayOfStrings {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        String[] arrayString = new String[n];

        for (int i = 0; i < n; i++) {

            arrayString[i] = input.next();
        }

        Arrays.sort(arrayString);

        for (int i = 0; i < arrayString.length; i++) {

            System.out.println(arrayString[i]);
        }
    }
}
