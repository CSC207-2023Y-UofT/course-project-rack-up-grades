package ApplicationBusiness;

import EnterpriseBusiness.GameEntity;

import java.util.*;

public class MediumUseCase extends GameUseCase {

    private int score;

    private GameEntity gameEntity;
    private int increment;
    private int decrement;

    private String currPosition;
    private ArrayList<String> preset;

    private Integer[] gameTime;

    private String difficulty;
    private GameOutputBoundary GP;
    private java.util.Timer T;


    /**
     * Initialize ApplicationBusiness.GameUseCase
     *
     * @param difficulty a param e, m, and h for easy, medium, and hard, respectively
     * @param GP
     */
    public MediumUseCase(String difficulty, GameOutputBoundary GP) {
        super(difficulty, GP);
        this.difficulty = difficulty;
        this.GP = GP;
        this.score = 0;
        this.gameEntity = new GameEntity(difficulty);
        this.increment = this.gameEntity.getIncrement();
        this.decrement = this.gameEntity.getDecrement();
        this.preset = new ArrayList<>();
        this.gameTime = new Integer[1];
    }

    /**
     * This genPreset method creates a preset of the game.
     *
     * @return an arraylist of strings that will show up as moles when the game runs
     */
    @Override
    public ArrayList<String> genPreset() {
        ArrayList<String> preset = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 60; i++) {
            int rand = r.nextInt(5) + 1;
            preset.add(rand + "P");
        }
        return preset;
    }

    /**
     * runs the game using TimerTask scheduled at fixed rate
     */
    public void run() {
        preset = genPreset();
        preset.add(preset.get(preset.size() - 1));
        gameTime = new Integer[]{61};
        this.score = 0;
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
                    if (!gameTime.equals(0)) {
                    score -= increment;}
                } else {
                    // score -= increment runs once more even when game ends, must fix below
                    score += increment;
                    if (score<0){
                        score = 0;
                    }
                    System.out.println("You Scored: " + score);
                    System.out.println("Game Over");
                    T.cancel();
                }
            }
        };
        T.scheduleAtFixedRate(TT, 3000, 1000);
    }

    /**
     * process a click, if position is correct
     * @param i
     */
    public void click(Integer i) {
        // Throws error if currPosition is nothing yet, temporary throws the program doesn't crash
        if (i == Integer.parseInt(this.currPosition.substring(0, 1))) {
            System.out.println("Clicked " + this.currPosition + " +" + this.increment);
            this.score += increment;
            this.score += increment;
        }
    }


    /**
     * setter for testing purposes
     * @param preset
     */
    public void setPreset(ArrayList<String> preset) {
        this.preset = preset;
    }

    /**
     * setter for testing purposes
     * @param i
     */
    public void setTime(int i) {
        this.gameTime = new Integer[]{i};
    }


    /**
     * to stop the timer if needed
     */
    public void stop(){
        this.T.cancel();
    }

    /**
     * getter for score
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * set score method for the tests
     * @param i
     */
    public void setScore(int i) {
        score = i;
    }
}