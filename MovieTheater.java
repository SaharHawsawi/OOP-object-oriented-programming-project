//project of Object Oriented Programming 
package movietheater;

/* Team members: Ansam Mohammed, Maareb Felemban, Sahar Hawsawi
 * ID: 446000097 , 44611014 , 446002564
 * 
 */
import java.util.Scanner;

/*
 * Main class for running and testing the Movie Theater Booking System.
 * This class demonstrates adding items, registering customers,
 * booking and canceling items, sorting, exceptions, equals(), and clone().
 */
public class MovieTheater {

    /**
     * The entry point of the program. Runs a full demo of the movie theater system.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        MovieBookingSystem system = new MovieBookingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Movie Theater Booking System ===\n");

        Movie movie1 = new Movie("Action", "The Matrix", 1, 50.0);
        Movie movie2 = new Movie("Sci-Fi", "Interstellar", 2, 45.0);
        Snacks snack1 = new Snacks("Pepsi", "Large Popcorn", 3, 25.0);
        Snacks snack2 = new Snacks("Coca-Cola", "Soft Drink", 4, 15.0);

        system.addItem(movie1);
        system.addItem(movie2);
        system.addItem(snack1);
        system.addItem(snack2);

        Customer customer1 = new Customer(101, "Ahmed Ali", "0555123456");
        Customer customer2 = new Customer(102, "Sara Mohammed", "0555654321");

        system.registerCustomer(customer1);
        system.registerCustomer(customer2);

        System.out.println("=== All Movie Items ===");
        system.printAllItems();

        System.out.println("\n=== All Customers ===");
        system.printAllCustomers();

        System.out.println("\n=== Booking Items ===");
        boolean booked1 = system.bookItem(1);
        if (booked1) {
            System.out.println("Successfully booked The Matrix");
            Booking booking1 = new Booking(1001, customer1, movie1);
            customer1.addBooking(booking1);
        }

        boolean booked2 = system.bookItem(3);
        if (booked2) {
            System.out.println("Successfully booked Large Popcorn");
            Booking booking2 = new Booking(1002, customer1, snack1);
            customer1.addBooking(booking2);
        }

        System.out.println("\n=== Customer 101 Bookings ===");
        system.printBookingsForCustomer(101);

        System.out.println("\n=== Canceling Booking ===");
        boolean canceled = system.cancelBooking(1);
        if (canceled) {
            System.out.println("Successfully canceled booking for The Matrix");
        }

        System.out.println("\n=== Sorted Items by Name ===");
        system.sortItemsByName();
        system.printAllItems();

        System.out.println("\n=== Testing Exception Handling ===");
        try {
            MovieItems notFound = system.searchItemByID(999);
        } catch (MovieNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("\n=== Testing Customer Deletion ===");
        boolean deleted = customer1.deleteCustomer();
        if (deleted) {
            System.out.println("Customer deleted successfully");
        } else {
            System.out.println("Cannot delete customer - has active bookings");
        }

        System.out.println("\n=== Testing equals() Method ===");
        Movie movie3 = new Movie("Action", "The Matrix", 1, 50.0);
        System.out.println("Are movies equal? " + movie1.equals(movie3));

        System.out.println("\n=== Testing clone() Method ===");
        Customer clonedCustomer = customer2.clone();
        System.out.println("Original: " + customer2);
        System.out.println("Cloned: " + clonedCustomer);

        scanner.close();
        System.out.println("\n=== Program Ended ===");
    }
}
