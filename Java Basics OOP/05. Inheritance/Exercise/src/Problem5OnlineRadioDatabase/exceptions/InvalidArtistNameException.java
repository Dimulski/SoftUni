package Problem5OnlineRadioDatabase.exceptions;

public class InvalidArtistNameException extends InvalidSongException {

    private static final String DEFAULT_MESSAGE = "Artist name should be between 3 and 20 symbols.";

    public InvalidArtistNameException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidArtistNameException(String message) {
        super(message);
    }
}
