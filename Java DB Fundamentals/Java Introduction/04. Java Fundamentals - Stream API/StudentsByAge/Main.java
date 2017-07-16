package StudentsByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

 public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> studens = new ArrayList<>();

        while (true){
            String line = reader.readLine();

            if (line.equals("END")){
                break;
            }

            String[] input = line.split("\\s");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            Student tokens = new Student(firstName, lastName, age);
            studens.add(tokens);
        }

        studens
                .stream()
                .filter(s -> s.getAge() >= 18 && s.getAge() <= 24)
                .forEach(s -> System.out.println(String.format("%s %s %d",
                        s.getFirstName(),
                        s.getLastName(),
                        s.getAge())));
    }
}