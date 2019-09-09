public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }
    /**
     * Returns a string that can be input into the txt file.
     * This method transforms the task into the specific format for the txt file
     * @return the data for this task
     */    @Override
    public String toString() {
        return "T"+ "|" + super.getStatusIcon() + "| " + super.description;
    }
    public String listformat(){
        return "[T]" + "[" + super.getStatusIcon() + "]" + super.description ;
    }
}