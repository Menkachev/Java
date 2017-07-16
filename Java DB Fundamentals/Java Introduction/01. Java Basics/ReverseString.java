import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Write a program that reads a string from the console,
 *  reverses its letters and prints the result back at the console.
 */

public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();

        System.out.println(new StringBuilder(word).reverse());
    }
}
