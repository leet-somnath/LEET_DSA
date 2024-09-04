import java.util.ArrayList;
import java.util.Scanner;

public class Implementaion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // number of nodes
        int m = sc.nextInt(); // number of edges
        
        // adjacency list for undirected graph
        // time complexity: O(2E)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
          //  adj.get(v).add(u);
        }
        
        sc.close();
    }
}
/*
 * import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Pair class to store the destination node and the weight of the edge
    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of nodes
        int m = sc.nextInt(); // number of edges

        // adjacency list for weighted undirected graph
        // time complexity: O(2E)
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        sc.close();
    }
}

 */