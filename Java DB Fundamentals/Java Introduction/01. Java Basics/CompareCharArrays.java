import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Compare two char arrays lexicographically (letter by letter).
 * Print the them in alphabetical order, each on separate line.
 */

public class CompareCharArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] arr1 = reader.readLine().split("\\s");
        String[] arr2 = reader.readLine().split("\\s");

        String firstWord = String.join("", Arrays.asList(arr1));
        String secondWord = String.join("", Arrays.asList(arr2));

        if (firstWord.compareTo(secondWord) >= 0){
            System.out.println(secondWord);
            System.out.println(firstWord);
        } else {
            System.out.println(firstWord);
            System.out.println(secondWord);
        }
    }
}
