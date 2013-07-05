package vrpApp;

//Calculates the distance between two clients using the total time, total distance and urgency(end of windows - truck arrival time)
//It uses certain parameters received in the configuration object to normalize and weight the final aptitude.
public class ObjectiveFunction2 extends ObjectiveFunction{

	public double computeAptitude(ClientLog client1, ClientLog client2) {
		double alpha = 0.0;
		double beta = 0.0;
		double gamma = 0.0;
		double distFactor = 0.0;
		double timeFactor = 0.0; 
		double urgencyFactor = 0.0;
		double distance;
		int time;
		int urgency;
		
		try{
			alpha = Double.parseDouble(configuration.get("alpha"));
			beta = Double.parseDouble(configuration.get("beta"));
			gamma = Double.parseDouble(configuration.get("gamma"));
			
			distFactor = Double.parseDouble(configuration.get("distanceFactor"));
			timeFactor = Double.parseDouble(configuration.get("timeFactor"));
			urgencyFactor = Double.parseDouble(configuration.get("urgencyFactor"));
		
		}catch(Exception e){
			e.printStackTrace();
			ErrorHandler.showError(13, "ObjectiveFunction2.computeAptitude(ClientLog, ClientLog)", true);
		}
		

		// Calculate the data needed to compute the aptitude.
		distance = client1.getDistanceTo(client2.getClientNumber());
		time = client1.getTimeTo(client2.getClientNumber());
		urgency = client2.getTimeWindowEnd() - client2.getTruckArrivalTime();

			
		//Calculate total aptitude
		double aptitude = (alpha*distance)/distFactor + (beta*time)/timeFactor + (gamma*urgency)/urgencyFactor;
		
		return aptitude;
	}
}
