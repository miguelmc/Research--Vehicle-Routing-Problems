import java.util.List;

//MODEL
public class Route {
	private List<Client> clients;
	private double distance;
	private int time;

	public void recomputeData(){
		//TODO
	}
	public int getClientCount(){
		//TODO
		return 0;
	}
	public boolean insertClientAt(Client client, int pos){
		//TODO
		return true;
	}
	public void addClientAtEnd(Client client){
		//TODO
	}
	public int deleteClient(int number){
		//TODO
		return 0;
	}
	public boolean isEmpty(){
		//TODO
		return true;
	}
	private boolean isFeasible(){
		//TODO
		return true;
	}
	public void clear(){
		//TODO
	}
	private void computeDistance(){
		//TODO
	}
	private void computeTime(){
		//TODO
	}
	
	//Getters and Setters----------------------------
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	//-----------------------------------------------
}
