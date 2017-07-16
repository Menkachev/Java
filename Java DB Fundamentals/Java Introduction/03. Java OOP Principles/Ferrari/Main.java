package Ferrari;

import java.util.Scanner;

import static java.lang.String.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String driverName = scanner.nextLine();

        Cars ferrari = new Ferrari(
                "488-Spider",
                "Brakes!",
                "Zadu6avam sA!",
                driverName);

        System.out.println(format(
                "%s/%s/%s/%s",
                ferrari.model(),
                ferrari.brakes(),
                ferrari.gas(),
                ferrari.driverName()));
    }
}
