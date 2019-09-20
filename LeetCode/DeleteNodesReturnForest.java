package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class DeleteNodesReturnForest {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        Deque<TreeNode> util = new LinkedList<TreeNode>();
        List<TreeNode> answer = new ArrayList<>();
        Set<Integer> myset = new HashSet<>();
        
        util.addLast(root);
        while(!util.isEmpty()) {
        	TreeNode temp = util.pollFirst();
        	if(temp != null) {
            	deque.addLast(temp);
            	util.addLast(temp.left);
            	util.addLast(temp.right);
        	}
        }
        
        for(int i=0; i<to_delete.length; i++) {
        	myset.add(to_delete[i]);
        }
        
        while(!deque.isEmpty()) {
        	TreeNode temp = deque.pollLast();
//        	System.out.println("node val = " + temp.val);
        	if(myset.contains(temp.val)) {
        		if(temp.left!=null) {
        			answer.add(temp.left);
        			temp.left = null;
        		}
        		if(temp.right!=null) {
        			answer.add(temp.right);
        			temp.right = null;
        		}
        	}
        	if(temp.left!=null && myset.contains(temp.left.val)) {
        		temp.left = null;
        	}
        	if(temp.right!=null && myset.contains(temp.right.val)) {
        		temp.right = null;
        	}
        	
        	if(temp==root && !myset.contains(root.val)) {
        		answer.add(root);
        	}
        }
        
        for(TreeNode node : answer) {
        	System.out.print(node.val + "  ");
        }
        
        return answer;
    }
	
	public void bfs(TreeNode root, Deque<TreeNode> deque) {
		if(root == null) {
			return;
		}
		deque.addFirst(root);
		bfs(root.left, deque);
	}
	
	public static void main(String[] args) {
		DeleteNodesReturnForest obj = new DeleteNodesReturnForest();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right =  new TreeNode(7);
		
		int[] to_delete = {3,5};
		obj.delNodes(root, to_delete);
	}
}
