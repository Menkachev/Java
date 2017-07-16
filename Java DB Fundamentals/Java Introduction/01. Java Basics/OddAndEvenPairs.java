/**
 * You are given an array of integers as a single line, separated by a space. Write a program that checks
 * consecutive pairs and prints if both are odd/even or not. Note that the array length should also be an even number.
 */

import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] nums = console.nextLine().split(" "); // Nums as String.

        int[] arrNums = new int[nums.length];

        for (int i = 0; i < arrNums.length; i++) {
            arrNums[i] = Integer.parseInt(nums[i]); // Convert the characters from the string in integers.
        }

        if (arrNums.length % 2 != 0){ // If array length is not an even number.
            System.out.println("Invalid length");
            return;
        }

        for (int i = 0; i < arrNums.length; i+= 2) {
            int currentNum = arrNums[i];
            int nextNum = arrNums[i + 1];

            if (currentNum % 2 == 0 && nextNum % 2 == 0){
                System.out.printf("%d, %d -> both are even\n", currentNum, nextNum);
            } else if (currentNum % 2 != 0 && nextNum % 2 != 0){
                System.out.printf("%d, %d -> both are odd\n", currentNum, nextNum);
            } else {
                System.out.printf("%d, %d -> different\n", currentNum, nextNum);
            }
        }
    }
}
