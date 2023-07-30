import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Random;

public class GameUseCase {

    private String name;
    private int score;
    private String difficulty;

    private GameEntity gameEntity;
    private int increment;
    private int decrement;

    private String currPosition;
    private ArrayList<String> preset;

    private final DataAccessInterface DataAccIn;

    final int[] gameTime = {60};

    private InterfaceLeaderboardPresenter LP;
    private GameOutputBoundary GP;
    final String fs = System.getProperty("file.separator");
    final String FILE = System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"JAVA"+fs+"file.txt";

    /**
     * Initialize GameUseCase
     * @param difficulty a param e, m, and h for easy, medium, and hard, respectively
     */
    public GameUseCase(String difficulty, InterfaceLeaderboardPresenter LP, GameOutputBoundary GP) {
        this.name = "";
        this.score = 0;
        this.difficulty = difficulty;
        this.DataAccIn = new DataAccess(FILE);
        this.gameEntity = new GameEntity(difficulty);
        this.increment = this.gameEntity.getIncrement();
        this.decrement = this.gameEntity.getDecrement();
        this.preset = genPreset(difficulty);
        this.LP = LP;
        this.GP = GP;

        // this.run();
    }

    /**
     * This genPreset method creates a preset depending on gamemode. Can be combined with the code above
     * @param difficulty: a string that represents difficulty
     * @return an arraylist of strings that will show up as moles when the game runs
     */
    public ArrayList<String> genPreset(String difficulty){
        ArrayList<String> preset = new ArrayList<>();
        Random r = new Random();

        if (difficulty.equals("e") || difficulty.equals("m")) {
            for (int i=0; i<60; i++) {
                int rand = r.nextInt(4)+1;
                preset.add(rand + "P");
            }
        }

        // hard mode
        else {
            for (int i=0; i<60; i++){
                int position = r.nextInt(4);
                int type = r.nextInt(2);
                if (type == 0){
                    preset.add((position+1) + "P");
                } else {
                    preset.add((position+1) + "N");
                }
            }
        }
        return preset;
    }

    /**
     * Set the name as the name given through assignment
     * @param name: string
     */
    public void setName(String name){
        this.name = name;
    }

    public void increaseScore(int increment){
        this.score += this.increment;
    }

    public void decreaseScore(int decrement){
        this.score -= this.decrement;
    }

    /*
    - leaderboard will only store top 10 scores
    - read data on leaderboard, modify appropriately, send it back to store

    [Clarifications on variables used in this method]
    data          ArrayList<String>       EXAMPLE:  ["Cathy,90,e", "Ivy,80,m"]
    refinedData   ArrayList<String[]>     EXAMPLE:  [["Cathy", "90", "m"], ["Ivy", "80", "e"]]
    dataToReturn  ArrayList<String>       EXAMPLE:  ["Cathy,90,e", "Ivy,80,m"]
     */
    public void addToLeaderboard(){
        ArrayList<String> data = this.DataAccIn.read();
        ArrayList<String[]> refinedData = new ArrayList<>();
        ArrayList<String> dataToReturn = this.DataAccIn.read();

        // Load refinedData (original element: strings, new element: lists of strings)
        for (String s : data) {
            String[] temp = s.split(",");
            refinedData.add(temp);
        }

        // Remove possible commas in the name
        this.name = this.name.replaceAll(",", "");

        // Cut the name to 8 letters if longer
        if (this.name.length() > 8){
            this.name = this.name.substring(0, 7);
        }

        // If there is no data and so the leaderboard is empty, just add the data
        if (refinedData.size() == 0) {
            dataToReturn.add(this.name + "," + this.score + "," + this.difficulty);
        }

        // Leaderboard has one or more data
        else {
            for (int i=0; i<refinedData.size(); i++) {
                if (this.score > Integer.parseInt(refinedData.get(i)[1])) {
                    dataToReturn.add(i, this.name + "," + this.score + "," + this.difficulty);
                    break;
                }
            }
        }

        // If the finalized list for leaderboard is longer than 10, remove the last line
        if (dataToReturn.size() > 10) {
            dataToReturn.remove(dataToReturn.size()-1);
        }

        this.DataAccIn.write(dataToReturn);
    }


    // give current time
    public int giveCurrentTime(){
        return this.gameTime[0];
    }

    // Initializes the game
    public void run(){
        java.util.Timer T = new java.util.Timer();
        TimerTask TT = new TimerTask() {

            @Override
            public void run() {

                if (!preset.isEmpty()) {
                    currPosition = preset.remove(0);
//                    System.out.println(currPosition);

                    // prints out the time left (60, 59, 58, ..., 1, Game Over)
//                    System.out.println(gameTime[0]);
                    gameTime[0]--;
                    GP.updateGame(currPosition, gameTime[0], score);
                }
                else {
                    System.out.println("You Scored: " + score);
                    System.out.println("Game Over");
                    T.cancel();
                }
            }
        };
        T.scheduleAtFixedRate(TT, 3000, 1000);
    }

    public void click(Integer i){
        // Throws error if currPosition is nothing yet, temporary throws the program doesn't crash
        if (i==Integer.parseInt(this.currPosition.substring(0, 1))) {
            System.out.println("Clicked " + this.currPosition + " +" + this.increment);
            this.increaseScore(this.increment);
        }
    }

    public String toString(){
        return currPosition;
    }

    // toString sends current position to presenter

    public void setData() {
        this.LP.setData(DataAccIn.read());
    }

}
