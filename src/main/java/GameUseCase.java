import java.util.*;
import java.io.*;
// ScheduleExecutionTime

public class GameUseCase {

    // use case classes will get point from Entity class directly
    private String name;
    private int score;
    private String difficulty;
    private int timeGame;

    //private GameEntity gameEntity;

    private String currPosition;
    private ArrayList<String> preset;

    //private GameEntity gameEntity;
    //private DataAccessInterface DataAccIn;
    private ArrayList<String> presetGame;


    private int location;


    public GameUseCase(String difficulty) {
        this.name = "";
        this.score = 0;
        this.difficulty = difficulty;
        //this.DataAccIn = new DataAccess();
        //this.gameEntity = new GameEntity(difficulty);


        this.preset = new ArrayList<>();
        this.preset.add("2P");
        this.preset.add("3P");
        this.preset.add("4P");


        run();
    }



    public void setName(String name){
        this.name = name;
    }

    public void increaseScore(int increment){
        this.score += increment;
    }

    public void decreaseScore(int decrement){
        this.score -= decrement;
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


    // give current time
    public void giveCurrentTime(){

    }

    // Initialize data access --> What does this mean?

    // Initializes the game
    public void run(){
        java.util.Timer T = new java.util.Timer();
        TimerTask TT = new TimerTask() {

            @Override
            public void run() {

                if (!preset.isEmpty()) {
                    currPosition = preset.remove(0);
                    System.out.println(currPosition);
                }
                else {
                    System.out.println("Game Over");
                    T.cancel();
                }
            }
        };
        T.scheduleAtFixedRate(TT, 3000, 1000);
    }

    public void click(Integer i){}

    public String toString(){
        return currPosition;
    }

    //
    // toString sends current position to presenter
    //

    public static void main(String[] args){
        GameUseCase test = new GameUseCase();


    }
}
