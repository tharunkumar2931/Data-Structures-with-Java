import java.util.*;
public class RouteList implements Comparator<Route>{

    public int compare(Route a1,Route a2){   
        return a1.getDestinationCity().compareTo(a2.getDestinationCity()); 
     }
}