import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RouteImplementation ri=new RouteImplementation();
        ArrayList<Route> travel=ri.userInput("sample-inputs.txt");
        ri.traversal(travel);
        ArrayList<Route> userTravelRoute=ri.showDirectFlights(travel);
        ri.sortedList(userTravelRoute);
        ArrayList<Route> finalList=ri.showAllConnections(travel);
        ri.showAllConnectionsCalculation(finalList);
    }
}
