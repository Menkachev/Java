import java.util.Scanner;

/**
 * Write a program to calculate the count of bits 1 in the binary representation of given integer number n.
 */
public class CountOfBitsOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        String binaryString = Integer.toBinaryString(num); // Convert the integer to it's binary representation.
        int countOne = Integer.bitCount(num);

        System.out.println(countOne);
    }
}
