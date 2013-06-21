import java.util.ArrayList;
import java.util.List;

//MODEL
public class Route {
	private List<Client> clients;
	private double distance;
	private int time;

	public Route(){
		clients = new ArrayList<Client>();
	}
	
	public void recomputeData() {
		// TODO
	}

	public int getClientCount() {
		return -1;
	}

	public boolean insertClientAt(Client client, int pos) {
		// TODO
		return false;
	}

	public boolean addClientAtEnd(Client client) {
		//try{
			clients.add(client);
			return true;
		//}catch(Exception e){
		//	return false;
		//}
	}

	public void deleteClient(int pos) {
		// TODO
	}

	public boolean isEmpty() {
		// TODO
		return true;
	}

	private boolean isFeasible() {
		// TODO
		return true;
	}

	public void clear() {
		// TODO
	}

	private void computeDistance() {
		// TODO
	}

	private void computeTime() {
		// TODO
	}

	// Getters and Setters----------------------------
	public List<Client> getClients(){
		return clients;
	}
	
	public double getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}
	// -----------------------------------------------
}
