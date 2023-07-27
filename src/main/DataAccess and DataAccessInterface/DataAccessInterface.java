import java.util.ArrayList;

interface DataAccessInterface {
    static String fileName = null;
    ArrayList<String> read();
    void write(ArrayList<String> data);
}