package geometry;

public class Line extends Straight {

	Coordinate p1, p2;

	// WORK IN PROGRESS
	public Line(Coordinate p1, Coordinate p2) {
		super(p1, p2);
		this.p1 = p1;
		this.p2 = p2;
	}

	public Coordinate getP1() {
		return p1;
	}

	public Coordinate getP2() {
		return p2;
	}

	public void setP1(Coordinate p1) {
		this.p1 = p1;
	}

	public void setP2(Coordinate p2) {
		this.p2 = p2;
	}
	
	public boolean intersects(Line line) {
		// TODO UNFINISHED
		return false;
	}

}
