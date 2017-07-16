/**
 * Write a program to count how many sequences of two equal bits ("00" or "11")
 * can be found in the binary representation of given integer number n (with overlapping).
 */

import java.util.Scanner;

public class CountOfEqualBitPairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        String numAsString = Integer.toBinaryString(num); // Convert the integer to it's binary representation.

        char[] charArray = numAsString.toCharArray(); // Add all characters from the binary in an array.

        int counter = 0;

        for (int i = 0; i < charArray.length - 1; i++) {
            char currentChar = charArray[i];
            char nextChar = charArray[i + 1];

            if (currentChar == nextChar){
                counter++;
            }
        }

        System.out.println(counter);
    }
}
