import java.util.*;

public class BridgesInGraphTrojan {
    private int V; // Number of vertices
    private List<Integer>[] adjList; // Adjacency List
    private int[][] adjMatrix; // Adjacency Matrix
    private boolean[] visited;
    private int[] disc, low, parent;
    private int time;

    // Constructor for adjacency list
    public BridgesInGraph(int v) {
        this.V = v;
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // Constructor for adjacency matrix
    public BridgesInGraph(int[][] matrix) {
        this.V = matrix.length;
        this.adjMatrix = matrix;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }
    }

    // Add edge in adjacency list representation
    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    // Finding bridges
    public void findBridges() {
        visited = new boolean[V];
        disc = new int[V];
        low = new int[V];
        parent = new int[V];
        time = 0;

        Arrays.fill(parent, -1);
        
        System.out.println("Bridges:");
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private void dfs(int u) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adjList[u]) {
            if (!visited[v]) {
                parent[v] = u;
                dfs(v);
                
                low[u] = Math.min(low[u], low[v]);
                
                // If the lowest vertex reachable from v is below u in DFS tree, then u-v is a bridge
                if (low[v] > disc[u]) {
                    System.out.println(u + " - " + v);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        BridgesInGraph graph1 = new BridgesInGraph(V);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 4);
        
        System.out.println("Using Adjacency List:");
        graph1.findBridges();

        int[][] matrix = {
            {0, 1, 1, 0, 0},
            {1, 0, 1, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {0, 0, 0, 1, 0}
        };
        
        BridgesInGraph graph2 = new BridgesInGraph(matrix);
        System.out.println("\nUsing Adjacency Matrix:");
        graph2.findBridges();
    }
}
