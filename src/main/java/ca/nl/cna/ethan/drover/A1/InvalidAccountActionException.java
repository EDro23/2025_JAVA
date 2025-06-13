package ca.nl.cna.ethan.drover.A1;

/**
 * Invalid account action exception class for custom exceptions
 */
public class InvalidAccountActionException extends Exception {
    /**
     * Default string message
     */
    private static final String MSG = "The action attempted is not valid!";

    /**
     * Invalid account with the MSG passed into the super
     */
    public InvalidAccountActionException() {
        super(MSG);
    }

    /**
     * String for the message being sent
     * @param message message that should be sent for the error
     */
    public InvalidAccountActionException(String message) {
        super(message);
    }

    /**
     * String message and throwable cause
     * @param message Message for the error
     * @param cause Cause of the error
     */
    public InvalidAccountActionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Super with the MSG and cause passed in
     * @param cause cause of the error
     */
    public InvalidAccountActionException(Throwable cause) {
        super(MSG, cause);
    }
}