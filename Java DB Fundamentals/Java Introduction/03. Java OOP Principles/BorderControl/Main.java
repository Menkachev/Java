package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Identifiable> identifiables = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] info = input.split("\\s");

            if (info.length == 2) {
                String name = info[0];
                String id = info[1];
                Identifiable robot = new RobotsImpl(id, name);
                identifiables.add(robot);
            } else if (info.length == 3) {
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String id = info[2];
                Identifiable citizen = new CitizensImpl(id, name, age);
                identifiables.add(citizen);
            }
        }

        String fakeId = scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(fakeId)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}