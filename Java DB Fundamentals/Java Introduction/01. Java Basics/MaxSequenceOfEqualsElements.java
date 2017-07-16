import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that finds the longest sequence of equal elements in an array of integers.
 * If several longest sequences exist, print the leftmost one.
 */

public class MaxSequenceOfEqualsElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nums = scanner.nextLine().split("\\s");

        int len = 1;
        int start = 0;
        int maxLen = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i].equals(nums[i - 1])){
                len++;
                if (len > maxLen){
                    maxLen = len;
                    start = i - maxLen + 1;
                }
        }   else {
                len = 1;
            }
        }

        for (int i = start; i < maxLen + start; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
