package OutputGraph;

import java.util.ArrayList;

public class MaxMinCoords {
	private double xMin, xMax, yMin, yMax;

	public MaxMinCoords() {
		xMin = xMax = yMin = yMax = 0;
	}

	public void setXMin(double x) {
		xMin = x;
	}

	public void setXMax(double x) {
		xMax = x;
	}

	public void setYMin(double y) {
		yMin = y;
	}

	public void setYMax(double y) {
		yMax = y;
	}

	public double getXMin() {
		return xMin;
	}

	public double getXMax() {
		return xMax;
	}

	public double getYMin() {
		return yMin;
	}

	public double getYMax() {
		return yMax;
	}
	
	public static MaxMinCoords getMinMax(ArrayList<Point> points) {
		MaxMinCoords maxMinCoords = new MaxMinCoords();
		boolean start = true;
		for (Point i : points) {
			if (start) {
				maxMinCoords.setXMin(i.getX());
				maxMinCoords.setXMax(i.getX());
				maxMinCoords.setYMin(i.getY());
				maxMinCoords.setYMax(i.getY());
				start = false;
			}

			if (i.getX() < maxMinCoords.getXMin())
				maxMinCoords.setXMin(i.getX());
			else if (i.getX() > maxMinCoords.getXMax())
				maxMinCoords.setXMax(i.getX());

			if (i.getY() < maxMinCoords.getYMin())
				maxMinCoords.setYMin(i.getY());
			else if (i.getY() > maxMinCoords.getYMax())
				maxMinCoords.setYMax(i.getY());
		}

		return maxMinCoords;
	}
}
