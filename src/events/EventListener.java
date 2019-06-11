package events;

/**
 * listens to events from a source and handles them
 * 
 * @author cidit
 *
 * @param <T>
 */
public interface EventListener {

	public void handle(Event event);

}
