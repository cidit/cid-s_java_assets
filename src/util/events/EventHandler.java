package util.events;

public interface EventHandler {

	public void addEventListener(EventListener listener);
	
	public void removeEventListener(EventListener listener);
}
