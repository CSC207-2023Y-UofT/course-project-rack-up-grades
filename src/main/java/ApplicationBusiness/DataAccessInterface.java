package ApplicationBusiness;

import java.util.ArrayList;

public interface DataAccessInterface {
    ArrayList<String> read();
    void write(ArrayList<String> data);
}