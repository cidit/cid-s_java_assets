package geometry;

import static java.lang.Math.abs;

public class Line {

	// a = variation, b = y origin
	float a, b;

	public Line(float a, float b) {
		this.a = a;
		this.b = b;
	}

	public Line(Coordinate p1, Coordinate p2) {
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
		// what if 0? TODO
		this.a = a;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float fx(float x) {
		return (a * x) + b;
	}
	
	public float fy(float y) {
		return (y - b) / a;
	}
	
	public boolean intersects(Line line) {
		return a != line.a;
	}
	
	// TODO use trigonometry. use the y origin as reference for the angles
	public Coordinate intersectsAt(Line line) {
		if (!intersects(line))
			return null;

		Line higherOrigin, lowerOrigin;
		
		if (b > line.b) {
			higherOrigin = this;
			lowerOrigin = line;
		} else {
			higherOrigin = line;
			lowerOrigin = this;
		}
		
		
		return null;
	}
}
