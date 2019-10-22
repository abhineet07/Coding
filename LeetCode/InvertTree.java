package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) {
    		return root;
    	}
        Deque<TreeNode> que = new LinkedList<TreeNode>();
        que.offerLast(root);
        while(!que.isEmpty()) {
        	TreeNode curr = que.pollFirst();
        	if(curr.left!=null || curr.right!=null) {
        		TreeNode temp = curr.left;
        		curr.left = curr.right;
        		curr.right = temp;
        	}
        	
        	if(curr.left!=null) {
        		que.offerLast(curr.left);
        	}
        	if(curr.right!=null) {
        		que.offerLast(curr.right);
        	}
        }
        return root;
    }
    
	public static void main(String[] args) {
		InvertTree obj = new InvertTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		TreeNode o2 = obj.invertTree(root);
		System.out.println(o2.val);
		System.out.println(o2.right.val);
	}

}
