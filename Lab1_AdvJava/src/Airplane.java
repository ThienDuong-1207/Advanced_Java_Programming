import java.time.LocalTime;

public class Airplane {
private String flightNumber;
    private String destination;
    private LocalTime scheduledDeparture;
    private int delayMinutes;

    // Constructor
    public Airplane(String flightNumber, String destination, LocalTime scheduledDeparture) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.scheduledDeparture = scheduledDeparture;
        this.delayMinutes = 0;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public LocalTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public int getDelayMinutes() {
        return delayMinutes;
    }

    // Setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setScheduledDeparture(LocalTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    // Method to delay flight
    public void delay(int minutes) {
        delayMinutes += minutes;
        scheduledDeparture = scheduledDeparture.plusMinutes(minutes);
    }

    // Method to check flight status
    public void checkStatus() {
        if (delayMinutes > 0) {
            System.out.println("Flight " + flightNumber + " to " + destination +
                               " is delayed by " + delayMinutes + " minutes. " +
                               "New departure: " + scheduledDeparture);
        } else {
            System.out.println("Flight " + flightNumber + " to " + destination +
                               " is on time. Departure: " + scheduledDeparture);
        }
    }
}
