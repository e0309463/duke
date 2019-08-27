import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static class DukeException extends Exception {
        public DukeException(String errorMessage){
            super(errorMessage);
        }
    }

        protected String type;
        protected String datetime;

    public static void main(String[] args) throws IOException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Task> list = new ArrayList<Task>();
        boolean flag = true;
        while(flag) {
                String name = reader.readLine();
                Task t = new Task(name);
                if (name.equals("bye")) {
                    flag = false;
                    System.out.println("Bye! Hope to see you again soon!");
                } else if (name.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < list.size(); i++) {
                            System.out.println(i + 1 + ".[" + list.get(i).getStatusIcon()+"] " + list.get(i).description);
                    }
                } else if (name.startsWith("done")) {
                    int numbercheck = Integer.parseInt(name.substring(5)) - 1;
                    list.get(numbercheck).isDone = true;
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println("[" + list.get(numbercheck).getStatusIcon() + "] " + list.get(numbercheck).description);
                }
                else {
                    list.add(t);
                    System.out.println("added: "+ name);
                }
        }

    }
}
