package duke.DukeException;

/**
 * Handle reply for unknown input given by the user.
 */
public class DukeException extends Exception {
    /**
     * Creates a exception with specified reply message.
     * @param ErrMsg Reply message that will be displayed.
     */
    public DukeException(String ErrMsg) {
        super(ErrMsg);
    }

    /**
     * Returns the reply message as a string.
     * @return String that represent the reply message.
     */
    @Override
    public String toString() {
        return super.getMessage();
    }
}
