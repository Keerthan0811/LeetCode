// 199. Binary Tree Right Side View
// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        rightView(root, ans,0);
        return ans;

    }
    private void rightView(TreeNode node, List<Integer> ans,int dept){
        if(node==null)return ;
        if(dept==ans.size()){
            ans.add(node.val);
        }
        
        rightView(node.right, ans, dept+1);
        rightView(node.left, ans, dept+1);

    }
}
