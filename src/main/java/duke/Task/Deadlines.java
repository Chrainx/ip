package duke.Task;

import duke.DukeException.DukeException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents task belong to deadline.
 */
public class Deadlines extends Task {
    /**
     * Deadline of the task.
     */
    private LocalDate ddl;

    /**
     * Creates the deadline task.
     * @param name Description of the task.
     * @param ddl Deadline of the task.
     */
    public Deadlines (String name, String ddl) throws DukeException {
        super(name);
        try {
            this.ddl = LocalDate.parse(ddl);
        } catch (DateTimeParseException e) {
            throw new DukeException(" OOPS!!! Invalid date format. Please type dates in the format yyyy-mm-dd");
        }
    }

    /**
     * Creates the string to be saved in storage.
     * @return String that will be saved in storage.
     */
    @Override
    public String writeString() {
        if (this.getMarkStatus()) {
            return "D,0" + this.getName() + "," + this.ddl + "\n";
        } else {
            return "D,1," + this.getName() + "," + this.ddl + "\n";
        }
    }

    /**
     * Converts the task to a string.
     * @return String that represent the deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: "+ this.ddl.format(DateTimeFormatter.ofPattern("MMM d yyyy")) +")";
    }

    /**
     * Checks whether the input is a valid deadline.
     * @param input Task that will be checked.
     * @return Boolean that represent whether the input is a deadline.
     * @throws DukeException Exception where the deadline is not valid.
     */
    public static boolean isDeadline(String input) throws DukeException {
        System.out.println(input.split("/by").length);
        if (input.split(" ")[0].equals("deadline")) {
            if (!input.contains("/by")) {
                throw new DukeException("OOPS! The description of deadline does not contain /by.");
            } else if (input.split("/by").length == 1){
                throw new DukeException("OOPS! The description of /by cannot be empty.");
            } else if (input.split("/by")[0].length() <= 10){
                throw new DukeException("OOPS! The description of deadline cannot be empty.");
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}