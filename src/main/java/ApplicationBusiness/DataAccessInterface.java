package ApplicationBusiness;

import java.util.ArrayList;

/**
 * DataAccess's Interface
 * It includes method that a DataAccess must implement, for the purpose of dependency inversion and CA
 */
public interface DataAccessInterface {
    ArrayList<String> read();
    void write(ArrayList<String> data);
}