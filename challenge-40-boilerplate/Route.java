public class Route{
    private String sourceCity;
    private String destinationCity;
    private int distanceInKms;
    private String flightTime;
    private String ticketCost;

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getDistanceInKms() {
        return distanceInKms;
    }

    public void setDistanceInKms(int distanceInKms) {
        this.distanceInKms = distanceInKms;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(String ticketCost) {
        this.ticketCost = ticketCost;
    }

    
}