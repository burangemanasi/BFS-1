/********************** Time Complexity: O(log n/2) *************************/
/********************** Space Complexity: O(log n/2) *************************/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        //base case
        if(curr == null){
            return;
        }
        
        //comparing depth to add remaining nodes
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        //recursively calling left and right to check the right view
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}