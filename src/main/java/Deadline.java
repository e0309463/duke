import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected Date by ;

    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }
    /**
     * Returns a string that represents deadline that can be input into the txt file.
     * This method transforms the task into the specific format for the txt file
     * @return String containing data for this task
     */
    @Override
    public String toString() {
        return "D"+ "|" + super.getStatusIcon() + "| " + super.description + "|" + "by: " + by;
    }
    /**
     * Returns a string that represents deadline that is printed as output.
     * @return String for list format for this task
     */
    @Override
    public String listformat(){
        return "[D]" + "[" + super.getStatusIcon() + "]" + super.description + "(by:" + by + ")";
    }
}
