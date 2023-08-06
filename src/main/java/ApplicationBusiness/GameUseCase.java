package ApplicationBusiness;

import EnterpriseBusiness.GameEntity;
import FrameworksAndDrivers.DataAccess;

import java.util.*;

/**
 * The GameUseCase class is the parent of easy medium hard usecase, it is abstract and has some abstract methods
 */
public abstract class GameUseCase {

    private String name;
    private int score;

    private GameEntity gameEntity;
    private int increment;
    private int decrement;

    private String currPosition;
    private ArrayList<String> preset;


    final String fs = System.getProperty("file.separator");
    final String FILE = System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"JAVA"+fs+ "FrameworksAndDrivers/file.txt";

    private final DataAccessInterface DataAccIn = new DataAccess(FILE);;

    private Integer[] gameTime;

    private String difficulty;
    private InterfaceLeaderboardPresenter LP;
    private GameOutputBoundary GP;

    /**
     * Initialize ApplicationBusiness.GameUseCase
     * @param difficulty a param e, m, and h for easy, medium, and hard, respectively
     * @param LP a leaderboard presenter interface (OutputBoundary)
     * @param GP a game presenter interface (OutputBoundary)
     *
     */
    public GameUseCase(String difficulty, InterfaceLeaderboardPresenter LP, GameOutputBoundary GP) {
        this.difficulty = difficulty;
        this.LP = LP;
        this.GP = GP;
        this.name = "";
        this.score = 0;
        this.gameEntity = new GameEntity(difficulty);
        this.increment = this.gameEntity.getIncrement();
        this.decrement = this.gameEntity.getDecrement();
        this.preset = new ArrayList<>();
        this.gameTime = new Integer[1];
    }

    /**
     * This genPreset method creates a preset depending on gamemode. Can be combined with the code above
     * @return an arraylist of strings that will show up as moles when the game runs
     */
    public abstract ArrayList<String> genPreset();

    /**
     * Set the name as the name given through assignment
     * @param name: string
     */
    public void setName(String name){
        this.name = name;
    }


    /*
    - leaderboard will only store top 10 scores
    - read data on leaderboard, modify appropriately, send it back to store

    [Clarifications on variables used in this method]
    data          ArrayList<String>       EXAMPLE:  ["Cathy,90,e", "Ivy,80,m"]
    refinedData   ArrayList<String[]>     EXAMPLE:  [["Cathy", "90", "m"], ["Ivy", "80", "e"]]
    dataToReturn  ArrayList<String>       EXAMPLE:  ["Cathy,90,e", "Ivy,80,m"]
     */
//    public void addToLeaderboard(){
//        ArrayList<String> data = this.DataAccIn.read();
//        ArrayList<String[]> refinedData = new ArrayList<>();
//        ArrayList<String> dataToReturn = this.DataAccIn.read();
//
//        if (!this.name.equals("")) {
//
//
//            // Load refinedData (original element: strings, new element: lists of strings)
//            for (String s : data) {
//                String[] temp = s.split(",");
//                refinedData.add(temp);
//            }
//
////        // Remove possible commas in the name
////        this.name = this.name.replaceAll(",", "");
////
////        // Cut the name to 8 letters if longer
////        if (this.name.length() > 8){
////            this.name = this.name.substring(0, 7);
////        }
//
//            // If there is no data and so the leaderboard is empty, just add the data
//            if (refinedData.size() == 0) {
//                dataToReturn.add(this.name + "," + this.score + "," + this.difficulty);
//            }
//
//            // Leaderboard has one or more data
//            else {
//                for (int i = 0; i < refinedData.size(); i++) {
//                    if (this.score > Integer.parseInt(refinedData.get(i)[1])) {
//                        dataToReturn.add(i, this.name + "," + this.score + "," + this.difficulty);
//                        break;
//                    }
//                }
//            }
//
//            // If the finalized list for leaderboard is longer than 10, remove the last line
//            if (dataToReturn.size() > 10) {
//                dataToReturn.remove(dataToReturn.size() - 1);
//            }
//
//            this.DataAccIn.write(dataToReturn);
//        }
//    }

    /**
     * Add to leaderboard, it will read the data from the file using DataAccess read() through the interface
     * which is an ArrayList of string being per line of file.txt
     * it will process and add the new name, score, difficulty to the ArrayList and remove the 10th+ person if it exists
     * then write that to the file using DataAccess write() through the interface
     */
    public void addToLeaderboard() {
        ArrayList<String> data = this.DataAccIn.read();
        ArrayList<Integer> mod = new ArrayList<>();
        ArrayList<String> r = new ArrayList<>();

        if (!this.name.equals("")) {
            for (String s : data) {
                String[] temp = s.split(",");
                mod.add(Integer.parseInt(temp[1]));
            }

            this.name = this.name.replaceAll(",", "");

            // Cut the name to 8 letters if longer
            if (this.name.length() >= 8){
                this.name = this.name.substring(0, 7);
            }

            data.add(this.name + "," + this.score + "," + this.difficulty);

            class dataComparator implements Comparator<String> {
                public int compare(String e1, String e2) {
                    if (Integer.parseInt(e1.split(",")[1]) < Integer.parseInt(e2.split(",")[1])) {
                        return 1;
                    }
                    else if (Integer.parseInt(e1.split(",")[1]) > Integer.parseInt(e2.split(",")[1])) {
                        return -1;
                    }
                    else {
                        return 0;
                    }

                }
            }
            Collections.sort(data , new dataComparator());

            if (data.size() > 10) {
                data.remove(data.size() - 1);
            }

            this.DataAccIn.write(data);
        }
    }

    /**
     * abstract run() method
     */
    // Initializes the game
    public abstract void run();

    /**
     * abstract click() method
     * @param i
     */
    public abstract void click(Integer i);


    /**
     * set the data on the leaderboard presenter through the interface
     */
    public void setData() {
        this.LP.setData(this.DataAccIn.read());
    }

}

