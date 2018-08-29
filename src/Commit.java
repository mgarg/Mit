public class Commit {
    // Add more fields as and when necessary
    String name;
    String date;

    public Commit(String name, String date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
