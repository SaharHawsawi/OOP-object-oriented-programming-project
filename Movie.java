package movietheater;
/**
 * this class will have all the information about the movies
 */
public class Movie extends MovieItems implements Bookable {

    private String MovieGenre;
    private boolean available = true;
    
    public Movie() {
    }

    public Movie(String MovieGenre, String Name, Integer ItemID, double price) {
        super(Name, ItemID, price);
        this.MovieGenre = MovieGenre;
        
          this.available = true;
    }
    
    public String getMovieGenre() {
        return MovieGenre;
    }

    public void setMovieGenre(String MovieGenre) {
        this.MovieGenre = MovieGenre;
    }
    
    @Override
    public boolean isAvailable() {
        return available;
    }
    @Override
    public String toString() {
    return super.toString() + ", MovieGenre: " + MovieGenre;
   
}
    @Override
    public boolean bookItem() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean cancelBooking() {
        available = true;
        return true;
    }
}