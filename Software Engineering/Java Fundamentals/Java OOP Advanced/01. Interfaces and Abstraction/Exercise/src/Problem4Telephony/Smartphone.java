package Problem4Telephony;

class Smartphone implements Callable, WebBrowsable {

    private static final String INVALID_URL_MESSAGE = "Invalid URL!";
    private static final String INVALID_PHONE_NUMBER_MESSAGE = "Invalid number!";
    private static final String CONTAINS_NUMBER_REGEX = ".*\\d+.*";
    private static final String CONTAINS_ONLY_NUMBERS_REGEX = ".*\\d+.*";

    @Override
    public String makeCall(String phoneNumber) {
        if (!phoneNumber.matches(CONTAINS_ONLY_NUMBERS_REGEX)) {
            return INVALID_PHONE_NUMBER_MESSAGE; // Could also just throw an exception with the same message...
        } else {
            return String.format("Calling... %s", phoneNumber);
        }
    }

    @Override
    public String browsWeb(String URL) {
        if (URL.matches(CONTAINS_NUMBER_REGEX)) {
            return INVALID_URL_MESSAGE;
        } else {
            return String.format("Browsing: %s!", URL);
        }
    }
}
