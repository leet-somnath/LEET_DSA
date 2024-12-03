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

public class VerticalTraversalandSum  {
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> traversalResult = new ArrayList<>();
        if (root == null)
            return traversalResult;

        TreeMap<Integer, ArrayList<Integer>> traversalMap = new TreeMap<>();
        Queue<Pair> traversalQueue = new LinkedList<>();

        traversalQueue.add(new Pair(root, 0));
        while (!traversalQueue.isEmpty()) {
            int size = traversalQueue.size();
            TreeMap<Integer, ArrayList<Integer>> tempMap = new TreeMap<>();
            
            for (int i = 0; i < size; i++) {
                Pair temp = traversalQueue.poll();
                TreeNode node = temp.node;
                int hd = temp.hd;

                if (!tempMap.containsKey(hd)) {
                    tempMap.put(hd, new ArrayList<>());
                }
                tempMap.get(hd).add(node.val);

                if (node.left != null)
                    traversalQueue.add(new Pair(node.left, hd - 1));
                if (node.right != null)
                    traversalQueue.add(new Pair(node.right, hd + 1));
            }

            for (Map.Entry<Integer, ArrayList<Integer>> entry : tempMap.entrySet()) {
                Collections.sort(entry.getValue());
                if (traversalMap.containsKey(entry.getKey())) {
                    traversalMap.get(entry.getKey()).addAll(entry.getValue());
                } else {
                    traversalMap.put(entry.getKey(), entry.getValue());
                }
            }
        }

        for (ArrayList<Integer> list : traversalMap.values()) {
            traversalResult.add(list);
        }
        
        return traversalResult;
    }
    
    public List<Integer> verticalSum(TreeNode root) {
        List<Integer> sumResult = new ArrayList<>();
        if (root == null)
            return sumResult;

        TreeMap<Integer, Integer> sumMap = new TreeMap<>();
        Queue<Pair> sumQueue = new LinkedList<>();

        sumQueue.add(new Pair(root, 0));
        while (!sumQueue.isEmpty()) {
            int size = sumQueue.size();
            
            for (int i = 0; i < size; i++) {
                Pair temp = sumQueue.poll();
                TreeNode node = temp.node;
                int hd = temp.hd;

                sumMap.put(hd, sumMap.getOrDefault(hd, 0) + node.val);

                if (node.left != null)
                    sumQueue.add(new Pair(node.left, hd - 1));
                if (node.right != null)
                    sumQueue.add(new Pair(node.right, hd + 1));
            }
        }

        for (int sum : sumMap.values()) {
            sumResult.add(sum);
        }
        
        return sumResult;
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
