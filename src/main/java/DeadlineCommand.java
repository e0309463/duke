import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DeadlineCommand extends Command
{
    /**
     * Creates new deadline task using a TaskList, Ui and Storage, it will then be added into the taskArrayList that
     * was loaded into the TaskList as param.
     * @param list the TaskList to be used
     * @param ui the Ui to be used
     * @param storage the Storage to be used
     * @throws DukeException
     * @throws ParseException if the date is not able to be parsed
     * @throws IOException
     * @return Void.
     */
    @Override
    public void execute(List<Task> list, Ui ui, Storage storage) throws DukeException, ParseException, IOException, NullPointerException {
        String description = "";
        if(ui.FullCommand.length() == 8) {
            throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
        }
        else{
             description = ui.FullCommand.split("/")[0].substring(9);
        }
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Deadline d = new Deadline(description, fmt.parse(ui.FullCommand.split("/")[1].substring(3)));
        list.add(d);
        System.out.println("Got it. I've added this task:");
        System.out.println(d.listformat());
        System.out.println("Now you have " + list.size() + " tasks in the list.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getClass().getName().equals("Deadline")) {
                sb.append(list.get(i).toString()+"\n");
            }
            else if(list.get(i).getClass().getName().equals("Event")){
                sb.append(list.get(i).toString()+"\n");
            }
            else{
                sb.append(list.get(i).toString()+"\n");
            }
        }
        storage.Storages(sb.toString());
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
