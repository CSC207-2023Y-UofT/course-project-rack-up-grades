import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class DataAccess implements DataAccessInterface {
    private static String fileName;

    DataAccess(String name) {
        this.fileName = name;
    }

    @Override
    public ArrayList<String> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
        String line = reader.readLine();
        ArrayList<String> scores =  new ArrayList<String>();
        while (line != null) {
            scores.add(line);
            line = reader.readLine();
        }
        return scores;
    }

    @Override
    public void write(String a) {

    }

}