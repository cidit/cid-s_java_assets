package util;

/**
 * Counter that counts with manual incrementations. The maximum incrementation
 * possible is Long.MAX_VALUE;
 * 
 * @author cidit
 *
 */
public class Counter {

	private long count;

	private final long ttl;

	/**
	 * Constructor
	 * 
	 * @param ttl time to live before expiration (enter Long.MAX_VALUE for no
	 *               expiration)
	 */
	public Counter(long ttl) {
		if (ttl < 0)
			throw new IllegalArgumentException("ttl (time to live) cannot be lower than 0");
		this.ttl = ttl;
		count = 0;
	}

	/**
	 * Increments the counter.
	 */
	public void count() {
		if (isExpired()) return;
		count++;
	}
	
	/**
	 * Resets the counter.
	 */
	public void reset() {
		count = 0;
	}

	/**
	 * Verifies the validity of the counter.
	 * 
	 * @return true if the count is
	 */
	public boolean isExpired() {
		return ttl < count ? true : false;
	}

	/**
	 * Returns the count.
	 * 
	 * @return count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * Returns the maximum amount of incrementations allowed before expiration.
	 * 
	 * @return time to live
	 */
	public long getTimeToLive() {
		return ttl;
	}

	/**
	 * Returns a floating-point number between 0 and 1 representing the ratio of
	 * completion of the counter.
	 * 
	 * @return progression
	 */
	public float getProgression() {
		return (float) count / ttl;
	}

}
