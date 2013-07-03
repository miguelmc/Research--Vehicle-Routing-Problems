package vrpApp;
import java.util.ArrayList;
import java.util.List;

//MODEL
public class Problem {
	private String type;
	private String instanceName;
	private List<Vehicle> vehicles;
	private List<Client> clients;

	public Problem() {
		type = null;
		instanceName = null;
		vehicles = new ArrayList<Vehicle>();
		clients = new ArrayList<Client>();
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	/* +++++++++++++++++++ Getters and Setters +++++++++++++++++++++++++++++ */

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
}
