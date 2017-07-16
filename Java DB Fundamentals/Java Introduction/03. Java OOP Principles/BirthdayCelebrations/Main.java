package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Identifiable> identifiables = new ArrayList<>();
        List<Birthdays> birthday = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] info = input.split("\\s");
//
//            if (info.length == 2) {
//                String name = info[0];
//                String id = info[1];
//                Identifiable robot = new RobotsImpl(id, name);
//                identifiables.add(robot);
//            } else if (info.length == 3) {
//                String name = info[0];
//                int age = Integer.parseInt(info[1]);
//                String id = info[2];
//                Identifiable citizen = new CitizensImpl(id, name, age);
//                identifiables.add(citizen);
//            }

            switch (info[0]){
                case "Citizen":
                    String name = info[1];
                    int age = Integer.parseInt(info[2]);
                    String id = info[3];
                    String birthdate = info[4];
                    Citizens citizen = new CitizensImpl(id, name, age, birthdate);
                    birthday.add(citizen);
                    identifiables.add(citizen);
                    break;
                case "Pet":
                    String petName = info[1];
                    String petBirthday = info[2];
                    Pets pet = new PetsImpl(petName, petBirthday);
                    birthday.add(pet);
                    break;
                case "Robot":
                    String model = info[1];
                    String robotId = info[2];
                    Robots robot = new RobotsImpl(model, robotId);
                    identifiables.add(robot);
                    break;
            }
        }

//        String fakeId = scanner.nextLine();

        String date = scanner.nextLine();

//        for (Identifiable identifiable : identifiables) {
//            if (identifiable.getId().endsWith(fakeId)) {
//                System.out.println(identifiable.getId());
//            }
//        }

        for (Birthdays birthdate:birthday) {
            if (birthdate.getBirthday().endsWith(date)){
                System.out.println(birthdate.getBirthday());
            }
        }
    }
}