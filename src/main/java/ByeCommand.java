import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class ByeCommand extends Command {
    @Override
    public void execute(List<Task> list, Ui ui, Storage storage) throws DukeException, ParseException, IOException {
        System.out.println("Bye! Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
