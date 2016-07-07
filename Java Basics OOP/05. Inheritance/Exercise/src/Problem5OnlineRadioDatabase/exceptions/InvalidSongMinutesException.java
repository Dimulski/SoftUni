package Problem5OnlineRadioDatabase.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {

    private static final String DEFAULT_MESSAGE = "Song minutes should be between 0 and 14.";

    public InvalidSongMinutesException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
