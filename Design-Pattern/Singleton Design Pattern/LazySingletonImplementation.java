package Singleton;

class Singleton{
	private static Singleton instance;
	
	int n = 0;
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public int setN(int n) {
		this.n = n;
		return n;
	}
}

public class LazySingletonImplementation {
	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		int res = obj1.setN(10);
		System.out.printf("res=%d obj1.n=%d\n", res, obj1.n);	// res=10 obj1.n=10
		
		Singleton obj2 = Singleton.getInstance();
		System.out.printf("obj2.n=%d\n", obj2.n);	// obj2.n=10
		
		res = obj2.setN(20);
		System.out.printf("res=%d obj1.n=%d\n", res, obj1.n); // res=20 obj1.n=20
		System.out.printf("res=%d obj2.n=%d\n", res, obj2.n); // res=20 obj2.n=20
	}
}
