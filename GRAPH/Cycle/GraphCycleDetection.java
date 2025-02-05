import java.util.ArrayList;

public class GraphCycleDetection {

    // Cycle detection in a Directed Graph using DFS
    public static boolean isCyclicDirected(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicDirectedUtil(i, visited, recStack, adj)) {
                return true; // Cycle found
            }
        }
        return false; // No cycle
    }

    private static boolean isCyclicDirectedUtil(int node, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && isCyclicDirectedUtil(neighbor, visited, recStack, adj)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[node] = false; // Remove from recursion stack
        return false;
    }

    // Cycle detection in an Undirected Graph using DFS
    public static boolean isCyclicUndirected(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUndirectedUtil(i, -1, visited, adj)) {
                return true; // Cycle found
            }
        }
        return false; // No cycle
    }

    private static boolean isCyclicUndirectedUtil(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclicUndirectedUtil(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If visited and not the parent, we found a cycle
                return true;
            }
        }

        return false;
    }

    // Main function
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> directedGraph = new ArrayList<>(V);
        ArrayList<ArrayList<Integer>> undirectedGraph = new ArrayList<>(V);

        // Initialize adjacency lists
        for (int i = 0; i < V; i++) {
            directedGraph.add(new ArrayList<>());
            undirectedGraph.add(new ArrayList<>());
        }

        // Build a directed graph
        directedGraph.get(0).add(1);
        directedGraph.get(1).add(2);
        directedGraph.get(2).add(0); // Back edge creating a cycle
        directedGraph.get(3).add(4);

        // Build an undirected graph
        undirectedGraph.get(0).add(1);
        undirectedGraph.get(1).add(0);
        undirectedGraph.get(1).add(2);
        undirectedGraph.get(2).add(1);
        undirectedGraph.get(2).add(3);
        undirectedGraph.get(3).add(2);
        undirectedGraph.get(3).add(4);
        undirectedGraph.get(4).add(3);
        undirectedGraph.get(4).add(1); // Back edge creating a cycle
        undirectedGraph.get(1).add(4);

        // Check for cycles
        if (isCyclicDirected(V, directedGraph)) {
            System.out.println("Directed graph contains a cycle");
        } else {
            System.out.println("Directed graph does not contain a cycle");
        }

        if (isCyclicUndirected(V, undirectedGraph)) {
            System.out.println("Undirected graph contains a cycle");
        } else {
            System.out.println("Undirected graph does not contain a cycle");
        }
    }
}

/*
Approach:
1. Directed Graph:
   - Use DFS to traverse the graph.
   - Maintain a `recStack[]` array to track nodes in the current recursion stack.
   - A cycle exists if we revisit a node that is still in the recursion stack.
   - Time Complexity: O(V + E)
   - Space Complexity: O(V) (visited[] + recStack[])

2. Undirected Graph:
   - Use DFS to traverse the graph.
   - Pass the parent node during recursion.
   - A cycle exists if we visit a node that has already been visited and is not the parent.
   - Time Complexity: O(V + E)
   - Space Complexity: O(V) (visited[])

Key Notes:
- For directed graphs, the direction of edges is considered.
- For undirected graphs, cycles can exist due to bidirectional connections.

Tested Graphs:
- Directed graph: Contains a cycle (0 -> 1 -> 2 -> 0).
- Undirected graph: Contains a cycle (1 -> 4 -> 3 -> 2 -> 1).
*/

/*
 * public class GraphCycleDetectionMatrix {

    // Cycle detection in a Directed Graph using DFS and adjacency matrix
    public static boolean isCyclicDirected(int V, int[][] adjMatrix) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicDirectedUtil(i, visited, recStack, adjMatrix, V)) {
                return true; // Cycle found
            }
        }
        return false; // No cycle
    }

    private static boolean isCyclicDirectedUtil(int node, boolean[] visited, boolean[] recStack, int[][] adjMatrix, int V) {
        visited[node] = true;
        recStack[node] = true;

        // Check all neighbors (all vertices)
        for (int neighbor = 0; neighbor < V; neighbor++) {
            if (adjMatrix[node][neighbor] == 1) { // If there's an edge
                if (!visited[neighbor] && isCyclicDirectedUtil(neighbor, visited, recStack, adjMatrix, V)) {
                    return true;
                } else if (recStack[neighbor]) {
                    return true;
                }
            }
        }

        recStack[node] = false; // Remove from recursion stack
        return false;
    }

    // Cycle detection in an Undirected Graph using DFS and adjacency matrix
    public static boolean isCyclicUndirected(int V, int[][] adjMatrix) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUndirectedUtil(i, -1, visited, adjMatrix, V)) {
                return true; // Cycle found
            }
        }
        return false; // No cycle
    }

    private static boolean isCyclicUndirectedUtil(int node, int parent, boolean[] visited, int[][] adjMatrix, int V) {
        visited[node] = true;

        // Check all neighbors
        for (int neighbor = 0; neighbor < V; neighbor++) {
            if (adjMatrix[node][neighbor] == 1) { // If there's an edge
                if (!visited[neighbor]) {
                    if (isCyclicUndirectedUtil(neighbor, node, visited, adjMatrix, V)) {
                        return true;
                    }
                } else if (neighbor != parent) {
                    // If visited and not the parent, we found a cycle
                    return true;
                }
            }
        }

        return false;
    }

    // Main function
    public static void main(String[] args) {
        int V = 4; // Number of vertices

        // Directed graph represented using an adjacency matrix
        int[][] directedGraph = {
            {0, 1, 1, 0}, // Vertex 0 -> 1, 2
            {0, 0, 1, 0}, // Vertex 1 -> 2
            {1, 0, 0, 1}, // Vertex 2 -> 0, 3
            {0, 0, 0, 1}  // Vertex 3 -> 3
        };

        // Undirected graph represented using an adjacency matrix
        int[][] undirectedGraph = {
            {0, 1, 0, 0}, // Vertex 0 -> 1
            {1, 0, 1, 1}, // Vertex 1 -> 0, 2, 3
            {0, 1, 0, 1}, // Vertex 2 -> 1, 3
            {0, 1, 1, 0}  // Vertex 3 -> 1, 2
        };

        // Check for cycles in the directed graph
        if (isCyclicDirected(V, directedGraph)) {
            System.out.println("Directed graph contains a cycle");
        } else {
            System.out.println("Directed graph does not contain a cycle");
        }

        // Check for cycles in the undirected graph
        if (isCyclicUndirected(V, undirectedGraph)) {
            System.out.println("Undirected graph contains a cycle");
        } else {
            System.out.println("Undirected graph does not contain a cycle");
        }
    }
}

/*
Approach:
1. Directed Graph:
   - Use DFS with an adjacency matrix.
   - Track visited nodes using `visited[]`.
   - Track nodes in the current recursion stack using `recStack[]`.
   - A cycle is detected if a node is revisited while it's still in the recursion stack.

2. Undirected Graph:
   - Use DFS with an adjacency matrix.
   - Pass the parent node to avoid detecting the parent as part of a cycle.
   - A cycle is detected if a visited node is found that's not the parent.

Time Complexity:
- For both directed and undirected graphs: O(V^2), where V is the number of vertices.
  This is because we iterate through all vertices and all edges (using the adjacency matrix).

Space Complexity:
- Directed graph: O(V) for `visited[]` and `recStack[]`.
- Undirected graph: O(V) for `visited[]`.
- Adjacency matrix: O(V^2) for storage.
*/

 */