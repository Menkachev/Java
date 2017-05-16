import java.util.Scanner;

// Write a program that enters 3 points in the plane (as integer x and y coordinates),
// calculates and prints the area of the triangle composed by these 3 points.
// Round the result to a whole number.
// In case the three points do not form a triangle, print "0" as result.

public class TriangleArea {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int aX = input.nextInt();
        int aY = input.nextInt();

        int bX = input.nextInt();
        int bY = input.nextInt();

        int cX = input.nextInt();
        int cY = input.nextInt();

        int area = (aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2;

        System.out.println(area);
    }
}
