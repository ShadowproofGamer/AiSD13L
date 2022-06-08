import java.util.*;
import java.lang.*;

class Graph {
    int n, m; // V-> no. of vertices & E->no.of edges
    int globalCounter = 0;

    private Edge[] edges; // collection of all edges


    // Creates a graph with V vertices and E edges
    public Graph(int v, int e) {
        this.n = v;
        this.m = e;
        edges = new Edge[e];
    }

    public void addEdge(int source, int destination, int weight) {
        Edge newEdge = new Edge(source-1, destination-1, weight);
        edges[globalCounter] = newEdge;
        globalCounter++;
    }


    public void kruskalAlgorithm() {
        // An array of the shortest edges
        Edge[] result = new Edge[n];


        for (int i = 0; i < n; i++)
            result[i] = new Edge();

        //sorting the edges array to pick from the lightest
        Arrays.sort(edges);

        // Create V subsets with single elements
        subset[] subsets = new subset[n];
        for (int i = 0; i < n; i++) {
            subsets[i] = new subset(i, 0);
        }

        int edgeIndex = 0; // Index used to pick next edge
        int resultIndex = 0; // Index used to store into result[]

        while (resultIndex < n - 1) {
            Edge nextEdge = edges[edgeIndex];
            edgeIndex++;

            int x = find(subsets, nextEdge.source);
            int y = find(subsets, nextEdge.destination);

            // If including this edge doesn't cause cycle,
            // include it in result and increment the edgeIndex
            // of result for next edge
            if (x != y) {
                result[resultIndex] = nextEdge;
                resultIndex++;
                union(subsets, x, y);
            }
        }

        //printing out the result
        //System.out.println("Edges:");
        int minimumCost = 0;
        for (int i = 0; i < resultIndex; i++) {
            //System.out.println((result[i].source + 1) + " <-> " + (result[i].destination + 1) + " = " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Result:\n" + minimumCost);
    }




    /** private functions for kruskalAlgorithm() */

    private int find(subset[] subsets, int i) {
        // find root and make root as parent of i
        if (subsets[i].parent != i) subsets[i].parent = find(subsets, subsets[i].parent);
        //return root
        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y (uses union by rank)
    private void union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank) subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank) subsets[yroot].parent = xroot;

            // If ranks are same, then make one as
            // root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }




    /**private classes for graph and kruskal's work*/
    private class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        public Edge() {
        }
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }

    // A class to represent a subset for union() and find() methods
    private class subset {
        public int parent;
        public int rank;

        public subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }
}