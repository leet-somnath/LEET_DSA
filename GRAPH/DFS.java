import java.util.*;

class DFS {

    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {

        // Marking current node as visited
        vis[node] = true;
        ls.add(node);

        // Getting neighbor nodes
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int numNodes = 5;

        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        // List to store DFS traversal result
        ArrayList<Integer> ls = new ArrayList<>();

        // Boolean array to mark visited nodes
        boolean vis[] = new boolean[numNodes];

        // Perform DFS starting from node 0
        dfs(0, vis, adj, ls);

        // Printing the DFS result
        for (int i : ls) {
            System.out.print(i + " ");
        }
    }
}
