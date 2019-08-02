package geometry;

/**
 * This class represents a tri-dimensional area using floating points numbers.
 * UNMUTABLE
 * 
 * @author cidit
 *
 */
public final class Dimension {

	final float width, height, depth;

	/**
	 * Constructor for an immutable rectangle.
	 * 
	 * @param width
	 * @param height
	 */
	public Dimension(float width, float height, float depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public Dimension(float width, float height) {
		this(width, height, 0);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(depth);
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result + Float.floatToIntBits(width);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dimension other = (Dimension) obj;
		if (Float.floatToIntBits(depth) != Float.floatToIntBits(other.depth))
			return false;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
			return false;
		if (Float.floatToIntBits(width) != Float.floatToIntBits(other.width))
			return false;
		return true;
	}

}
