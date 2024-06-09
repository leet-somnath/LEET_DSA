import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FloorandCeil {
    static TreeSet<Integer> set = new TreeSet<Integer>();

    static void traverse(TreeNode root) {
        if (root == null) return;
        
        traverse(root.left);
        set.add(root.val);
        traverse(root.right);
    }
    
    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        traverse(root);
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int q : queries) {
            List<Integer> list = new ArrayList<>();
            
            Integer min = set.floor(q);
            if (min != null) list.add(min);
            else list.add(-1);
            
            Integer max = set.ceiling(q);
            if (max != null) list.add(max);
            else list.add(-1);
            
            ans.add(list);
        }
        
        return ans;
    } 
}
