import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
public class DataAccess implemenets DataAccessInterface {
    private static String fileName;
    private FileReader reader;
    private FileWriter writer;

    private DataAccess(String name) {
        this.fileName = name;
        this.reader = new FileReader("sample.txt");
        this.writer = new FileWriter("sample.txt", true);
    }

    @Override
    public String read() {
        int i;
        ArrayList<String> data = new ArrayList<String>;
        while ((i = reader.read()) != -1) {

        }
    }

    @Override
    public void write() {

    }

}