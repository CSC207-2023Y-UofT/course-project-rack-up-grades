package FrameworksAndDrivers;

import ApplicationBusiness.DataAccessInterface;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * DataAccess for our file
 */
public class DataAccess implements DataAccessInterface {
    private static String fileName;

    /**
     * create and instance this class
     * @param name name of the file to read/write from and to
     */
    public DataAccess(String name) {
        this.fileName = name;
    }

    /**
     * Read from the file and process it into something to return
     * @return a ArrayList of strings being everything in the file line by line
     */
    @Override
    public ArrayList<String> read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
            String line = reader.readLine();
            ArrayList<String> scores =  new ArrayList<String>();
            while (line != null) {
                scores.add(line);
                line = reader.readLine();
            }
            return scores;
        } catch (IOException e) {
            System.out.println("File does not exist");
            return null;
        }
    }

    /**
     * Write everything in param to file line by line
     * @param scores a ArrayList of string being everything in the file line by line
     */
    @Override
    public void write(ArrayList<String> scores) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, false));
            for (String score : scores) {
                writer.write(score);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot write to file");
        }
    }
}