package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WeakStudents {
    public static void main(String[] args) throws IOException {

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String line = reader.readLine();

            if (line.equals("END")){
                break;
            }

            String[] input = line.split("\\s");
            String name = input[0] + " " + input[1];
            List<Integer> grades = new ArrayList<>();

            for (int i = 2; i < input.length; i++) {
                grades.add(Integer.parseInt(input[i]));
            }

            students.put(name, grades);
        }

        students
                .entrySet()
                .stream()
                .filter(s -> s.getValue().contains(3) && s.getValue().contains(2))
                .limit(2)
                .forEach(s -> System.out.println(String.format("%s", s.getKey())));
    }
}