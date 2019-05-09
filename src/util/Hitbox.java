package util;

public class Hitbox {

	private Coordinate coordinate;
	private Dimention dimention;
	private Sides sides;
	private Corners corners;

	/**
	 * 
	 * @param coordinate superior left corner
	 * @param dimention
	 */
	public Hitbox(Coordinate coordinate, Dimention dimention) {
		this.coordinate = coordinate;
		this.dimention = dimention;
		initSidesAndCorners();
	}
	
	private void initSidesAndCorners() {
		sides = new Sides();
		corners = new Corners();
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public Dimention getDimention() {
		return dimention;
	}
	
	public Sides getSides() {
		return sides;
	}
	
	public Corners getCorners() {
		return corners;
	}
	
	public void moveTo(Coordinate coordinate) {
		this.coordinate = coordinate;
		initSidesAndCorners();
	}
	
	public void resize(Dimention dimention) {
		this.dimention = dimention;
		initSidesAndCorners();
	}
	
	public boolean intersects(Hitbox other) {
		final boolean ct, cr, cb, cl;
		final Sides os = other.sides;
		ct = sides.top >= os.top && sides.top <= os.bottom;
		cr = sides.right <= os.right && sides.right >= os.left;
		cb = sides.bottom >= os.top && sides.bottom <= os.bottom;
		cl = sides.left <= os.right && sides.left >= os.left;
		if (ct || cr || cb || cl)
			return true;
		return false;
	}
	
	public boolean contains(Hitbox other) {
		final boolean ct, cr, cb, cl;
		final Sides os = other.sides;
		ct = sides.top <= os.top;
		cr = sides.right >= os.right;
		cb = sides.bottom >= os.bottom;
		cl = sides.left <= os.left;
		if (ct && cr && cb && cl)
			return true;
		return false;
	}
	
	public class Sides {
		
		private float left;
		private float right;
		private float top;
		private float bottom;
		
		public Sides() {
			left = coordinate.getX();
			right = left + dimention.getWidth();
			top = coordinate.getY();
			bottom = top + dimention.getHeight();
		}
		
		public float getLeft() {
			return left;
		}
		
		public float getRight() {
			return right;
		}
		
		public float getTop() {
			return top;
		}
		
		public float getBottom() {
			return bottom;
		}
	}
	
	public class Corners {
		
		private Coordinate superiorLeft;
		private Coordinate superiorRight;
		private Coordinate inferiorLeft;
		private Coordinate inferiorRight;
		
		public Corners() {
			superiorLeft = new Coordinate(sides.left, sides.top);
			superiorRight = new Coordinate(sides.right, sides.top);
			inferiorLeft = new Coordinate(sides.left, sides.bottom);
			inferiorRight = new Coordinate(sides.right, sides.bottom);
		}
		
		public Coordinate getSuperiorLeft() {
			return superiorLeft;
		}
		
		public Coordinate getSuperiorRight() {
			return superiorRight;
		}
		
		public Coordinate getInferiorLeft() {
			return inferiorLeft;
		}
		
		public Coordinate getInferiorRight() {
			return inferiorRight;
		}
	}
}
