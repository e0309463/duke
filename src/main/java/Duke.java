import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public class DukeException extends Exception {
        public DukeException(String errorMessage){
            super(errorMessage);
        }
    }
    public static class Task {
        protected String description;
        protected boolean isDone;
        protected String type;
        protected String datetime;
        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        }

        //...
    }
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
            if(name.equals("bye")){
                flag = false;
                System.out.println("Bye! Hope to see you again soon!");
            }
            else if (name.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i=0; i<list.size(); i++){
                    if (list.get(i).datetime == null) {
                        System.out.println(i + 1 + ".[" + list.get(i).type + "]" + list.get(i).getStatusIcon() + "] " + list.get(i).description);
                    }
                    else{
                        System.out.println(i + 1 + ".[" + list.get(i).type + "]" + list.get(i).getStatusIcon() + "] " + list.get(i).description +"(" + list.get(i).datetime.substring(0, 2)+":"+ list.get(i).datetime.substring(2) +")");
                    }
                }
            }
            else if (name.startsWith("done")){
                int numbercheck = Integer.parseInt(name.substring(5)) - 1;
                list.get(numbercheck).isDone = true;
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println("[" + list.get(numbercheck).getStatusIcon() + "]" + list.get(numbercheck).description);
            }
            else if (name.startsWith("todo")) {
                t.type = "T";
                list.add(t);
                System.out.println("Got it. I've added this task:");
                t.description = name.substring(5);
                System.out.println("[" + t.type + "]" + "[" + t.getStatusIcon() + "] " + t.description);
                System.out.println("Now you have "+ list.size() +" tasks in the list.");
            }
            else if (name.startsWith("deadline")) {
                t.type = "D";
                t.datetime = name.split("/")[1];
                t.description = name.split("/")[0].substring(9);
                list.add(t);
                System.out.println("Got it. I've added this task:");
                System.out.println("[" + t.type + "]" + "[" + t.getStatusIcon() + "] " + t.description + "(" + t.datetime.substring(0, 2)+":"+t.datetime.substring(2) +")");
                System.out.println("Now you have "+ list.size() +" tasks in the list.");
            }
            else if (name.startsWith("event")) {
                t.type = "E";
                t.datetime = name.split("/")[1];
                t.description = name.split("/")[0].substring(6);
                list.add(t);
                System.out.println("Got it. I've added this task:");
                System.out.println("[" + t.type + "]" + "[" + t.getStatusIcon() + "] " + t.description + "(" + t.datetime.substring(0, 2)+":"+t.datetime.substring(2) +")");
                System.out.println("Now you have "+ list.size() +" tasks in the list.");
            }
            else {
                list.add(t);
                System.out.println("added: "+ name);
            }
        }

    }
}
