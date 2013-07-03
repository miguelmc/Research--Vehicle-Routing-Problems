package vrpApp;

import java.util.List;

//This heuristic will receive a Solution and a number of routes n and will choose n routes at random and
//relocate one client in a different position.

public class Relocate extends ImprovementHeuristic {
	
	//This function will create a copy of the solution passed and change it according to the Relocate heuristic
	public Solution generateAlternativeSolution(Solution solution) {
		int numRoutes = 0; 
		int oldTargetLocation;
		int newTargetLocation;
		Route targetRoute;
		Client targetClient;
		List<Route> routes;
		
		try{
			numRoutes = Integer.parseInt(configuration.get("numberOfRoutesToRelocate"));
		}
		catch(NumberFormatException e){
			e.printStackTrace();
			ErrorHandler.showError(14, "Relocate.generateAlternativeSolution(Solution)", true);
		}
		
		//Check that the number of routes received is not greater than the total number of routes in the solution
		numRoutes = Math.min(numRoutes, solution.getRouteCount());
		
		//Create a deep copy of the solution so that the old solution can be preserved and used to compare aptitudes.
		solution = new Solution(solution);
				
		routes = solution.getRoutes();
		boolean isAdditionOK;
		for(int i = 0; i < numRoutes; i++){
			//Select a route to made the relocation
			targetRoute = routes.get(generateRandomInteger(0, routes.size()-1));
			
			if(!targetRoute.isEmpty()){
				// Select the position of the client to relocate
				oldTargetLocation = generateRandomInteger(1, targetRoute.getClientCount());
				
				// Obtain the client that will be relocated
				targetClient = targetRoute.getClientAt(oldTargetLocation);
				
				// Delete client from target route
				targetRoute.deleteClient(oldTargetLocation);
				
				// Select the position were the client will be inserted
				newTargetLocation = generateRandomInteger(1, targetRoute.getClientCount() + 1);
				
				// Try to insert the client at the new location, if not possible revert the changes.
				isAdditionOK = targetRoute.insertClientAt(targetClient, newTargetLocation);
				if(!isAdditionOK){
					targetRoute.insertClientAt(targetClient, oldTargetLocation);
				}
			}
		}
		
		// We need this recompute because the solution does not know when a route has been changed.
		solution.recomputeData();
		
		return solution;
	}
}
