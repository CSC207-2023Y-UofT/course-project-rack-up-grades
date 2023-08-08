package ApplicationBusiness;

import EnterpriseBusiness.GameEntity;
import FrameworksAndDrivers.DataAccess;

import java.util.*;

public class HardUseCase extends GameUseCase {

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
    private java.util.Timer T;

    /**
     * Initialize ApplicationBusiness.GameUseCase
     * @param difficulty a param e, m, and h for easy, medium, and hard, respectively
     */
    public HardUseCase(String difficulty, InterfaceLeaderboardPresenter LP, GameOutputBoundary GP) {
        super(difficulty, LP, GP);
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
    @Override
    public ArrayList<String> genPreset(){
        ArrayList<String> preset = new ArrayList<>();
        Random r = new Random();

        for (int i=0; i<60; i++){
            int position = r.nextInt(4);
            int type = r.nextInt(5);
            if (type == 0){
                preset.add((position+1) + "N");
            } else {
                preset.add((position+1) + "P");
            }
        }
        return preset;
    }

    /**
     * run the game using TimerTask scheduled at fixed rate
     */
    // Initializes the game
    public void run(){
        preset = genPreset();
        preset.add(preset.get(preset.size()-1));
        gameTime = new Integer[]{61};
        score = 0;

        T = new java.util.Timer();
        TimerTask TT = new TimerTask() {

            @Override
            public void run() {

                if (!preset.isEmpty()) {
                    if (score<0){
                        score = 0;
                    }

                    currPosition = preset.remove(0);
//                    System.out.println(currPosition);

                    // prints out the time left (60, 59, 58, ..., 1, Game Over)
//                    System.out.println(gameTime[0]);
                    gameTime[0]--;
                    GP.updateGame(currPosition, gameTime[0], score);

                    if (currPosition.charAt(1) == 'P'){
                        score -= increment;
                    }
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

    /**
     * process a click, if position is correct and is positive object add point
     * if position is correct and is negative object subtract point
     * @param i
     */
    public void click(Integer i){
        // Throws error if currPosition is nothing yet, temporary throws the program doesn't crash
        if (i==Integer.parseInt(this.currPosition.substring(0, 1)) && currPosition.charAt(1)=='P') {
            System.out.println("Clicked " + this.currPosition + " +" + this.increment);
            score+=increment;
            score+=increment;
        }
        else if (i==Integer.parseInt(this.currPosition.substring(0, 1)) && currPosition.charAt(1)=='N') {
            System.out.println("Bomb! " + this.currPosition + " -" + this.decrement);
            score-=decrement;
        }
    }

    /**
     * to stop the timer if needed
     */
    public void stop(){
        this.T.cancel();
    }
}
