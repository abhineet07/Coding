/*
 *  
 *  938. Range Sum of BST
 *  Problem Link : https://leetcode.com/problems/range-sum-of-bst/
 *  
 */

public class RangeSumOfBST {	
	public int rangeSumBST(TreeNode root, int L, int R) {		
        if(root == null) {
        	return 0;
        }        
        if(root.val <= R && root.val >= L) {
        	return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + root.val;
        }
        return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);        
    }

}