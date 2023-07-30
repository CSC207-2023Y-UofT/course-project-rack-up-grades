/**
 * The LeaderboardController class is sub-controller that's a part of the
 * NavigatorController. It's used to get and set a user's name input
 * @author Andy
 */
public class LeaderboardController {

    private InputBoundary input;
    private String name;

    /**
     * constructs a Leaderboard Controller and stores the InputBoundary for use
     * @param input
     */
    public LeaderboardController(InputBoundary input) {
        this.input = input;
    }


    /**
     * This method is used to set the name that's going to be added to the
     * leaderboard through the InputBoundary to use case. And also call AddToLeaderboard
     * @param newName
     */
    public void addToLeaderboard(String newName) {
        this.input.addToLeaderboard(newName);
    }

}

