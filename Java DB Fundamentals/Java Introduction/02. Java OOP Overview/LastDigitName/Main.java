package LastDigitName;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nums = Integer.parseInt(scanner.nextLine());
        Number number = new Number(nums);
        System.out.println(number.englishName());
    }
}