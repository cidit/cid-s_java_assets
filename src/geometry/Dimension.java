package geometry;

/**
 * This class represents a hyperrectangular space using floating point numbers.
 * 
 * @author cid
 *
 */
public final class Dimension {

	final float width, height, depth;

	/**
	 * Constructor for a two dimensional rectangle.
	 * @param width
	 * @param height
	 */
	public Dimension(float width, float height) {
		this.width = width;
		this.height = height;
		this.depth = 0;
	}
	
	public Dimension(float width, float height, float depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	public float getDepth() {
		return depth;
	}
	
	@Override
	public String toString() {
		return width + ";" + height + ";" + depth;
	}
	
}
