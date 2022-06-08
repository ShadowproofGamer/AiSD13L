public class Main {
    public static void main(String[] args) {


        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph
        Graph graph = new Graph(V, E);

        graph.addEdge(1, 2, 50);
        graph.addEdge(1, 3, 70);
        graph.addEdge(1, 5, 100);
        graph.addEdge(2, 3, 100);
        graph.addEdge(2, 4, 70);
        graph.addEdge(3, 4, 60);
        graph.addEdge(3, 5, 100);
        graph.addEdge(4, 5, 160);

        /*
        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = 50;

        // add edge 0-2
        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 70;

        // add edge 0-3
        graph.edge[2].source = 0;
        graph.edge[2].destination = 4;
        graph.edge[2].weight = 100;


        // add edge 2-3
        graph.edge[3].source = 1;
        graph.edge[3].destination = 2;
        graph.edge[3].weight = 100;


        graph.edge[4].source = 1;
        graph.edge[4].destination = 3;
        graph.edge[4].weight = 70;

        graph.edge[5].source = 2;
        graph.edge[5].destination = 3;
        graph.edge[5].weight = 60;

        graph.edge[6].source = 2;
        graph.edge[6].destination = 4;
        graph.edge[6].weight = 100;

        graph.edge[7].source = 3;
        graph.edge[7].destination = 4;
        graph.edge[7].weight = 160;

         */

        // Function call
        graph.kruskalAlgorithm();
    }
}
