/*************** Time Complexity: O(n) ******************/
/*************** Space Complexity: O(n) ******************/

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
public List<List<Integer>> levelOrder(TreeNode root) {
    
        List<List<Integer>> result = new LinkedList<>();
        //base case
        if(root == null) return result;
        //current list will be used for each level
        List<TreeNode> currentList = new LinkedList<>();
        //add first node to the current list as root
        currentList.add(root);
    
        //till the current list is not empty
        while(!currentList.isEmpty())
        {
            List<TreeNode> next = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            
            for(TreeNode node: currentList)
            {
                temp.add(node.val);
                //if the node has left element, add
                if(node.left != null){
                    next.add(node.left);
                }
                //if the node has right element, add
                if(node.right != null){
                    next.add(node.right);
                }
            }
            //add the temp list in the resultant list<list>>
            result.add(temp);
            //next level
            currentList = next;
        }
        return result;
    }
}