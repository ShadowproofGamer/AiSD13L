public class Main {
    public static void main(String[] args) {

        /*
        int n = 5; // Number of vertices in graph
        int m = 8; // Number of edges in graph
        Graph graph = new Graph(n, m);

        graph.addEdge(1, 2, 50);
        graph.addEdge(1, 3, 70);
        graph.addEdge(1, 5, 100);
        graph.addEdge(2, 3, 100);
        graph.addEdge(2, 4, 70);
        graph.addEdge(3, 4, 60);
        graph.addEdge(3, 5, 100);
        graph.addEdge(4, 5, 160);

         */

        Graph graph = InputLoader.load();

        graph.kruskalAlgorithm();
    }
}
