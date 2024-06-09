/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerialaizeandDeserailaze {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
          if (root == null)
            return "null";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(serialize(root.left)).append(",");
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       String[] nodes = data.split(",");
        return deserializeHelper(nodes);
    }
    private int index = 0;
    private TreeNode deserializeHelper(String[] nodes) {
        if (index >= nodes.length || nodes[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index++]));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;  
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));