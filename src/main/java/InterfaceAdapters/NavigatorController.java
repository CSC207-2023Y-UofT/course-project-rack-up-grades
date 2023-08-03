package InterfaceAdapters;

import ApplicationBusiness.InputBoundary;

public class NavigatorController {
    private InputBoundary input;
    private LeaderboardController LC;
    private GameController GC;

    /**
     * constructs a Navigator Controller as the central controller for Leaderboard Controller
     * and Game Controller by creating an instance of them and saving them here
     * stores the instance of ApplicationBusiness.InputBoundary
     * @param input
     */
    public NavigatorController(InputBoundary input) {
        this.input = input;
        LC = new LeaderboardController(input);
        GC = new GameController(input);

    }

    /**
     * Refer to Leaderboard Controller documentation
     * @param newName
     */
    public void addToLeaderboard(String newName) {
        this.LC.addToLeaderboard(newName);
    }


    /**
     * Refer to Game Controller documentation
     * @param i
     */
    public void click(Integer i) {
        this.GC.click(i);
    }


    public void run() {
        this.input.run();
    }

}
