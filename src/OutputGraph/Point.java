package OutputGraph;


//could also be an Entry
public class Point{

	double x,y;

	public Point(){
		x = 0;
		y = 0;
	}

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
