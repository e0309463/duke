import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Task> list;
        Storage store = new Storage();
        boolean flag = true;
        try {
            list = store.Readfile();
            while(flag) {
                String name = reader.readLine();
                Task t = new Task(name);
                if (name.equals("bye")) {
                    flag = false;
                    System.out.println("Bye! Hope to see you again soon!");
                }
                else if (name.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + 1 + "." + list.get(i).toString());
                    }
                }
                else if (name.startsWith("done")) {
                    if (name.equals("done")){
                        throw new DukeException("The task done number cannot be empty.");
                    }
                    int numbercheck = Integer.parseInt(name.substring(5)) - 1;
                    list.get(numbercheck).isDone = true;

                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println("[" + list.get(numbercheck).getStatusIcon() + "]" + list.get(numbercheck).description);
                }
                else if (name.startsWith("todo")) {
                    if(name.length() <= 4) {
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                    }
                    else{
                        t.description = name.substring(5);
                    }
                    Todo to = new Todo(t.description);
                    list.add(to);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(to.toString());
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                }
                else if (name.startsWith("deadline")) {
                    if(name.length() == 8) {
                        throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
                    }
                    else{
                        t.description = name.split("/")[0].substring(9);
                    }
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Deadline d = new Deadline(t.description, fmt.parse(name.split("/")[1].substring(3)));
                    list.add(d);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(d.toString());
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                }
                else if (name.startsWith("event")) {
                    if(name.length() == 5) {
                        throw new DukeException("OOPS!!! The description of an event cannot be empty.");
                    }
                    else{
                        t.description = name.split("/")[0].substring(6);
                    }
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Event ev = new Event(t.description, fmt.parse(name.split("/")[1].substring(3)));
                    list.add(ev);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(ev.toString());
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                }
                else if (name.startsWith("delete")) {
                    if(name.length() == 6) {
                        throw new DukeException("OOPS!!! The description of a deletion cannot be empty.");
                    }
                    else {
                        int index = Integer.parseInt(name.substring(6).trim()) - 1;
                        String taskremoved = list.get(index).toString();
                        list.remove(index);
                        System.out.println("Noted. I've removed this task: ");
                        System.out.println(taskremoved);
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
                    }
                }
                else if (name.startsWith("find")) {
                    if(name.length() == 5){
                        throw new DukeException("OOPS!!! The description of a search cannot be empty.");
                    }
                    else {
                        ArrayList<Task> searchedlist = new ArrayList<Task>();
                        for(Task it: list){
                            if(it.description.contains(name.substring(6).trim())) {
                                searchedlist.add(it);
                            }
                        }
                        System.out.println("Here are the matching tasks in your list:");
                        for (int i = 0; i < searchedlist.size(); i++) {
                            System.out.println(i + 1 + "." + searchedlist.get(i).toString());
                        }
                    }
                }
                else {
                    throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
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
                store.Storages(sb.toString());
            }
        }
        catch (DukeException | ParseException | IOException e){
            if(e instanceof ParseException){
                System.err.println("Date Time has to be in YYYY-MM-DD HH:mm:ss format");
            }
            else {
                System.err.println(e.getMessage());
            }
        }
//        finally{
//            System.out.println("Program exiting due to error");
//        }
    }
}