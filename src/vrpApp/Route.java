package vrpApp;

import java.util.ArrayList;
import java.util.List;

//MODEL
public class Route {
	// Routes does not have the depot in its clients List
	private List<Client> clients;
	private double distance;
	private int time;

	public Route() {
		clients = new ArrayList<Client>();
	}

	public void recomputeData() {
		computeDistance();
		computeTime();
	}

	public int getClientCount() {
		return clients.size();
	}

	// Take into account that the positions start in 1, not in 0.
	public boolean insertClientAt(Client client, int pos) {
		// TODO
		// To insert a client we change accordingly the data in the clients that
		// follow after it.
		// Then we call isFeasible to confirm that we can insert the client.
		// If we cannot we revert the changes and return false.
		return false;
	}

	// Take into account that the positions start in 1, not in 0.
	public boolean addClientAtEnd(Client client) {
		// To insert a client we change accordingly the data in the clients that
		// follow after it.
		// Then we call isFeasible to confirm that we can insert the client.
		// If we cannot we revert the changes and return false.
		// TODO
		clients.add(client);
		if (isFeasible())
			return true;
		else {
			deleteClient(clients.size());
			return false;
		}
	}

	// Take into account that the positions start in 1, not in 0.
	public void deleteClient(int pos) {
		clients.remove(pos - 1);
	}

	public boolean isEmpty() {
		return clients.isEmpty();
	}

	private boolean isFeasible() {
		// TODO
		return true;
	}

	public void clear() {
		clients.clear();
		distance = 0;
		time = 0;
	}

	private void computeDistance() {
		// TODO
	}

	private void computeTime() {
		// TODO
	}

	// Getters and Setters----------------------------
	public List<Client> getClients() {
		return clients;
	}

	public Client getClientAt(int pos) {
		return clients.get(pos - 1);
	}

	public double getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}
	// -----------------------------------------------
}
