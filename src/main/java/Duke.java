import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Duke {
    public static void main(String[] args) throws IOException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag) {
            String name = reader.readLine();
            if(name.equals("bye")){
                flag = false;
                System.out.println("Bye! Hope to see you again soon!");
            }
            else {
                System.out.println(name);
            }
        }

    }
}
