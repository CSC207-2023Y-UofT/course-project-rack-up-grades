package ApplicationBusiness;

import EnterpriseBusiness.GameEntity;

import java.util.*;

/**
 * The GameUseCase class is the parent of easy medium hard usecase, it is abstract and has some abstract methods
 */
public abstract class GameUseCase {
    private int score;

    private GameEntity gameEntity;
    private int increment;
    private int decrement;

    private String currPosition;
    private ArrayList<String> preset;

    private Integer[] gameTime;

    private String difficulty;
    private GameOutputBoundary GP;


    /**
     * Initialize ApplicationBusiness.GameUseCase
     * @param difficulty a param e, m, and h for easy, medium, and hard, respectively
     * @param GP a game presenter interface (OutputBoundary)
     *
     */
    public GameUseCase(String difficulty, GameOutputBoundary GP) {
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
     * This genPreset method creates a preset depending on gamemode. Can be combined with the code above
     * @return an arraylist of strings that will show up as moles when the game runs
     */
    public abstract ArrayList<String> genPreset();


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
     * abstract class for the child to overwrite
     */
    public abstract void stop();

    /**
     * set score method for the tests
     * @param i
     */
    public abstract void setScore(int i);


    /**
     * getter for score
     * @return score
     */
    public abstract int getScore();

    /**
     * getter for difficulty
     * @return difficulty
     */
    public String getDifficulty() {
        return difficulty;
    }
}

