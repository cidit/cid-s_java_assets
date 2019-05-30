package util.events;

/**
 * event
 * 
 * @author cidit
 *
 */
public abstract class Event {

	private EventSource source;

	public Event(EventSource source) {
		this.source = source;
	}

	public EventSource getSource() {
		return source;
	}
}
