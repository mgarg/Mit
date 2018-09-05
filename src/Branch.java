import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Branch {
    String name;
    Commit head;
    // where the name of the first commit is stored
    String fileName;
//    List<Commit> commits;

    public Branch(String name) throws IOException {
        this.name = name;
        // for now, we are keeping the name and filename as same
        fileName = "/Users/mahak/work/aosa/Mit/src/" + name;
        File file = new File(fileName);
        file.createNewFile();
        populateBranch();
    }

    void populateBranch() throws IOException{
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        Commit tail = null;
        while (line != null && !line.equals("null")) {
            if(head == null) {
                tail = head = new Commit(line);
            } else {
                FileReader fileReader1 = new FileReader(tail.fileName);
                BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
                line = bufferedReader1.readLine();
                if(!line.equals("null")) {
                    tail.next = new Commit(line);
                }
                tail = tail.next;
                bufferedReader1.close();
            }
        }
        bufferedReader.close();
    }

    void log() throws IOException{
        Commit commit = head;
        while (commit != null) {
            System.out.println(commit);
            commit = commit.next;
        }
    }

    void commit(String name) throws IOException{
        head = new Commit(name, head);
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(name);
        bufferedWriter.close();
    }
}
