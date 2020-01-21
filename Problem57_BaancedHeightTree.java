/******************** Time Complexity: O(n log n) **********************/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int height(TreeNode root) 
    {
        //base case
        if (root == null) 
        {
            //if no nodes, height of the tree is -1
            return -1;
        }
      
        //to check the maximum height of the tree
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) 
    {
        //checking if the the node is balanced by calculating height and comparing the height
        if (root == null) 
        {
            return true;
        }
        //if height is balanced true; else false
        return Math.abs(height(root.left) - height(root.right)) < 2
            && isBalanced(root.left)
            && isBalanced(root.right);
  }
};