package util;

public interface Copyable<T extends Copyable<T>> {
	
	public T copy();

}
