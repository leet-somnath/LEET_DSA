import java.util.*;

public class KosarajusAlgorithmStrongestCOmponenets {
    private int V;
    private List<List<Integer>> adj;

    public KosarajusAlgorithm(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    private void fillOrder(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj.get(v)) {
            if (!visited[n]) {
                fillOrder(n, visited, stack);
            }
        }
        stack.push(v);
    }

    private void DFS(int v, boolean[] visited, List<List<Integer>> components) {
        visited[v] = true;
        components.get(components.size() - 1).add(v);
        for (int n : adj.get(v)) {
            if (!visited[n]) {
                DFS(n, visited, components);
            }
        }
    }

    private KosarajusAlgorithm getTranspose() {
        KosarajusAlgorithm g = new KosarajusAlgorithm(V);
        for (int v = 0; v < V; v++) {
            for (int n : adj.get(v)) {
                g.addEdge(n, v);
            }
        }
        return g;
    }

    public void printSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        KosarajusAlgorithm gr = getTranspose();
        Arrays.fill(visited, false);
        List<List<Integer>> components = new ArrayList<>();

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                components.add(new ArrayList<>());
                gr.DFS(v, visited, components);
            }
        }

        System.out.println("Strongly Connected Components:");
        for (List<Integer> component : components) {
            System.out.println(component);
        }
    }

    public static void main(String[] args) {
        KosarajusAlgorithm g = new KosarajusAlgorithm(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.printSCCs();
    }
}

/*
 * import java.util.*;

class KosarajusAlgorithmMatrix {
    private int V;
    private int[][] graph;

    public KosarajusAlgorithmMatrix(int V) {
        this.V = V;
        graph = new int[V][V];
    }

    public void addEdge(int v, int w) {
        graph[v][w] = 1;
    }

    private void fillOrder(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                fillOrder(i, visited, stack);
            }
        }
        stack.push(v);
    }

    private void DFS(int v, boolean[] visited, List<Integer> component, int[][] transposedGraph) {
        visited[v] = true;
        component.add(v);
        for (int i = 0; i < V; i++) {
            if (transposedGraph[v][i] == 1 && !visited[i]) {
                DFS(i, visited, component, transposedGraph);
            }
        }
    }

    private int[][] getTranspose() {
        int[][] transposedGraph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                transposedGraph[j][i] = graph[i][j];
            }
        }
        return transposedGraph;
    }

    public void printSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        int[][] transposedGraph = getTranspose();
        Arrays.fill(visited, false);
        List<List<Integer>> components = new ArrayList<>();

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                DFS(v, visited, component, transposedGraph);
                components.add(component);
            }
        }

        System.out.println("Strongly Connected Components:");
        for (List<Integer> component : components) {
            System.out.println(component);
        }
    }

    public static void main(String[] args) {
        KosarajusAlgorithmMatrix g = new KosarajusAlgorithmMatrix(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.printSCCs();
    }
}

 */