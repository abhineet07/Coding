package observerDesignPattern;

public class ObserverPatternDriver {
	public static void main(String[] args) {
		// create subject
		MyTopic topic = new MyTopic();
		
		// create observers
		Observer obj1 = new MyTopicSubscriber("Abhineet");
		Observer obj2 = new MyTopicSubscriber("Deepak");
		Observer obj3 = new MyTopicSubscriber("Navneet");
		
		// registering observers to the subject
		topic.resigter(obj1);
		topic.resigter(obj2);
		topic.resigter(obj3);
		
		// attach subject to the observers
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		// check if any update is avialable
		obj1.update();
		
		// now send message to subject
		System.out.println();
		topic.postMessage("Tommorrow will be test for Observable Design Pattern");
		
		System.out.println();
		obj2.update();
		
		// new observer
		Observer obj4 = new MyTopicSubscriber("Shivansh");
		topic.resigter(obj4);
		obj4.setSubject(topic);
		System.out.println();
		obj4.update();
		
		// new send again new message
		System.out.println();
		topic.postMessage("Tommorrow we will read Singleton Design Pattern");
		
		System.out.println();
		obj3.update();
	}
}
