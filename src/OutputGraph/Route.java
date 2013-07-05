package OutputGraph;

import java.util.ArrayList;

public class Route {
	ArrayList<Point> points;

	public Route() {
		points = new ArrayList<Point>();
	}
	
	public void setLength(int size) {
		for(int i=0; i<size; i++)
			points.add(new Point());
	}
	
	public void addPoint(int index, Point point){
		points.add(index,point);
	}
	
	public Route(ArrayList<Point> points) {
		this.points = points;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	
}
