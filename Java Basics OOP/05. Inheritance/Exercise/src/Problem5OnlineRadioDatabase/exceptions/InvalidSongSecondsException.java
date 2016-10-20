package Problem5OnlineRadioDatabase.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {

    private static final String DEFAULT_MESSAGE = "Song seconds should be between 0 and 59.";

    public InvalidSongSecondsException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
