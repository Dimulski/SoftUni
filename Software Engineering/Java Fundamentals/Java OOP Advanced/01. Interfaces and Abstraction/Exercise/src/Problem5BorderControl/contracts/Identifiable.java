package Problem5BorderControl.contracts;

public interface Identifiable {

    String getId(); // ID has to be a String, otherwise a test in Judge fails. This should have been clear from the start.
}
