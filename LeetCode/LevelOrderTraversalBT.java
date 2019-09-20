package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversalBT {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) {
        	return result;
        }
        
        List<TreeNode> que1 = new LinkedList<TreeNode>();
        List<TreeNode> que2 = new LinkedList<TreeNode>();
        
        que1.add(root);
        
        while(!que1.isEmpty() || !que2.isEmpty()) {
//        	tempList.clear();
        	List<Integer> tempList1 = new LinkedList<>();
        	while(!que1.isEmpty()) {
        		TreeNode node = que1.get(0);
        		que1.remove(0);
        		tempList1.add(node.val);
        		if(node.left!=null)
        			que2.add(node.left);
        		if(node.right!=null)
        			que2.add(node.right);
        	}
        	if(tempList1.size() > 0) {
//        		System.out.print("\tTemplist : ");
//            	printList(tempList1);
            	result.add(tempList1);
        	}
        		
        	List<Integer> tempList2 = new LinkedList<>();
        	tempList2.clear();
        	while(!que2.isEmpty()) {
        		TreeNode node = que2.get(0);
        		que2.remove(0);
        		tempList2.add(node.val);
        		if(node.left!=null)
        			que1.add(node.left);
        		if(node.right!=null)
        			que1.add(node.right);
        	}
        	if(tempList2.size() > 0) {
//        		System.out.print("\tTemplist : ");
//            	printList(tempList2);
            	result.add(tempList2);
        	}        	
        }
//        display(result);
        return result;
    }
	
	public void printList(List<Integer> list) {
		for(Integer num : list) {
			System.out.print(num + "  ");
		}
		System.out.println();
	}
	
	public void display(List<List<Integer>> result) {
		System.out.println("RESULT : ");
		for(List<Integer> currList : result) {
			for(Integer num : currList) {
				System.out.print(num + "  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		LevelOrderTraversalBT obj = new LevelOrderTraversalBT();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		obj.levelOrder(root);
	}
}
