package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String input = reader.readLine();

            if (input.equals("END")){
                break;
            }

            String[] elements = input.split("\\s");
            String name = elements[0] + " " + elements[1];
            List<Integer> grades = new ArrayList<>();

            for (int i = 2; i < elements.length; i++) {
                grades.add(Integer.parseInt(elements[i]));
            }

            students.put(name, grades);
        }

        students
                .entrySet()
                .stream()
                .filter(a -> a.getValue().contains(6))
                .forEach(a -> System.out.println(a.getKey()));
    }
}
