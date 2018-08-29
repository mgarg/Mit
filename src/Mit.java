import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mit {

    public static void main(String[] args) throws IOException {
        Branch branch = null;
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String tokens[] = br.readLine().split(" ");
            switch (tokens[0]) {
                case "log": {
                    if (branch == null) {
                        return;
                    }
                    branch.log();
                    break;
                }
                case "checkout": {
                    branch = new Branch(tokens[1]);
                    break;
                }
                case "commit": {
                    if (branch == null) {
                        return;
                    }
                    branch.commit(tokens[1]);
                    break;
                }
                case ":q": {
                    return;
                }
            }
        }
    }
}
