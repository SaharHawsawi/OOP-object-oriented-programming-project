package movietheater;
import java.util.ArrayList;
/**
 * this class will have the information about all the items the that the movie theater is offering
 */
public abstract class MovieItems {

    private String Name;
    private Integer ItemID;
    private double price;
    ArrayList<Movie> MovieItems = new ArrayList<>();
/**
     * a default constructor
     */
    public MovieItems() {}
/**
     * a constructor initializing the name, ItemID and the price
     * @param Name of the snack
     * @param ItemID the ID of the snack
     * @param price the price of the snack
     */
    public MovieItems(String Name, Integer ItemID, double price) {
        this.Name = Name;
        this.ItemID = ItemID;
        this.price = price;
    }
/**
 * @return name
 */
    public String getName() {
        return Name;
    }
/**
 * @param Name sets the Name
 */ 
    public void setName(String Name) {
        this.Name = Name;
    }
/**
 * @return ItemID
 */
    public Integer getItemID() {
        return ItemID;
    }
/**
 * @param ItemID sets the ItemID
 */ 
    public void setItemID(Integer ItemID) {
        this.ItemID = ItemID;
    }
/**
 * @return price
 */
    public double getPrice() {
        return price;
    }
/**
 * @param price sets the price
 */
    public void setPrice(double price) {
        this.price = price;
    }
/**
 * to add the movie to the movie collection
 * @param movie holds the movie that`s going to be added
 */
    public void addMovie(Movie movie) {
        MovieItems.add(movie);
        System.out.println("Movie added: " + movie.getName());
    }
/**
 * to remove the movie from the movie collection
 * @param itemID holds the movie that`s going to be removed
 */
    public boolean removeMovie(int itemID) {
        for (Movie m : MovieItems) {
            if (m.getItemID() == itemID) {
                MovieItems.remove(m);
                System.out.println("Movie removed: " + m.getName());
                return true;
            }
        }
        System.out.println("Movie not found!");
        return false;
    }
/**
 * @return printing details
 */ 
    @Override
    public String toString() {
        return "MovieItems{" + "Name=" + Name + ", ItemID=" + ItemID + ", price=" + price + '}';
    }
}
