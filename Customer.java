package movietheater;
import java.util.ArrayList;

/**
 * Represents a customer in the movie theater system.
 * Each customer can have multiple bookings.
 */
public class Customer {

    private Integer id;
    private String name;
    private String phone;
    private ArrayList<Booking> bookings;

    /**
     * Default constructor initializes booking list.
     */
    public Customer() {
        this.bookings = new ArrayList<>();
    }

    /**
     * Creates a customer with id, name, and phone.
     *
     * @param id customer ID
     * @param name customer name
     * @param phone customer phone number
     */
    public Customer(Integer id, String name, String phone) {
        this();
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    /**
     * Checks if the customer has any active bookings.
     *
     * @return true if active bookings exist
     */
    public boolean hasActiveBookings() {
        for (Booking booking : bookings) {
            if ("Active".equals(booking.getStatus())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes the customer only if no active bookings exist.
     *
     * @return true if deletion allowed
     */
    public boolean deleteCustomer() {
        if (hasActiveBookings()) {
            System.out.println("Cannot delete customer with active bookings!");
            return false;
        }
        bookings.clear();
        return true;
    }

    /** @return customer ID */
    public Integer getId() { return id; }

    /** @param id sets customer ID */
    public void setId(Integer id) { this.id = id; }

    /** @return customer name */
    public String getName() { return name; }

    /** @param name sets name */
    public void setName(String name) { this.name = name; }

    /** @return phone number */
    public String getPhone() { return phone; }

    /** @param phone sets phone */
    public void setPhone(String phone) { this.phone = phone; }

    /** @return list of bookings */
    public ArrayList<Booking> getBookings() { return bookings; }

    /**
     * Adds a booking to the customer's list.
     *
     * @param booking booking object
     */
    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    @Override
    public String toString() {
        return "Customer[ID:" + id +
                ", Name:" + name +
                ", Phone:" + phone + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return id.equals(customer.id);
    }

    /**
     * Creates a copy of the customer.
     *
     * @return cloned Customer
     */
    public Customer clone() {
        return new Customer(this.id, this.name, this.phone);
    }
}