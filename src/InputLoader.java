import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class InputLoader {
    public static Graph load() {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        int m = 0;


        //looping while the input is correct:
        boolean correct = false;
        while (!correct) {
            //printing prompt to enter graph data
            System.out.println("Enter number of verticles and edges (n m): ");
            //getting the number of Verticles and Edges
            String temp = scan.nextLine();
            String[] variables = temp.split("\\s+");

            //creating new graph
            n = Integer.parseInt(variables[0]);
            m = Integer.parseInt(variables[1]);
            if (n <= 20 && n >= 1 && m <= 190 && m >= 0) {
                correct = true;
            }
        }


        Graph result = new Graph(n, m);

        //filling the graph
        for (int i = 0; i < m; i++) {
            String[] edgeVariables = scan.nextLine().split("\\s+");
            int source = Integer.parseInt(edgeVariables[0]);
            int destination = Integer.parseInt(edgeVariables[1]);
            int weight = Integer.parseInt(edgeVariables[2]);
            result.addEdge(source, destination, weight);
        }

        //returning the graph
        return result;
    }
}
