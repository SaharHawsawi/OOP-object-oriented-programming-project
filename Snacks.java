package movietheater;

/**
 * this class will have all the information of the snacks that the movie theater is selling
 */

public class Snacks extends MovieItems implements Bookable {

    private String company;
    private boolean available = true;

    /**
     * a default constructor
     */
    public Snacks() {
    }

    /**
     * a constructor initializing the company and if the snack is available or
     * not
     *
     * @param company for which company made the snack
     * @param Name of the snack
     * @param ItemID the ID of the snack
     * @param price the price of the snack
     */

    public Snacks(String company, String Name, Integer ItemID, double price) {
        super(Name, ItemID, price);
        this.company = company;

        this.available = true;
    }

    /**
     * to check if the snack is available or not
     *
     * @return true if available and false if not
     */
    @Override
    public boolean bookItem() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    /**
     * to cancel a booking
     *
     * @return true if the booking is canceled
     */
    @Override
    public boolean cancelBooking() {
        available = true;
        return true;
    }
/**
 *  to check if the snack is available 
 * @return true if available 
 */ 
    @Override
    public boolean isAvailable() {
        return available;
    }
/**
 * @return company
 */ 
    public String getCompany() {
        return company;
    }
/**
 * @param company sets the company
 */ 
    public void setCompany(String company) {
        this.company = company;
    }
/**
 * @param comp to check if the company match the snack
 */ 
    public boolean isFromCompany(String comp) {
        return this.company.equalsIgnoreCase(comp);
    }
/**
 * @return printing details
 */ 
    @Override
    public String toString() {
        return super.toString() + "company : " + company;
    }

}