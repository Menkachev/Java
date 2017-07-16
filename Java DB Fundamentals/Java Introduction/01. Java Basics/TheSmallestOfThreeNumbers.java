// Write a program that finds the smallest of three numbers.

import java.util.Scanner;

public class TheSmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double firstNum = input.nextDouble();
        double secondNum = input.nextDouble();
        double thirdNum = input.nextDouble();

        if (firstNum <= secondNum && firstNum <= thirdNum){
            System.out.println(firstNum);
        } else  if (secondNum <= firstNum && secondNum <= thirdNum){
            System.out.println(secondNum);
        } else if (thirdNum <= firstNum && thirdNum <= secondNum){
            System.out.println(thirdNum);
        }
    }
}
