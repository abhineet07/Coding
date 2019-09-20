package leetcodeInterview;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FruitIntoBasket {
	class Fruit{
		int type;
		int index;
		
		public Fruit(int type, int index) {
			this.type = type;
			this.index = index;
		}
	}
	
	Deque<Fruit> que = new LinkedList<FruitIntoBasket.Fruit>();
	
	Set<Fruit> set = new HashSet<>();
	
	public boolean setContainsFruit(int type) {
		for(Fruit f : set) {
			if(f.type == type) {
				return true;
			}
		}
		return false;
	}
	
	public Fruit getFruitFromSet(Fruit fruit) {
		for(Fruit f : set) {
			if(f.type == fruit.type) {
				return f;
			}
		}
		return null;
	}
	
	public int totalFruit(int[] tree) {
		int maxLen = 0;
		int curLen = 0;
		
        for(int i=0; i<tree.length; i++) {
        	System.out.printf("\ni=%d : ", i);
        	if(setContainsFruit(tree[i])) {
        		System.out.printf("set(size)=%d \t condition 1\n", set.size());
        		Fruit fruit = new Fruit(tree[i], i);
        		que.addFirst(fruit);
        		set.remove(getFruitFromSet(fruit));
        		set.add(fruit);
//        		curLen++;
        	}
        	else {
        		if(set.size() < 2) {
        			System.out.printf("set(size)=%d \t condition 2 -> 1\n", set.size());
        			Fruit fruit = new Fruit(tree[i], i);
        			que.addFirst(fruit);
        			set.add(fruit);
//        			curLen++;
        		}
        		else {
        			System.out.printf("set(size)=%d \t condition 2 -> 2\n", set.size());
        			while(set.size() > 1) {
        				System.out.printf("inside while loop\n");
        				Fruit fruit = que.peekLast();
        				if(fruit.index < getFruitFromSet(fruit).index) {
        					que.pollLast();
        				}
        				else if(fruit.index <= getFruitFromSet(fruit).index) {
        					que.pollLast();
        					set.remove(getFruitFromSet(fruit));
        				}
//        				curLen--;
        			}
        			Fruit fruit = new Fruit(tree[i], i);
        			que.addFirst(fruit);
        			set.add(fruit);
//        			curLen++;
        		}
        	}
        	printQueue(que);
        	System.out.printf("que.size=%d\n", que.size());
        	if(que.size() > maxLen) {
        		maxLen = que.size();
        	}
        }
        return maxLen;
    }
	
	public void printQueue(Deque<Fruit> que) {
		System.out.print("Queue : ");
		for(Fruit f : que) {
			System.out.printf("%d\t", f.type);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		FruitIntoBasket obj = new FruitIntoBasket();
		int[] arr = {1,0,3,4,3};
		int ans = obj.totalFruit(arr);
		System.out.println("ans = " + ans);
	}

}
