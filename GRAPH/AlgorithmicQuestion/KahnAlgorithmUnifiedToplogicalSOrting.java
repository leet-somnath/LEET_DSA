import java.util.*;

public class KahnAlgorithmUnifiedToplogicalSOrting {

    // Topological Sort using adjacency matrix
    public static void topologicalSortMatrix(int[][] graph, int V) {
        int[] inDegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        // Calculate in-degree for each node
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[j][i] == 1) {
                    inDegree[i]++;
                }
            }
        }

        // Enqueue nodes with 0 in-degree
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Perform topological sort
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // Reduce in-degree of neighbors
            for (int i = 0; i < V; i++) {
                if (graph[node][i] == 1) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        if (result.size() != V) {
            System.out.println("Cycle detected! Topological sort not possible.");
        } else {
            System.out.println("Topological Sort (Matrix): " + result);
        }
    }

    // Topological Sort using adjacency list
    public static void topologicalSortList(List<List<Integer>> graph, int V) {
        int[] inDegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        // Calculate in-degree for each node
        for (int i = 0; i < V; i++) {
            for (int neighbor : graph.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Enqueue nodes with 0 in-degree
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Perform topological sort
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // Reduce in-degree of neighbors
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (result.size() != V) {
            System.out.println("Cycle detected! Topological sort not possible.");
        } else {
            System.out.println("Topological Sort (ArrayList): " + result);
        }
    }

    public static void main(String[] args) {
        // Example graph using adjacency matrix
        System.out.println("Using Adjacency Matrix:");
        int[][] graphMatrix = {
            {0, 1, 0, 1},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        int V = 4; // Number of vertices
        topologicalSortMatrix(graphMatrix, V);

        // Example graph using adjacency list
        System.out.println("\nUsing Adjacency List:");
        List<List<Integer>> graphList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            graphList.add(new ArrayList<>());
        }
        graphList.get(0).add(1);
        graphList.get(1).add(2);
        graphList.get(0).add(3);

        topologicalSortList(graphList, V);
    }
}
