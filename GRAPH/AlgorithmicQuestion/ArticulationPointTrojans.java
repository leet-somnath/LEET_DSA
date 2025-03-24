import java.util.*;

public class ArticulationPointTrojans {
    private int V; // Number of vertices
    private List<Integer>[] adjList; // Adjacency List
    private int[][] adjMatrix; // Adjacency Matrix
    private boolean[] visited;
    private int[] disc, low, parent;
    private boolean[] articulationPoints;
    private int time;

    // Constructor for adjacency list
    public ArticulationPoint(int v) {
        this.V = v;
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // Constructor for adjacency matrix
    public ArticulationPoint(int[][] matrix) {
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

    // Finding articulation points
    public void findArticulationPoints() {
        visited = new boolean[V];
        disc = new int[V];
        low = new int[V];
        parent = new int[V];
        articulationPoints = new boolean[V];
        time = 0;

        Arrays.fill(parent, -1);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++) {
            if (articulationPoints[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private void dfs(int u) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adjList[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v);
                
                low[u] = Math.min(low[u], low[v]);
                
                // Case 1: Root node with multiple children
                if (parent[u] == -1 && children > 1) {
                    articulationPoints[u] = true;
                }

                // Case 2: Non-root node and low[v] >= disc[u]
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    articulationPoints[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArticulationPoint graph1 = new ArticulationPoint(V);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 4);
        
        System.out.println("Using Adjacency List:");
        graph1.findArticulationPoints();

        int[][] matrix = {
            {0, 1, 1, 0, 0},
            {1, 0, 1, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {0, 0, 0, 1, 0}
        };
        
        ArticulationPoint graph2 = new ArticulationPoint(matrix);
        System.out.println("\nUsing Adjacency Matrix:");
        graph2.findArticulationPoints();
    }
}
