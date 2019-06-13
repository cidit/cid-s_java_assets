package geometry;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * This class represents a position in space using floating point numbers.
 * 
 * @author cidit
 *
 */
public final class Coordinate {

	final float x, y, z;

	public Coordinate(float x, float y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}

	public Coordinate(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public static float distance(Coordinate a, Coordinate b) {
		return (float) sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2) + pow(a.z - b.z, 2));
	}

	@Override
	public String toString() {
		return x + ";" + y + ";" + z;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Coordinate))
			return false;
		Coordinate other = (Coordinate) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
			return false;
		return true;
	}

}
