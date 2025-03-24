import java.util.*;

public class MinimumSpanningTreePrimsAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    // Function to find the vertex with the minimum key value
    private static int minKey(int[] key, boolean[] mstSet, int V) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to print the MST
    private static void printMST(int[] parent, int[][] graph, int V) {
        System.out.println("Edge \t Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Prim's algorithm implementation
    public static void primMST(int[][] graph, int V) {
        int[] parent = new int[V]; // Stores the MST
        int[] key = new int[V]; // Key values used to pick minimum weight edge
        boolean[] mstSet = new boolean[V]; // To represent set of vertices included in MST

        // Initialize all keys as infinite
        Arrays.fill(key, INF);
        Arrays.fill(mstSet, false);

        key[0] = 0; // First vertex is always included in MST
        parent[0] = -1; // First node is always root of MST

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph, V);
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        primMST(graph, V);
    }
}