package IntersectionOfCircles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Circle c1 = generateCircle(scanner);
        Circle c2 = generateCircle(scanner);

        Boolean intersect = getIntersection(c1, c2);

        if (intersect){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static Boolean getIntersection(Circle c1, Circle c2) {
        Point c1Center = c1.getCenter();
        Point c2Center = c2.getCenter();
        int radiusSum = c1.getRadius() + c2.getRadius();
        double distance =
                Math.sqrt(Math.pow(c2Center.getX() - c1Center.getX(), 2) + Math.pow(c2Center.getY() - c1Center.getY(), 2));

        if (distance <= radiusSum){
            return true;
        } else {
            return false;
        }
    }

    private static Circle generateCircle(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int radius = Integer.parseInt(input[2]);
        Point center = new Point(x, y);
        return new Circle(center, radius);
    }
}
