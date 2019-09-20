package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	List<String> result;
	
	public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) {
        	return result;
        }
        
        DFS(root, "");
        return result;
    }
	
	public void DFS(TreeNode root, String path) {
		path += root.val;
		if(root.left == null && root.right==null) {
			System.out.println(path);
			result.add(path);
			return;
		}
		path += "->";
		if(root.left != null)
			DFS(root.left, path);
		if(root.right!=null)
			DFS(root.right, path);
	}
	
	public static void main(String[] args) {
		BinaryTreePaths obj = new BinaryTreePaths();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		obj.binaryTreePaths(root);
	}
}
