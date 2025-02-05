import java.util.*;

public class ShortestPathDAG {
    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Function to perform topological sort
    private static void topologicalSort(int v, boolean[] visited, Stack<Integer> stack, List<List<Edge>> adjList) {
        visited[v] = true;
        for (Edge edge : adjList.get(v)) {
            if (!visited[edge.dest]) {
                topologicalSort(edge.dest, visited, stack, adjList);
            }
        }
        stack.push(v);
    }

    // Function to find shortest paths using adjacency list
    public static void shortestPathList(int V, List<List<Edge>> adjList, int src) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack, adjList);
            }
        }
        
        dist[src] = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge edge : adjList.get(u)) {
                    if (dist[edge.dest] > dist[u] + edge.weight) {
                        dist[edge.dest] = dist[u] + edge.weight;
                    }
                }
            }
        }
        System.out.println("Shortest distances using Adjacency List:");
        System.out.println(Arrays.toString(dist));
    }

    // Function to find shortest paths using adjacency matrix
    public static void shortestPathMatrix(int V, int[][] adjMatrix, int src) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                for (int j = 0; j < V; j++) {
                    if (adjMatrix[i][j] != 0) {
                        topologicalSort(i, visited, stack, convertMatrixToList(V, adjMatrix));
                    }
                }
            }
        }
        
        dist[src] = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (int v = 0; v < V; v++) {
                    if (adjMatrix[u][v] != 0 && dist[v] > dist[u] + adjMatrix[u][v]) {
                        dist[v] = dist[u] + adjMatrix[u][v];
                    }
                }
            }
        }
        System.out.println("Shortest distances using Adjacency Matrix:");
        System.out.println(Arrays.toString(dist));
    }

    // Helper function to convert adjacency matrix to adjacency list
    private static List<List<Edge>> convertMatrixToList(int V, int[][] adjMatrix) {
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < V; j++) {
                if (adjMatrix[i][j] != 0) {
                    adjList.get(i).add(new Edge(j, adjMatrix[i][j]));
                }
            }
        }
        return adjList;
    }

    public static void main(String[] args) {
        int V = 6;
        int src = 0;

        // Adjacency List Representation
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(new Edge(1, 5));
        adjList.get(0).add(new Edge(2, 3));
        adjList.get(1).add(new Edge(3, 6));
        adjList.get(1).add(new Edge(2, 2));
        adjList.get(2).add(new Edge(4, 4));
        adjList.get(2).add(new Edge(5, 2));
        adjList.get(2).add(new Edge(3, 7));
        adjList.get(3).add(new Edge(4, -1));
        adjList.get(4).add(new Edge(5, -2));

        shortestPathList(V, adjList, src);

        // Adjacency Matrix Representation
        int[][] adjMatrix = new int[V][V];
        adjMatrix[0][1] = 5;
        adjMatrix[0][2] = 3;
        adjMatrix[1][3] = 6;
        adjMatrix[1][2] = 2;
        adjMatrix[2][4] = 4;
        adjMatrix[2][5] = 2;
        adjMatrix[2][3] = 7;
        adjMatrix[3][4] = -1;
        adjMatrix[4][5] = -2;

        shortestPathMatrix(V, adjMatrix, src);
    }
}
