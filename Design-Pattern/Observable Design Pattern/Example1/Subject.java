package observerDesignPattern;

public interface Subject {
	
	// methods to register and unregister observers
	public void resigter(Observer obj);
	public void unregister(Observer obj);
	
	// methods to notify all registers
	public void notifyAllObservers();
	
	// method to get update from subject
	public Object getUpdate(Observer obj);
}
