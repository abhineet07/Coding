package observerDesignPattern;

public class MyTopicSubscriber implements Observer {
	
	private String name; // Subscriber name
	private Subject topic; // subscribed to which topic
	
	public MyTopicSubscriber(String name) {
		this.name = name;
	}
	
	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if(msg == null) {
			System.out.println(name + " :: No new message");
		}
		else {
			System.out.println(name + " :: Consuming message :: " + msg);
		}
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
	}
	
}
