package leetcodeInterview;

/*
 *  leetcode : https://leetcode.com/discuss/interview-experience/360829/amazon-sde1-seattle-july-2019-offer
 *  leetcode : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *  Amazon
 */

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SerializeAndDeserializeBinarytree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
        	return "X,";
        }
        return String.valueOf(root.val) + "," + 
        		serialize(root.left) + serialize(root.right);
    }
    
    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        Queue<String> que = new LinkedList<String>();
        for(int i=0; i<array.length; i++) {
        	que.add(array[i]);
        }
        
        if(que.size() > 0) {
        	return deserializeUtil(que);
        }
        else {
        	return null;
        }
    }
    
    public TreeNode deserializeUtil(Queue<String> que) {
    	String curr = que.poll();
    	if(curr.equals("X")) {
    		return null;
    	}
    	System.out.println(curr);
    	TreeNode root = new TreeNode(Integer.valueOf(curr));
    	root.left = deserializeUtil(que);
    	root.right = deserializeUtil(que);
    	return root;
    }
    
    
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		SerializeAndDeserializeBinarytree obj = new SerializeAndDeserializeBinarytree();
		String ans = obj.serialize(root);
		System.out.println(ans);
		
		obj.deserialize(ans);
	}
}
