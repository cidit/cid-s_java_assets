package geometry;

/**
 * Euclidian vector representing with accuracy a length and a direction. This is
 * not a data structure. MUTABLE
 * 
 * @author cidit
 *
 */
public class Vector implements Cloneable {

	Coordinate initialPoint;
	float xProjection, yProjection, zProjection;

	public Vector(Coordinate initialPoint, Coordinate terminalPoint) {
		this.initialPoint = initialPoint;
		setTerminalPoint(terminalPoint);
	}

	public Vector(float xProjection, float yProjection, float zProjection) {
		this.xProjection = xProjection;
		this.yProjection = yProjection;
		this.zProjection = zProjection;
	}

	public Vector(float xProjection, float yProjection) {
		this(xProjection, yProjection, 0);
	}

	public void setInitialPoint(Coordinate initialPoint) {
		this.initialPoint = initialPoint;
	}

	public void moveInitialPoint(Coordinate initialPoint) {
		Coordinate tmpTerminal = getTerminalPoint();
		setInitialPoint(initialPoint);
		xProjection = initialPoint.x - tmpTerminal.x;
		yProjection = initialPoint.y - tmpTerminal.y;
		zProjection = initialPoint.z - tmpTerminal.z;
	}

	public void setTerminalPoint(Coordinate terminalPoint) {
		if (initialPoint == null) {
			setInitialPoint(new Coordinate(terminalPoint.x - xProjection, terminalPoint.y - yProjection,
					terminalPoint.z - zProjection));
		} else {
			xProjection = initialPoint.x - terminalPoint.x;
			yProjection = initialPoint.y - terminalPoint.y;
			zProjection = initialPoint.z - terminalPoint.z;
		}

	}

	public Coordinate getInitialPoint() {
		return initialPoint;
	}

	public Coordinate getTerminalPoint() {
		return new Coordinate(initialPoint.x + xProjection, initialPoint.y + yProjection, initialPoint.z + zProjection);
	}

	public void setProjections(float xProjection, float yProjection, float zProjection) {
		this.xProjection = xProjection;
		this.yProjection = yProjection;
		this.zProjection = zProjection;
	}

	public float getXProjection() {
		return xProjection;
	}

	public float getYProjection() {
		return yProjection;
	}

	public float getZProjection() {
		return zProjection;
	}

	public float getMagnitude() {
		return Coordinate.distance(initialPoint, getTerminalPoint());
	}

	public Vector getOpposite() {
		return new Vector(-xProjection, -yProjection, -zProjection);
	}

	public void add(Vector vector) {
		xProjection += vector.xProjection;
		yProjection += vector.yProjection;
		zProjection += vector.zProjection;
	}

	public void subtract(Vector vector) {
		xProjection -= vector.xProjection;
		yProjection -= vector.yProjection;
		zProjection -= vector.zProjection;
	}

	public void multiplyByScalar(float scalar) {
		xProjection = xProjection * scalar;
		yProjection = yProjection * scalar;
		zProjection = zProjection * scalar;
	}

	public static float scalarProduct(Vector a, Vector b) {
		return a.xProjection * b.xProjection + a.yProjection * b.yProjection + a.zProjection * b.zProjection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((initialPoint == null) ? 0 : initialPoint.hashCode());
		result = prime * result + Float.floatToIntBits(xProjection);
		result = prime * result + Float.floatToIntBits(yProjection);
		result = prime * result + Float.floatToIntBits(zProjection);
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
		Vector other = (Vector) obj;
		if (initialPoint == null) {
			if (other.initialPoint != null)
				return false;
		} else if (!initialPoint.equals(other.initialPoint))
			return false;
		if (Float.floatToIntBits(xProjection) != Float.floatToIntBits(other.xProjection))
			return false;
		if (Float.floatToIntBits(yProjection) != Float.floatToIntBits(other.yProjection))
			return false;
		if (Float.floatToIntBits(zProjection) != Float.floatToIntBits(other.zProjection))
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Vector(getInitialPoint(), getTerminalPoint());
	}

}
