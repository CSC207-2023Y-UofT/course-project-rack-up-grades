import java.util.ArrayList;

interface DataAccessInterface {
    static String fileName = null;
    public ArrayList<String> read();
    public void write(ArrayList<String> data);
}