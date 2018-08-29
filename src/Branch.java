import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Branch {
    String name;
    // where commits are stored
    String fileName;
    List<Commit> commits;

    public Branch(String name) throws IOException {
        this.name = name;
        // for now, we are keeping the name and filename as same
        fileName = "/Users/mahak/work/aosa/Mit/src/" + name;
        File file = new File(fileName);
        file.createNewFile();
        populateBranch();
    }

    void populateBranch() throws IOException{
        commits = new LinkedList<>();
        // all commits are stored in a file
        // each commit is a single line
        // details of a commit are comma separated values in that line
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] commitProperties = line.split(",");
            String name = commitProperties[0];
            String date = commitProperties[1];
            commits.add(new Commit(name, date));
        }
        bufferedReader.close();
    }

    void log() throws IOException{
        if(commits == null) {
            populateBranch();
        }
        for (Commit commit: commits) {
            System.out.println(commit);
        }
    }

    void commit(String name) throws IOException{
        if(commits == null) {
            populateBranch();
        }
        String date = new Date().toString();
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(name + "," + date + "\n");
        bufferedWriter.close();
        Commit commit = new Commit(name, date);
        commits.add(commit);
    }
}
