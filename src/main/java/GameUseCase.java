import java.util.*;
import java.io.*;
// ScheduleExecutionTime

public class GameUseCase {

    // use case classes will get point from Entity class directly
    private String name;
    private int score;
    private String difficulty;
    private int timeGame;
    private int timeBetweenObjects;
    private GameEntity gameEntity;

    private int location;

    public void setName(String name){
        this.name = name;
    }

    public void increaseScore(int increment){
        this.score += increment;
    }

    public void decreaseScore(int decrement){
        this.score -= decrement;
    }

    // If user wants to add to leaderboard, passes user’s name and score through DataAccessInterface
    // call read, do sorting to figure out the right place to put the data in
    public void addToLeaderBoard(){
        DataAccessInterface.addToLeaderBoard(this.name, this.score);
    }

    // leaderboard will only store top 10 scores
    // read data on leaderboard and store
    public ArrayList<String[]> read(){
        ArrayList<String> data = DataAccessInterface.read();
        ArrayList<String[]> refinedData = new ArrayList<>();

        for (String s : data) {
            String[] temp = s.split(",");
            refinedData.add(temp);
        }
        return refinedData;
        // data          ArrayList<String>       EXAMPLE:  ["Cathy,90,e", "Ivy,80,m"]
        // refinedData   ArrayList<String[]>     EXAMPLE:  [["Cathy", "90", "m"], ["Ivy", "80", "e"]]
    }

    // if data makes it in the top 10, add it where appropriate
    // if data doesn't make it in the top 10, do nothing

    public void write(){
        ArrayList<String> topTen = DataAccessInterface.read();

        // at the time of launch of this game, leaderboard is empty, so just add until the list is 10
        if (topTen.size() == 0) {

            DataAccessInterface.write(this.name, this.score, this.difficulty);
        }

        // leaderboard has one or more data
        for (int i=0; i<topTen.size(); i++) {

        }
    }

    public


    // give current time
    public void giveCurrentTime(){

    }

    // Initialize data access --> What does this mean?

    // Initializes the game
    public void setGame(){

    }

    public String toString(){
        return String.valueOf(gameEntity) + String.valueOf(location);
    }

    //
    // toString sends current position to presenter
    //
}
