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
    public int sumRootToLeaf(TreeNode root) {

        return countVal(root, 0);
    }

    private int countVal(TreeNode root, int value){    
        int currentPathSum = (value << 1) + root.val;
        int right = 0;
        int left = 0;
	
	//在葉節點時直接回傳currentPathSum 
        if(root.right == null && root.left == null) return currentPathSum;

        if(root.right != null){
            right += countVal(root.right, currentPathSum); 
        }
        
        if(root.left != null){
            left += countVal(root.left, currentPathSum); 
        }

        return right + left;
    }
}

