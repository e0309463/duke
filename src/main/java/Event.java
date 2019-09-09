import java.util.Date;

public class Event extends Task {
    protected Date at ;

    public Event(String description, Date at) {
        super(description);
        this.at = at;
    }
    /**
     * Returns a string that represents event that will be input into the txt file.
     * This method transforms the task into the specific format for the txt file
     * @return String containing data for this task
     */
    @Override
    public String toString() {
        return "E"+ "|" + super.getStatusIcon() + "| " + super.description + "|" + "at: "+at;
    }
    /**
     * Returns a string that represents event that is printed as output.
     * @return String for list format for this task
     */
    public String listformat(){
        return "[E]" + "[" + super.getStatusIcon() + "]" + super.description + "(at:" + at + ")";
    }
}


