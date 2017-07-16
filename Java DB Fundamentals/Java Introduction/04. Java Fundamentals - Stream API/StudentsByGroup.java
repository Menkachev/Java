package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentsByGroup {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> students = new LinkedHashMap<>();

        while (true){
            String line = scanner.nextLine();

            if (line.equals("END")){
                break;
            }

            String[] input = line.split("\\s");
            String name = input[0] + " " + input[1];
            int group = Integer.parseInt(input[2]);

            students.put(name, group);
        }

        students
                .entrySet()
                .stream()
                .filter(s -> s.getValue().equals(2))
                .forEach(s -> System.out.println(s.getKey()));
    }
}