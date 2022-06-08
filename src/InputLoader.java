import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class InputLoader {
    public static Graph load(){
        Scanner scan = new Scanner(System.in);

        String temp = scan.next();
        String[] variables = temp.split("\\s+");

        Graph result = new Graph(variables[0], variables[1]);

    }
}
