import java.util.*;

public class StronglyConnectedComponentsusingTrojans {
    private int V; // Number of vertices
    private List<Integer>[] adjList; // Adjacency List
    private boolean[] visited;
    private int[] disc, low, parent;
    private Stack<Integer> stack;
    private boolean[] stackMember;
    private int time;

    // Constructor
    public StronglyConnectedComponents(int v) {
        this.V = v;
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // Add edge
    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // Undirected graph assumption
    }

    // Finding Strongly Connected Components using Bridges and Articulation Points
    public void findSCCs() {
        visited = new boolean[V];
        disc = new int[V];
        low = new int[V];
        parent = new int[V];
        stack = new Stack<>();
        stackMember = new boolean[V];
        time = 0;

        Arrays.fill(parent, -1);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private void dfs(int u) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        stack.push(u);
        stackMember[u] = true;
        int children = 0;

        for (int v : adjList[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v);
                
                low[u] = Math.min(low[u], low[v]);
                
                // Check for articulation point
                if (parent[u] == -1 && children > 1) {
                    System.out.println("Articulation Point: " + u);
                }
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    System.out.println("Articulation Point: " + u);
                }
                
                // Check for bridge
                if (low[v] > disc[u]) {
                    System.out.println("Bridge: " + u + " - " + v);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            System.out.print("SCC: ");
            while (true) {
                int v = stack.pop();
                stackMember[v] = false;
                System.out.print(v + " ");
                if (v == u) break;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5;
        StronglyConnectedComponents graph = new StronglyConnectedComponents(V);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        
        System.out.println("Strongly Connected Components, Articulation Points, and Bridges:");
        graph.findSCCs();
    }
}
