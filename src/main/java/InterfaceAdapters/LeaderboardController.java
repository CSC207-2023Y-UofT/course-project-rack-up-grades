package InterfaceAdapters;

import ApplicationBusiness.InputBoundary;

/**
 * The InterfaceAdapters.LeaderboardController class is sub-controller that's a part of the
 * InterfaceAdapters.NavigatorController. It's used to get and set a user's name input
 * @author Andy
 */
public class LeaderboardController {

    private InputBoundary input;

    /**
     * constructs a Leaderboard Controller and stores the ApplicationBusiness.InputBoundary for use
     * @param input
     */
    public LeaderboardController(InputBoundary input) {
        this.input = input;
    }


    /**
     * This method is used to set the name that's going to be added to the
     * leaderboard through the ApplicationBusiness.InputBoundary to use case. And also call AddToLeaderboard
     * @param newName
     */
    public void addToLeaderboard(String newName) {
        this.input.addToLeaderboard(newName);
    }

}

