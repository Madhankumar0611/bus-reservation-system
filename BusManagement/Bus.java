import java.util.ArrayList;
import java.util.List;

public class Bus {
    public int busNo;
    public String driverName;
    public int capacity;
    public List<String> passengers;

    public Bus(int busNo, String driverName, int capacity) {
        this.busNo = busNo;
        this.driverName = driverName;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public boolean bookSeat(String passengerName) {
        if (passengers.size() < capacity) {
            passengers.add(passengerName);
            return true;
        }
        return false;
    }

    public boolean cancelSeat(String passengerName) {
        return passengers.remove(passengerName);
    }

    public void showDetails() {
        System.out.println("Bus No: " + busNo + " | Driver: " + driverName + " | Capacity: " + capacity + " | Booked: " + passengers.size());
    }

    public void showPassengers() {
        System.out.println("Passengers on Bus " + busNo + ": " + passengers);
    }
}
