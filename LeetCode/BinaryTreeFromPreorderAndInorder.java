package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderAndInorder {
	HashMap<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = inorder.length;
        
		if(len==0) {
			return null;
		}
		
        for(int i=0; i<len; i++) {
        	map.put(inorder[i], i);
        }
        
        return buildTreeMain(preorder, inorder, 0, len-1, 0, len-1);
    }
	
	public TreeNode buildTreeMain(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
		System.out.printf("preStart=%d, preEnd=%d, inStart=%d, inEnd=%d\n", preStart, preEnd, inStart, inEnd);
		if(preEnd < preStart && inEnd < inStart) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = map.get(root.val);
		int numsLeft = inIndex - inStart;
		root.left = buildTreeMain(preorder, inorder, preStart+1, preStart+numsLeft, inStart, inIndex-1);
		root.right = buildTreeMain(preorder, inorder,preStart+numsLeft+1, preEnd, inIndex+1, inEnd);
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreeFromPreorderAndInorder obj = new BinaryTreeFromPreorderAndInorder();
		int[] preorder = {1,2};
		int[] inorder = {2,1};
		
		obj.buildTree(preorder, inorder);
	}
}
	