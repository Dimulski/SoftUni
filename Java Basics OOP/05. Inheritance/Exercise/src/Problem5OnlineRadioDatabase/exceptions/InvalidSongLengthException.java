package Problem5OnlineRadioDatabase.exceptions;

public class InvalidSongLengthException extends InvalidSongException {

    private static final String DEFAULT_MESSAGE = "Invalid song length.";

    public InvalidSongLengthException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidSongLengthException(String message) {
        super(message);
    }
}
