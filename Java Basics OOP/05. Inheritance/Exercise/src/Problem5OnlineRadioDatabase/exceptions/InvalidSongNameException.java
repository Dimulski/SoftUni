package Problem5OnlineRadioDatabase.exceptions;

public class InvalidSongNameException extends InvalidSongException {

    private static final String DEFAULT_MESSAGE = "Song name should be between 3 and 30 symbols.";

    public InvalidSongNameException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidSongNameException(String message) {
        super(message);
    }
}
