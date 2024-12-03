//without using extra space
class Solution {
    void printKdown(TreeNode root,int depth,TreeNode block,List<Integer> ans){
        if(root==null || depth<0 || root==block){
            return;
        }
        if(depth==0){
            ans.add(root.val);
            return;
        }
        printKdown(root.left,depth-1,block,ans);
        printKdown(root.right,depth-1,block,ans);
    }
    int getNodetoRootPath(TreeNode root,TreeNode target,int k,List<Integer> ans){
        if(root==null){
            return -1;
        }
        if(root==target){
           printKdown(root,k,null,ans);
           return 1;
        }
       int left = getNodetoRootPath(root.left,target,k,ans);
        if(left>0){
            printKdown(root,k-left,root.left,ans);
            return left+1;
        }
        int right = getNodetoRootPath(root.right,target,k,ans);
        if(right>0){
            printKdown(root,k-right,root.right,ans);
            return right+1;
        } 
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        getNodetoRootPath(root,target,k,ans);
        return ans;
    }
}