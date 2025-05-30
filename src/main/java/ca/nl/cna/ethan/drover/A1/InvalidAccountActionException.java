package ca.nl.cna.ethan.drover.A1;

public class InvalidAccountActionException extends Exception {

    private static final String MSG = "The action attempted is not valid!";

    public InvalidAccountActionException() {
        super(MSG);
    }

    public InvalidAccountActionException(String message) {
        super(message);
    }

    public InvalidAccountActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAccountActionException(Throwable cause) {
        super(MSG, cause);
    }
}