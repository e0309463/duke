import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FindCommand extends Command {
    /**
     * find a task from the list and print it out
     * @param list the TaskList to be used
     * @param ui the Ui to be used
     * @param storage the Storage to be used
     * @throws DukeException when the description of the command is empty
     */
    @Override
    public void execute(List<Task> list, Ui ui, Storage storage) throws DukeException {
        if(ui.FullCommand.length() == 5){
            throw new DukeException("OOPS!!! The description of a search cannot be empty.");
        }
        else {
            ArrayList<Task> searchedlist = new ArrayList<Task>();
            for(Task it: list){
                if(it.description.contains(ui.FullCommand.substring(6).trim())) {
                    searchedlist.add(it);
                }
            }
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < searchedlist.size(); i++) {
                System.out.println(i + 1 + "." + searchedlist.get(i).listformat());
            }
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
