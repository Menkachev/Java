package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentsEnrolledIn2014or2015 {
    public static void main(String[] args) throws IOException {

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();

            if (line.equals("END")) {
                break;
            }

            String[] input = line.split("\\s");
            String facultyNumber = input[0];
            List<Integer> grades = new ArrayList<>();

            for (int i = 1; i < input.length; i++) {
                grades.add(Integer.parseInt(input[i]));
            }

            students.put(facultyNumber, grades);
        }

        students
                .entrySet()
                .stream()
                .filter(s -> s.getKey().endsWith("14") && s.getKey().endsWith("15"))
                .forEach(s -> System.out.println(String.join(s.getValue() + " ")));
    }
}
