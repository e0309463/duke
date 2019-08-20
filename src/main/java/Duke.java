import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) throws IOException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List list = new ArrayList();
        boolean flag = true;
        while(flag) {
            String name = reader.readLine();
            if(name.equals("bye")){
                flag = false;
                System.out.println("Bye! Hope to see you again soon!");
            }
            else if (name.equals("list")){
                for(int i=0; i<list.size(); i++){
                    System.out.println(i+1 +". " + list.get(i).toString());
                }
            }
            else {
                list.add(name);
                System.out.println("added: "+ name);
            }
        }

    }
}
