package observerDesignPattern;

public interface Observer {
	
	// method to update the observers, used by subject
	public void update();
	
	// attach with subject to observe
	public void setSubject(Subject sub);
}
