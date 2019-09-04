import java.io.*;
import java.text.ParseException;
import java.util.List;

public class Duke {
    public static void main(String[] args) {

        List<Task> list;
        Storage store = new Storage();
        boolean isExit = false;
        Ui ui = new Ui();
        ui.showWelcome();
        try {
            list = store.Readfile();
            while(!isExit) {
                String command = ui.ReadCommand().split(" ")[0];
                //Task t = new Task(name);
                Command c = Parser.parse(command);
                c.execute(list,ui, store);

                isExit = c.isExit();
            }
        }
        catch (DukeException | ParseException | IOException e){
            if(e instanceof ParseException){
                ui.showDateFormatError();
            }
            else {
                ui.showErrorMessage(e);
            }
        }
//        finally{
//            System.out.println("");
//        }
    }
}