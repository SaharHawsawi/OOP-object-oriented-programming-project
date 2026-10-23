package movietheater;
import java.util.Date;

/**
 * Represents a booking made by a customer for a movie or snack item.
 */
public class Booking {

    private Integer bookingId;
    private Date bookingDate;
    private String status;
    private Customer customer;
    private MovieItems item;

    /**
     * Default constructor initializing booking status and date.
     */
    public Booking() {
        this.status = "Active";
        this.bookingDate = new Date();
    }

    /**
     * Creates a new booking with the provided details.
     *
     * @param bookingId unique booking ID
     * @param customer the customer making the booking
     * @param item the booked item
     */
    public Booking(Integer bookingId, Customer customer, MovieItems item) {
        this();
        this.bookingId = bookingId;
        this.customer = customer;
        this.item = item;
    }

    /** @return booking ID */
    public Integer getBookingId() { return bookingId; }

    /** @param bookingId sets the booking ID */
    public void setBookingId(Integer bookingId) { this.bookingId = bookingId; }

    /** @return booking date */
    public Date getBookingDate() { return bookingDate; }
     /** @param bookingDate sets the booking Date */
    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate;}
    

    /** @return booking status */
    public String getStatus() { return status; }

    /** @param status sets a new status */
    public void setStatus(String status) { this.status = status; }

    /** @return customer */
    public Customer getCustomer() { return customer; }

    /** @param customer sets the customer */
    public void setCustomer(Customer customer) { this.customer = customer; }

    /** @return booked item */
    public MovieItems getItem() { return item; }

    /** @param item sets the booked item */
    public void setItem(MovieItems item) { this.item = item; }

    @Override
    public String toString() {
        return "Booking[ID:" + bookingId +
                ", Customer:" + customer.getName() +
                ", Item:" + item.getName() +
                ", Status:" + status + "]";
    }
}