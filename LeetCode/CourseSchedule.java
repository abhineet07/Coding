package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GraphNode{
	int val;
	List<GraphNode> children;
	public GraphNode(int val) {
		this.val = val;
		children = new ArrayList<>();
	}
}

class Graph{
	Set<GraphNode> allNodes;
	Map<Integer, GraphNode> map;
	
	public Graph() {
		allNodes = new HashSet<>();
		map = new HashMap<Integer, GraphNode>();
	}
	
	public GraphNode getNode(int val) {
		return map.get(val);
	}
	
	public GraphNode addNode(int val) {
		GraphNode newnode = new GraphNode(val);
		allNodes.add(newnode);
		map.put(val, newnode);
		return newnode;
	}
	
	public void addEdge(int src, int dst) {
		GraphNode srcNode = map.get(src);
		GraphNode dstNode = map.get(dst);
		srcNode.children.add(dstNode);
	}
}

public class CourseSchedule {
	Set<Integer> WhiteSet = new HashSet<>();
	Set<Integer> GraySet = new HashSet<>();
	Set<Integer> BlackSet = new HashSet<>();
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int len = prerequisites.length;
		Graph graph = new Graph();
		for(int i=0; i<numCourses; i++) {
			graph.addNode(i);
			WhiteSet.add(i);
		}
		
		for(int i=0; i<prerequisites.length; i++) {
			graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
		}
        
		boolean answer = true;
		while(!WhiteSet.isEmpty()) {
			GraphNode node = graph.getNode(WhiteSet.iterator().next());
			answer = answer & dfs(node);
		}
		return answer;
    }
	
	public boolean dfs(GraphNode root) {
		System.out.printf("dfs(%d)\n", root.val);
		System.out.println("\tWhiteSet : ");
		printSet(WhiteSet);
		System.out.println("\tGraySet : ");
		printSet(GraySet);
		System.out.println("\tBlackSet : ");
		printSet(BlackSet);
		
//		if(WhiteSet.isEmpty()) {
//			return true;
//		}
		if(BlackSet.contains(root.val)) {
			return true;
		}
		else if(GraySet.contains(root.val)) {
			return false;
		}
		else if(WhiteSet.contains(root.val)) {
			int currVal = root.val;
			WhiteSet.remove(currVal);
			
			boolean answer = true;
			if(root.children.size() == 0) {
				BlackSet.add(currVal);
			}
			else {
				GraySet.add(currVal);
				for(GraphNode child : root.children) {
					answer = answer & dfs(child);
				}
			}
			return answer;
		}
		return true;
	}
	
	public void printSet(Set<Integer> set) {
		for(Integer val : set) {
			System.out.print("\t" + val);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
//		int courses = 2;
//		int[][] rel = {{1,0}, {0,1}};
		int courses = 5;
		int[][] rel = {{3,0}, {4,3}, {2, 1}};
		CourseSchedule cs = new CourseSchedule();
		boolean result = cs.canFinish(courses, rel);
		System.out.println(result);
	}
}
