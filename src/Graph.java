import java.util.*;
import java.lang.*;

class Graph {
    int v, e; // V-> no. of vertices & E->no.of edges
    int globalCounter = 0;

    private Edge edge[]; // collection of all edges


    // Creates a graph with V vertices and E edges
    public Graph(int v, int e) {
        this.v = v;
        this.e = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    public void addEdge(int source, int destination, int weight){
        edge[globalCounter].source = source-1;
        edge[globalCounter].destination = destination-1;
        edge[globalCounter].weight = weight;
        globalCounter++;
    }



    int find(subset[] subsets, int i) {
        // find root and make root as parent of i
        // (path compression)
        if (subsets[i].parent != i) subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets
    // of x and y (uses union by rank)
    void union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root
        // of high rank tree (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank) subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank) subsets[yroot].parent = xroot;

            // If ranks are same, then make one as
            // root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }


    void kruskalAlgorithm() {
        // The shortest edges are stored there:
        Edge[] result = new Edge[v];

        // An index variable, used for result[]
        int e = 0;

        // An index variable, used for sorted edges
        int i = 0;
        for (i = 0; i < v; ++i)
            result[i] = new Edge();

        // Step 1:  Sort all the edges in non-decreasing
        // order of their weight.  If we are not allowed to
        // change the given graph, we can create a copy of
        // array of edges
        Arrays.sort(edge);

        // Allocate memory for creating V subsets
        subset[] subsets = new subset[v];
        for (i = 0; i < v; ++i)
            subsets[i] = new subset();

        // Create V subsets with single elements
        for (int v = 0; v < this.v; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0; // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < v - 1) {
            // Step 2: Pick the smallest edge and
            // increment the index for next iteration
            Edge next_edge = edge[i++];

            int x = find(subsets, next_edge.source);
            int y = find(subsets, next_edge.destination);

            // If including this edge doesn't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
            // Else discard the next_edge
        }


        System.out.println("Edges:");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println((result[i].source+1) + " <-> " + (result[i].destination+1) + " = " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree " + minimumCost);
    }

    class Edge implements Comparable<Edge> {
        int source, destination, weight;
        public Edge(){}

        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }

    // A class to represent a subset for union() and find() methods
    class subset {
        public int parent, rank;
        public subset(){}
    }
}