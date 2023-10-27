import java.util.ArrayList;
import java.util.List;

class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private int availableSeats;
    private int totalSeats;

    public Flight(int flightNumber, String origin, String destination, int totalSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = totalSeats;
        this.totalSeats = totalSeats;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public boolean reserveSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination +
               " (Available Seats: " + availableSeats + "/" + totalSeats + ")";
    }
}

class Passenger {
    private int passengerId;
    private String name;
    private List<Flight> flights;

    public Passenger(int passengerId, String name) {
        this.passengerId = passengerId;
        this.name = name;
        this.flights = new ArrayList<>();
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void bookFlight(Flight flight) {
        if (flight.reserveSeat()) {
            flights.add(flight);
        }
    }

    @Override
    public String toString() {
        return "Passenger ID: " + passengerId + ", Name: " + name;
    }
}

public class AirlineReservationSystem {
    public static void main(String[] args) {
        Flight flight1 = new Flight(101, "New York", "Los Angeles", 150);
        Flight flight2 = new Flight(102, "Chicago", "Miami", 120);
        Flight flight3 = new Flight(103, "San Francisco", "Las Vegas", 100);

        Passenger passenger1 = new Passenger(201, "Alice");
        Passenger passenger2 = new Passenger(202, "Bob");

        passenger1.bookFlight(flight1);
        passenger1.bookFlight(flight2);
        passenger2.bookFlight(flight3);

        displayPassengerStatus(passenger1);
        displayPassengerStatus(passenger2);
    }

    public static void displayPassengerStatus(Passenger passenger) {
        System.out.println("\nPassenger Information:");
        System.out.println(passenger);

        List<Flight> bookedFlights = passenger.getFlights();
        if (!bookedFlights.isEmpty()) {
            System.out.println("Booked Flights:");
            for (Flight flight : bookedFlights) {
                System.out.println(flight);
            }
        } else {
            System.out.println("No flights booked by this passenger.");
        }
    }
}
