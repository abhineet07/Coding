package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/*
 *  https://leetcode.com/problems/house-robber-iii/
 */

public class Robbers3 {
	public int rob(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        return Math.max(robInclude(root), robExclude(root));
    }
	
	public int robInclude(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return robExclude(root.left) + robExclude(root.right) + root.val;
	}
	
	public int robExclude(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return rob(root.left) + rob(root.right);
	}
	
	public static void main(String[] args) {
		Robbers3 obj = new Robbers3();
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.right = new TreeNode(3);
		tree.right.right = new TreeNode(1);
		
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(4);
//		root.right = new TreeNode(5);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(3);
//		root.right.right = new TreeNode(1);
		
		int ans = obj.rob(tree);
		System.out.println(ans);
	}
}
