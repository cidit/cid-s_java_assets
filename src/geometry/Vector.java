package geometry;

/**
 * Euclidian vector representing with accuracy a length and a direction. This is
 * not a data structure.
 * 
 * @author cidit
 *
 */
public class Vector {

	Coordinate initialPoint;
	float xProjection, yProjection, zProjection;

	public Vector(Coordinate initialPoint, Coordinate terminalPoint) {
		this.initialPoint = initialPoint;
		setTerminalPoint(terminalPoint);
	}

	public Vector(float xProjection, float yProjection) {
		this.xProjection = xProjection;
		this.yProjection = yProjection;
		this.zProjection = 0;
	}

	public Vector(float xProjection, float yProjection, float zProjection) {
		this(xProjection, yProjection);
		this.zProjection = zProjection;
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
		return new Coordinate(initialPoint.x + xProjection, initialPoint.y + yProjection,
				initialPoint.z + zProjection);
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

}
