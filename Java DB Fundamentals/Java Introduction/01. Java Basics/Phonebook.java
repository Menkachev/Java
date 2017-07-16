import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Write a program that receives some info from the console about people and their phone numbers.
 * Each entry should have just one name and one number (both of them strings).
 *
 * On each line you will receive some of the following commands:
 *  # A {name} {phone} – adds entry to the phonebook. In case of trying to add a name that is already in the phonebook
 *    you should change the existing phone number with the new one provided.
 *
 *  # S {name} – searches for a contact by given name and prints it in format "{name} -> {number}".
 *    In case the contact isn't found, print "Contact {name} does not exist.".
 *
 *  # END – stop receiving more commands.
 */

public class Phonebook {
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
            }
        }
    }
}
