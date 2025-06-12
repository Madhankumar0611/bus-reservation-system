import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Bus> buses = new ArrayList<>();

    public static void main(String[] args) {
        buses.add(new Bus(101, "John", 5));
        buses.add(new Bus(102, "Alice", 3));
        buses.add(new Bus(103, "Bob", 4));

        int choice;
        do {
            System.out.println("\n--- Bus Reservation System ---");
            System.out.println("1. View Buses");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Seat");
            System.out.println("4. View Passengers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    for (Bus bus : buses) bus.showDetails();
                    break;
                case 2:
                    System.out.print("Enter Bus No: ");
                    int bookBusNo = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Your Name: ");
                    String passenger = sc.nextLine();
                    bookSeat(bookBusNo, passenger);
                    break;
                case 3:
                    System.out.print("Enter Bus No: ");
                    int cancelBusNo = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Your Name: ");
                    String nameToCancel = sc.nextLine();
                    cancelSeat(cancelBusNo, nameToCancel);
                    break;
                case 4:
                    for (Bus bus : buses) bus.showPassengers();
                    break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void bookSeat(int busNo, String name) {
        for (Bus bus : buses) {
            if (bus.busNo == busNo) {
                if (bus.bookSeat(name)) {
                    System.out.println("Booking successful!");
                } else {
                    System.out.println("Bus is full.");
                }
                return;
            }
        }
        System.out.println("Bus not found.");
    }

    static void cancelSeat(int busNo, String name) {
        for (Bus bus : buses) {
            if (bus.busNo == busNo) {
                if (bus.cancelSeat(name)) {
                    System.out.println("Booking cancelled.");
                } else {
                    System.out.println("Name not found.");
                }
                return;
            }
        }
        System.out.println("Bus not found.");
    }
}
