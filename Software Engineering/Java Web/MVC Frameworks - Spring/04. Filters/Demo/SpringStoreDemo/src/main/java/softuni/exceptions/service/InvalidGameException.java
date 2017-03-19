package softuni.exceptions.service;

public class InvalidGameException extends IllegalArgumentException {

    /**
     * Constructs an <code>IllegalArgumentException</code> with no
     * detail message.
     */
    public InvalidGameException() {
    }

    /**
     * Constructs an <code>IllegalArgumentException</code> with the
     * specified detail message.
     *
     * @param s the detail message.
     */
    public InvalidGameException(String s) {
        super(s);
    }
}
