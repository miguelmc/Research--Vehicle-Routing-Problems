package OutputGraph;

import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;

public class Controller {
	
	ArchParser archParser;
	PointParser pointParser;
	GraphShower graphShower;
	private MaxMinCoords minMax;
	final private int FRAME_RANGE = 800;
	
	public Controller(){
		archParser = new ArchParser();
		pointParser = new PointParser();
		//graphShower = new GraphShower();
	}
	
	public void processGraph(File problem, File solution){
		ArrayList<Point> points = pointParser.getPoints(problem);
		minMax = MaxMinCoords.getMinMax(points);
		normalizePoints(points);
		archParser.setPoints(points);
		ArrayList<Route> routes = archParser.getArches(solution);
		graphShower = new GraphShower();
		graphShower.display(points, routes);
	}
	
	public void normalizePoints(ArrayList<Point> points) {
		double range;
		double xRange = minMax.getXMax() - minMax.getXMin();
		double yRange = minMax.getYMax() - minMax.getYMin();
		// To keep things in proportion, points adapt to the bigger range.
		
		range = Math.max(xRange, yRange);

		double xReal;
		double yReal;
		// point proportional to screen
		double xFinal;
		double yFinal;
		
		for(Point point : points) {
			//Moves the point the closest to the origin without removing any point from the screen
			//to scale it better.
			xReal = point.getX() - minMax.getXMin();
			//To adapt points to a norrmal x-y plane.
			yReal = minMax.getYMax() - point.getY();
			
			
			xFinal = ((xReal / range) * FRAME_RANGE) + 50;
			yFinal = ((yReal / range) * FRAME_RANGE) + 50;
			
			point.setX(xFinal);
			point.setY(yFinal);
		}
	}
}
