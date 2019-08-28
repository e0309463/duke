import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    //protected String by;
    protected Date by ;
    //= fmt.parse("2013-05-06");

    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "D"+ "|" + super.getStatusIcon() + "| " + super.description + "|" + "by: " + by;
    }
}
