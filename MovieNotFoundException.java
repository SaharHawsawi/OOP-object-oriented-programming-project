package movietheater;
/* Custom exception thrown when a movie item is not found in the catalog.
 */
public class MovieNotFoundException extends Exception {

    /**
     * Creates the exception with a message.
     *
     * @param message explanation message
     */
    public MovieNotFoundException(String message) {
        super(message);
    }
}

