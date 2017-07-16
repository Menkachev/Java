import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhonebookUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> people = new LinkedHashMap<>();

        while (true){
            String line = reader.readLine();

            if (line.equals("END")){
                break;
            }

            String[] info = line.split("\\s");

            String operation = info[0];
            String name = info[1];

            if (operation.equals("A")) {
                String phone = info[2];
                people.put(name, phone);
            } else if (operation.equals("S")){
                if (people.get(name) == null){
                    System.out.printf("Contact %s does not exist. \n", name);
                } else {
                    System.out.println(name + " -> " + people.get(name));
                }
            } else {
                people
                    .entrySet()
                    .stream().sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                    .forEach(a -> System.out.println(a.getKey() + " -> " + a.getValue()));
            }
        }
    }
}