/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result=new ArrayList<>();
        List<String>path=new ArrayList<>();
        dfs(root,path,result);
        return result;
    }
    private void dfs(TreeNode root,List<String>path,List<String>result){
        if(root==null){
            return;
        }
        path.add(String.valueOf(root.val));
        if(root.left==null&&root.right==null){
            result.add(String.join("->",path));
        }else{
            dfs(root.left,path,result);
            dfs(root.right,path,result);
        }
        path.remove(path.size()-1);
    }
}
