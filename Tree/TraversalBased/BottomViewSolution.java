package TraversalBased;
import java.util.*;

import TreeNode;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class BottomViewSolution {
    
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> bottomViewResult = new ArrayList<>();
        if (root == null)
            return bottomViewResult;

        TreeMap<Integer, Integer> bottomViewMap = new TreeMap<>();
        Queue<Pair> bottomViewQueue = new LinkedList<>();

        bottomViewQueue.add(new Pair(root, 0));
        while (!bottomViewQueue.isEmpty()) {
            int size = bottomViewQueue.size();
            
            for (int i = 0; i < size; i++) {
                Pair temp = bottomViewQueue.poll();
                TreeNode node = temp.node;
                int hd = temp.hd;

                bottomViewMap.put(hd, node.val);

                if (node.left != null)
                    bottomViewQueue.add(new Pair(node.left, hd - 1));
                if (node.right != null)
                    bottomViewQueue.add(new Pair(node.right, hd + 1));
            }
        }

        for (int val : bottomViewMap.values()) {
            bottomViewResult.add(val);
        }
        
        return bottomViewResult;
    }

    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode n, int h) {
            node = n;
            hd = h;
        }
    }
}
