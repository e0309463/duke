import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    String directory = System.getProperty("user.home");
    String fileName = "sample.txt";
    String absolutePath = directory + File.separator + fileName;
    protected void Storages(String fileContent) throws IOException{

        FileWriter fileWriter = new FileWriter(absolutePath);
        fileWriter.write(fileContent);
        fileWriter.flush();
        fileWriter.close();

    }

    protected ArrayList<Task> Readfile() throws IOException{
        ArrayList<Task> tlist = new ArrayList<Task>();
        if(new File(absolutePath).exists()) {
            File file = new File(absolutePath);
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String[] details = sc.nextLine().split("\\|");
                if (details[0].equals("T")) {
                    Todo t = new Todo(details[2].trim());
                    tlist.add(t);
                } else if (details[0].equals("D")) {
                    Deadline d = new Deadline(details[2].trim(), details[3].trim());
                    tlist.add(d);
                } else {
                    Event e = new Event(details[2].trim(), details[3].trim());
                    tlist.add(e);
                }
            }
        }
        return tlist;
    }
}
