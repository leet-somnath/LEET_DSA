import java.util.*;

public class ShortestPathinUnweightedGraph {

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        int[][] adjacencyMatrix = new int[vertices][vertices];
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Adding edges (undirected)
        addEdgeMatrix(adjacencyMatrix, 0, 1);
        addEdgeMatrix(adjacencyMatrix, 1, 2);
        addEdgeMatrix(adjacencyMatrix, 2, 3);
        addEdgeMatrix(adjacencyMatrix, 3, 4);
        addEdgeMatrix(adjacencyMatrix, 4, 0);

        addEdgeList(adjacencyList, 0, 1);
        addEdgeList(adjacencyList, 1, 2);
        addEdgeList(adjacencyList, 2, 3);
        addEdgeList(adjacencyList, 3, 4);
        addEdgeList(adjacencyList, 4, 0);

        int source = 0;

        // Shortest path using BFS
        System.out.println("Shortest path using adjacency matrix:");
        int[] distancesMatrix = bfsUsingMatrix(adjacencyMatrix, source);
        System.out.println(Arrays.toString(distancesMatrix));

        System.out.println("\nShortest path using adjacency list:");
        int[] distancesList = bfsUsingList(adjacencyList, source);
        System.out.println(Arrays.toString(distancesList));
    }

    // Add edge to adjacency matrix
    public static void addEdgeMatrix(int[][] matrix, int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1; // Because it's an undirected graph
    }

    // Add edge to adjacency list
    public static void addEdgeList(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u); // Because it's an undirected graph
    }

    // BFS using adjacency matrix
    public static int[] bfsUsingMatrix(int[][] matrix, int source) {
        int vertices = matrix.length;
        int[] distance = new int[vertices];
        Arrays.fill(distance, -1); // -1 indicates unreachable
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        distance[source] = 0; // Distance to itself is 0

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor = 0; neighbor < vertices; neighbor++) {
                if (matrix[current][neighbor] == 1 && distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return distance;
    }

    // BFS using adjacency list
    public static int[] bfsUsingList(ArrayList<ArrayList<Integer>> list, int source) {
        int vertices = list.size();
        int[] distance = new int[vertices];
        Arrays.fill(distance, -1); // -1 indicates unreachable
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        distance[source] = 0; // Distance to itself is 0

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : list.get(current)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return distance;
    }
}
/*
Approach:
1. Represent the graph using both adjacency matrix and adjacency list:
   - Adjacency Matrix: A 2D array where matrix[u][v] = 1 if there's an edge between u and v.
   - Adjacency List: An ArrayList of ArrayLists where list[u] contains all neighbors of vertex u.

2. Use Breadth-First Search (BFS) to find the shortest path:
   - Initialize a distance array with all values as -1 (indicating unreachable vertices).
   - Set the source vertex's distance to 0 and enqueue it.
   - For each dequeued vertex, update the distance of its unvisited neighbors as `distance[current] + 1` and enqueue them.

3. Return the distance array where distance[i] gives the shortest distance from the source to vertex i.

Complexity:
1. Using Adjacency Matrix:
   - Time Complexity: O(V^2) - For each vertex, check all other vertices for edges.
   - Space Complexity: O(V^2) - Storage required for the matrix.

2. Using Adjacency List:
   - Time Complexity: O(V + E) - Explore all vertices and their edges.
   - Space Complexity: O(V + E) - Storage required for the adjacency list.
*/
