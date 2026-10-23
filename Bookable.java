package movietheater;

public interface Bookable {
    boolean bookItem();
    boolean cancelBooking();
    boolean isAvailable();
}
