import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

interface DataAccessInterface {
    static String fileName = null;
    public ArrayList<String> read() throws IOException;
    public void write(ArrayList<String> data) throws IOException;
}