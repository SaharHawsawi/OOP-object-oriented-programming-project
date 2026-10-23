package movietheater;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
/**
 * this class will have all the information of the bookings
 */
public class MovieBookingSystem {

    private ArrayList<MovieItems> catalog;
    private TreeSet<Customer> customers;
/**
     * a default constructor
     */
    public MovieBookingSystem() {
        catalog = new ArrayList<>();
        customers = new TreeSet<>((c1, c2) -> c1.getId().compareTo(c2.getId()));
    }
/**
     * a constructor initializing the catalog and the customers
     * @param catalog for the catalog of the items the movie theater offers
     * @param customers to organize the customers
     */
    public MovieBookingSystem(ArrayList<MovieItems> catalog, TreeSet<Customer> customers) {
        this.catalog = catalog;
        this.customers = customers;
    }
/**
 * to add the item to the booking
 * @param item holds the item that`s going to be added
 */
    public void addItem(MovieItems item) {
        catalog.add(item);
    }
/**
 * to register the customer 
 * @param c holds the person that`s going to be added to the booking
 */
    public void registerCustomer(Customer c) {
        customers.add(c);
    }
/**
 * to check by id if the item exists or not
 * @param id holds the item that`s going to be added
 * @return true if the item exists and false if it is not
 */
    public MovieItems searchItemByID(Integer id) throws MovieNotFoundException {
        return catalog.stream()
                .filter(i -> i.getItemID().equals(id))
                .findFirst()
                .orElseThrow(() -> new MovieNotFoundException("Item with ID " + id + " not found."));
    }
/**
 * to check by name if the item exists or not
 */
    public void sortItemsByName() {
        Collections.sort(catalog, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
    }
/**
 * to print all items
 */
    public void printAllItems() {
        for (MovieItems item : catalog) System.out.println(item);
    }
/**
 * to print all customers
 */
    public void printAllCustomers() {
        for (Customer c : customers) System.out.println(c);
    }
/**
 * to print all the bookings information
 * @param id holds the id of the customer
 */
    public void printBookingsForCustomer(Integer id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                for (Booking b : c.getBookings()) System.out.println(b);
                return;
            }
        }
        System.out.println("Customer not found.");
    }
 /**
 * to check if the item exists or not
 * @param itemId holds the id to the item that`s going to be booked
 * @return false if there is an error
 */
    public boolean bookItem(Integer itemId) {
        try {
            MovieItems item = searchItemByID(itemId);
            if (item instanceof Bookable) {
                Bookable bookableItem = (Bookable) item;
                return bookableItem.bookItem();
            }
        } catch (MovieNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
   /**
 * to cancel the booking
 * @param itemId holds the id to the item 
 * @return false if there is an error
 */
     public boolean cancelBooking(Integer itemId) {
        try {
            MovieItems item = searchItemByID(itemId);
            if (item instanceof Bookable) {
                Bookable bookableItem = (Bookable) item;
                return bookableItem.cancelBooking();
            }
        } catch (MovieNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
