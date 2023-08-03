import java.util.ArrayList;

interface DataAccessInterface {
    ArrayList<String> read();
    void write(ArrayList<String> data);
}