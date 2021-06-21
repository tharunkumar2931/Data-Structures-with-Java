import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class RouteImplementation {
    public ArrayList<Route> userInput(String fileName) {
        ArrayList<Route> travel = new ArrayList<>();
        try {
            int count = 0;
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bf.readLine()) != null) {
                count = count + 1;
            }
            String[] temp = new String[6];
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String data;
            br.readLine();
            int j = 0;// incrementor
            while ((data = br.readLine()) != null) // read the file until end
            {
                temp = data.split(", ");
                Route s = new Route();
                try {
                    s.setSourceCity(temp[0]);
                    s.setDestinationCity(temp[1]);
                    s.setDistanceInKms(Integer.parseInt(temp[2]));
                    s.setFlightTime(temp[3]);
                    s.setTicketCost(temp[4]);
                    travel.add(s);
                } catch (NumberFormatException n) {
                    n.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return travel;
    }

    public void traversal(ArrayList<Route> travel) {
        int j = 1;
        System.out.format("S.No" + "      From" + "        To" + "       Distance in Kms" + "      Travel Time"
                + "      Typical Airfare" + "\n");
        for (int i = 0; i < travel.size(); i++) {
            System.out.println(
                    j + "        " + travel.get(i).getSourceCity() + "      " + travel.get(i).getDestinationCity()
                            + "         " + travel.get(i).getDistanceInKms() + "              "
                            + travel.get(i).getFlightTime() + "             " + travel.get(i).getTicketCost());
            j = j + 1;
        }
    }
/** the below method is for showing direct flghts by taking the city from user and comparing with the list and printing the equaled data */
    public ArrayList<Route> showDirectFlights(ArrayList<Route> travel) {
        ArrayList<Route> userTravelRoute = new ArrayList<>();
        int j = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city from which you are travelling ");
        String searchCity = sc.next();
        System.out.format("S.No" + "      From" + "        To" + "       Distance in Kms" + "      Travel Time"
                + "      Typical Airfare" + "\n");
        for (int i = 0; i < travel.size(); i++) {
            if (travel.get(i).getSourceCity().equalsIgnoreCase(searchCity)) {
                System.out.println(
                        j + "        " + travel.get(i).getSourceCity() + "      " + travel.get(i).getDestinationCity()
                                + "         " + travel.get(i).getDistanceInKms() + "              "
                                + travel.get(i).getFlightTime() + "             " + travel.get(i).getTicketCost());
                j = j + 1;
                userTravelRoute.add(travel.get(i));
            }
        }
        return userTravelRoute;
    }
/**sorting the arraylist using collection sort */
    public void sortedList(ArrayList<Route> userTravelRoute) {
        int j = 1;
        Collections.sort(userTravelRoute, new RouteList());
        System.out.println(
                "sorted list.................................................................................................");
        System.out.format("S.No" + "      From" + "        To" + "       Distance in Kms" + "      Travel Time"
                + "      Typical Airfare" + "\n");
        for (Route r : userTravelRoute) {
            System.out.println(j + "        " + r.getSourceCity() + "      " + r.getDestinationCity() + "         "
                    + r.getDistanceInKms() + "              " + r.getFlightTime() + "             "
                    + r.getTicketCost());
            j = j + 1;
        }
    }
/** in below mwthod taking the input from user fromcity and to city first comparing from and to cities in if loop with the list is it exeits we are printing the data
 * and again checking the fromcities only and tocities only in the list and store it in arraylist and again iam comparing destination city from fromcities and source city from tocities to get connecting flights
 */
    public ArrayList<Route> showAllConnections(ArrayList<Route> travel) {
        int j = 1, n = 0, count = 0;
        ArrayList<Route> fromCities = new ArrayList<>();
        ArrayList<Route> toCities = new ArrayList<>();
        ArrayList<Route> finalList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city from which you are travelling");
        String fromCity = sc.next();
        System.out.println("Enter the city to which you are travelling");
        String toCity = sc.next();
        System.out.format("S.No" + "      From" + "        To" + "       Distance in Kms" + "      Travel Time"
                + "      Typical Airfare" + "\n");
        for (int i = 0; i < travel.size(); i++) {
            if (travel.get(i).getSourceCity().equalsIgnoreCase(fromCity)
                    && travel.get(i).getDestinationCity().equalsIgnoreCase(toCity)) {
                System.out.println(
                        j + "        " + travel.get(i).getSourceCity() + "      " + travel.get(i).getDestinationCity()
                                + "         " + travel.get(i).getDistanceInKms() + "              "
                                + travel.get(i).getFlightTime() + "             " + travel.get(i).getTicketCost());
                j = j + 1;
            }
        }
        for (int i = 0; i < travel.size(); i++) {
            if (travel.get(i).getSourceCity().equalsIgnoreCase(fromCity))// if the row contains from city
            {
                fromCities.add(travel.get(i));// storing the from cities
                n = n + 1;// incrementing
            }
            if (travel.get(i).getDestinationCity().equalsIgnoreCase(toCity))// if the row contains to city
            {
                toCities.add(travel.get(i));// storing all the to city rows
                count = count + 1;// incrementing
            }
        }
        for (int i = 0; i < n; i++)// for each loop
        {
            int s = 0;
            for (int h = 0; h < count; h++)// for each loop
            {
                if (fromCities.get(i).getDestinationCity().equalsIgnoreCase(toCities.get(h).getSourceCity()))
                {
                    System.out.println(s + "        " + fromCities.get(i).getSourceCity() + "      "
                            + fromCities.get(i).getDestinationCity() + "         "
                            + fromCities.get(i).getDistanceInKms() + "              "
                            + fromCities.get(i).getFlightTime() + "             " + fromCities.get(i).getTicketCost());
                    System.out.println("        " + toCities.get(h).getSourceCity() + "      "
                            + toCities.get(h).getDestinationCity() + "         " + toCities.get(h).getDistanceInKms()
                            + "              " + toCities.get(h).getFlightTime() + "             "
                            + toCities.get(h).getTicketCost());
                    finalList.add(fromCities.get(i));
                    finalList.add(toCities.get(h));
                }
                s = s + 1;
            }
        }
        return finalList;
    }
/**we are calculating the distance,time,amount of route by taking the list from above method */
    public void showAllConnectionsCalculation(ArrayList<Route> finalList) {
        int distance = 0;
        long sum=0;
        double amount=0;
        for (int i = 0; i < finalList.size(); i++) {
            distance = distance + finalList.get(i).getDistanceInKms();
            long times = timeConverter(finalList.get(i).getFlightTime());
            sum=sum+times;
            String currency=finalList.get(i).getTicketCost().substring(0,3);
            String money=finalList.get(i).getTicketCost().substring(3);
            if(currency.equals("INR")){
                amount=amount+Double.parseDouble(money);
            }
            else if(currency.equals("EUR")){
                double amounts=Double.parseDouble(money);
                amount=amount+amounts*89.52;
            }
            else if(currency.equals("USD")){
                double amounts=Double.parseDouble(money);
                amount=amount+amounts*73.91;
            }
            else if(currency.equals("GBP")){
                double amounts=Double.parseDouble(money);
                amount=amount+amounts*99.24;
            }
            else if(currency.equals("SGD")){
                double amounts=Double.parseDouble(money);
                amount=amount+amounts*55.29;
            }
            else if(currency.equals("JPY")){
                double amounts=Double.parseDouble(money);
                amount=amount+amounts*0.71;
            }
        }
        Date finalTime=new Date(sum);
        System.out.println("                    "+"Total"+"          "+distance+"       "+finalTime.getHours()+"    "+amount);
    }

    public long timeConverter(String time) {
        DateFormat sdf = new SimpleDateFormat("hh:mm");
        long date;
        try {
            date = sdf.parse(time).getHours();
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
