package geometry;

import static java.lang.Math.abs;

public class Straight {

	// a = variation, b = y origin
	private float a, b;

	public Straight(float a, float b) {
		this.a = a;
		this.b = b;
	}

	public Straight(Coordinate p1, Coordinate p2) {
		a = (p2.y - p1.y)/(p2.x - p2.x);
		b = (p2.x*p2.y - p2.x*p2.y)/(p2.x - p1.x);
	}

	public float getA() {
		return a;
	}

	public float getB() {
		return b;
	}

	public void setA(float a) {
		this.a = a;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float funcY(float x) {
		return (a * x) + b;
	}
	
	public float funcX(float y) {
		return (y - b) / a;
	}
	
	public boolean intersects(Straight line) {
		return a != line.a;
	}
	
	public Coordinate intersectsAt(Straight line) {
		if (!intersects(line))
			return null;
		// TODO UNFINISHED
		return null;
	}
}
