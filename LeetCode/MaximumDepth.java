package leetcode;

public class MaximumDepth {
	public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0);
    }
	
	public int getMaxDepth(TreeNode root, int depth) {
		if(root == null) {
			return depth;
		}
		
		return Math.max(getMaxDepth(root.left, depth+1), getMaxDepth(root.right, depth+1));
	}
	
	public static void main(String[] args) {
		MaximumDepth obj = new MaximumDepth();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.right =  new TreeNode(7);
		
		System.out.println(obj.maxDepth(root));
	}
}
