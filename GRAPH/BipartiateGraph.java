import java.util.*;

class BipartiteGraph
{
    public boolean bfsCheck(int node, int color[], int[][] adj, int V) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0; // Start coloring node with 0
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int it = 0; it < V; it++) {
                // if there is an edge and the adjacent node is not yet colored
                if(adj[curr][it] == 1 && color[it] == -1) {
                    color[it] = 1 - color[curr]; // Alternate color
                    q.add(it);
                }
                // if the adjacent node has the same color, return false
                else if(adj[curr][it] == 1 && color[it] == color[curr]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite(int V, int[][] adj)
    {
        int color[] = new int[V];
        Arrays.fill(color, -1); // Initialize all nodes with -1 (uncolored)
        
        // Check for all connected components
        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(!bfsCheck(i, color, adj, V)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        // V = 4, E = 4
        int[][] adj = { 
            {0, 0, 1, 1},
            {0, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 0}
        };

        Solution obj = new Solution();
        boolean ans = obj.isBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
