package util.events;

/**
 * sends events to listeners
 * 
 * @author cidit
 *
 * @param <T>
 */
public interface EventSource {

	public void addEventListener(EventListener listener);
	
	public void removeEventListener(EventListener listener);
	
}
