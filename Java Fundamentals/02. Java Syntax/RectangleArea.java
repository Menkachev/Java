package com.company;

import java.util.Scanner;

// Write a program that enters the sides of a rectangle (two integers a and b) and
// calculates and prints the rectangle's area

public class RectangleArea {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();

        int result = a * b;

        System.out.println(result);
    }
}
