import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
public class DataAccess implemenets DataAccessInterface {
    private static String fileName;

    private DataAccess(String name) {
        this.fileName = name;
    }

    @Override
    public ArrayList<String> read() {
        Bufferedreader reader = new BufferedReader(new FileReader("sample.txt"));
        String line = reader.readLine();
        ArrayList<String> scores =  new ArrayList<String>();
        while (line != null) {
            scores.add(line);
            line = reader.readLine();
        }
        return scores;
    }

    @Override
    public void write() {
        FileWriter writer = new FileWriter("sample.txt", true);;
    }

}