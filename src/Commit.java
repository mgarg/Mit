import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Commit {
    String name;
    String fileName;
    Commit next;

    public Commit(String name) throws IOException {
        this.name = name;
        next = null;
        fileName = "/Users/mahak/work/aosa/Mit/src/" + name;
        File file = new File(fileName);
        boolean fileNotExists = file.createNewFile();
        if(fileNotExists) {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("null");
            bufferedWriter.close();
        }
    }

    public Commit(String name, Commit next) throws IOException{
        this.name = name;
        this.next = next;
        fileName = "/Users/mahak/work/aosa/Mit/src/" + name;
        File file = new File(fileName);
        boolean fileNotExists = file.createNewFile();
        if(fileNotExists) {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if(next != null) {
                bufferedWriter.write(next.name);
            } else {
                bufferedWriter.write("null");
            }
            bufferedWriter.close();
        }
    }

    @Override
    public String toString() {
        return name;
//        return "Commit{" +
//                "name='" + name + '\'' +
//                ", date='" + date + '\'' +
//                '}';
    }
}
