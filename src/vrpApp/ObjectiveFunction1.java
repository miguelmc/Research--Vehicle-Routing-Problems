package vrpApp;

public class ObjectiveFunction1 extends ObjectiveFunction {
	
	@Override
	public double computeAptitude(Solution solution) {
		
		double alpha = 0.0;
		double beta = 0.0;
		double gamma = 0.0;
		double distFactor = 0.0;
		double timeFactor = 0.0; 
		double windowFactor = 0.0;
		double normDist = 0.0;
		double normTime = 0.0;
		double normWindow = 0.0;
		int totalClients = 0; 
		int notRespectedWindows = 0;
		
		try{
			alpha = Double.parseDouble(configuration.get("alpha"));
			beta = Double.parseDouble(configuration.get("beta"));
			gamma = Double.parseDouble(configuration.get("gamma"));
			
			distFactor = Double.parseDouble(configuration.get("distanceFactor"));
			timeFactor = Double.parseDouble(configuration.get("timeFactor"));
			windowFactor = Double.parseDouble(configuration.get("windowFactor"));
		
		}catch(Exception e){
			e.printStackTrace();
			ErrorHandler.showError(13, "ObjectiveFunction1.computeAptitude(Solution)", true);
		}
		
		// Calculate the total number of clients and number of not respected windows.
		
		for(Route route : solution.getRoutes()){
			totalClients += route.getClientCount();
			for(ClientLog clientLog : route.getClientLogs()){
				if(clientLog.getTruckArrivalTime() > clientLog.getTimeWindowEnd())
					++notRespectedWindows;
			}
		}

		normDist = solution.getTotalDistance()/		(totalClients*distFactor);
		normTime = solution.getTotalTime()/	(totalClients*timeFactor);
		normWindow = notRespectedWindows/	(totalClients*windowFactor);
		
		double response = alpha*normDist + beta*normTime + gamma*normWindow;
		return response;
	}
}
