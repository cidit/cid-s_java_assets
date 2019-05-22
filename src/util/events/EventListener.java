package util.events;

public interface EventListener<T extends Event> {
	
	public void perform(T event);

}
