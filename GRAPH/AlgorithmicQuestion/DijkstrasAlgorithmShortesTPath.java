import java.util.*;

public class DijkstrasAlgorithmShortesTPath {
    private static final int INF = Integer.MAX_VALUE;

    // Function to find the vertex with the minimum distance value
    private static int minDistance(int[] dist, boolean[] sptSet, int V) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to print the shortest distance from source
    private static void printSolution(int[] dist, int V) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    // Dijkstra's algorithm implementation
    public static void dijkstra(int[][] graph, int src, int V) {
        int[] dist = new int[V]; // Stores shortest distance from src
        boolean[] sptSet = new boolean[V]; // Shortest path tree set

        Arrays.fill(dist, INF);
        Arrays.fill(sptSet, false);

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet, V);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, V);
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
            {0, 10, 0, 30, 100},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {100, 0, 10, 60, 0}
        };

        dijkstra(graph, 0, V);
    }
}
