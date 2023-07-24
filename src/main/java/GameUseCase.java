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

    public GameUseCase() {
        this.name = "";
        this.score = 0;
        //this.DataAccIn = new DataAccess();
        //this.gameEntity = new GameEntity(difficulty);

        this.preset = new ArrayList<>();
        this.preset.add("2P");
        this.preset.add("3P");
        this.preset.add("4P");

        run();
    }

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

    public void increaseScore(int increment){
        this.score += increment;
    }

    public void decreaseScore(int decrement){
        this.score -= decrement;
    }

    public String setName(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter username");
        this.name = s.nextLine();
        return this.name;
    }

    /*
    leaderboard will only store top 10 scores
    read data on leaderboard and store
    // data          ArrayList<String>       EXAMPLE:  ["Cathy,90,e", "Ivy,80,m"]
    // refinedData   ArrayList<String[]>     EXAMPLE:  [["Cathy", "90", "m"], ["Ivy", "80", "e"]]
     */
    public void addToLeaderboard(){
        ArrayList<String> data = DataAccessInterface.read();
        ArrayList<String[]> refinedData = new ArrayList<>();
        ArrayList<String> dataToReturn = null;

        // load refinedData (original element: strings, new element: lists of strings)
        for (String s : data) {
            String[] temp = s.split(",");
            refinedData.add(temp);
        }

        // at the time of launch of this game, leaderboard is empty, so just add until the list is 10
        if (refinedData.size() == 0) {
            dataToReturn.add(this.name + "," + this.score + "," + this.difficulty);
        }

        // leaderboard has one or more data
        else {
            for (int i=refinedData.size(); i>0; i--) {
                if (this.score < Integer.parseInt(refinedData.get(i)[1])) {
                    dataToReturn.add(i+1, this.name + "," + this.score + "," + this.difficulty);
                }
            }
        }
        DataAccessInterface.write(dataToReturn);
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
