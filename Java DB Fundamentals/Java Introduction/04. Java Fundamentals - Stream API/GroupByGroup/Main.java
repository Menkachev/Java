package GroupByGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> students = new ArrayList<>();

        while (true){
            String line = scanner.nextLine();

            if (line.equals("END")){
                break;
            }

            String[] input = line.split("\\s");
            String name = input[0] + " " + input[1];
            int group = Integer.parseInt(input[2]);
            Person studentInfo = new Person(name, group);
            students.add(studentInfo);
        }

        students
                .stream()
                .collect(Collectors.groupingBy(Person::getGroup))
                .entrySet()
                .forEach(s -> {
                    List<String> names = new ArrayList<>();
                    for (Person person:s.getValue()) {
                        names.add(person.getName());
                    }
                    System.out.println(s.getKey() + " - " + String.join(", ", names));
                });
    }
}