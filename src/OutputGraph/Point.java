package OutputGraph;


//could also be an Entry
public class Point{

	double x,y;
	int number;

	public int getNumber() {
		return number;
	}
	
	public String getNumberAsString() {
		Integer i = number;
		return i.toString();
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Point(){
		x = 0;
		y = 0;
		number = 0;
	}

	public Point(double x, double y, int number){
		this.x = x;
		this.y = y;
		this.number = number;
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
