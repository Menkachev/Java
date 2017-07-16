package SortStudents;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        while (true){
            String line = scanner.nextLine();

            if (line.equals("END")){
                break;
            }

            String[] input = line.split("\\s");
            String firstName = input[0];
            String lastName = input[1];
            Student studentInfo = new Student(firstName, lastName);
            students.add(studentInfo);
        }

        students
                .stream()
                .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName))
                .forEach(s -> System.out.println(String.format("%s %s", s.getFirstName(), s.getLastName())));

    }
}
