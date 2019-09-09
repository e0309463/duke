import java.text.ParseException;
import java.util.List;

public class ListCommand extends Command {
    /**
     * list all the task in the list
     * @param list the TaskList to be used
     * @param ui the Ui to be used
     * @param storage the Storage to be used
     */
    @Override
    public void execute(List<Task> list, Ui ui, Storage storage) throws DukeException, ParseException {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + "." + list.get(i).listformat());
        }
    }
    /**
     * Returns boolean true to exit the program.
     * @return boolean.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
