package vrpApp;

//MODEL
public class Vehicle {
	private int capacity;
	private int vehicleCount;

	public Vehicle() {
		capacity = 0;
		vehicleCount = 0;
	}

	/* +++++++++++++++++++ Getters and Setters +++++++++++++++++++++++++++++ */

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getVehicleCount() {
		return vehicleCount;
	}

	public void setVehicleCount(int vehicleCount) {
		this.vehicleCount = vehicleCount;
	}
}
