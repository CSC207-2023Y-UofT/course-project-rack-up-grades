import java.util.ArrayList;

/**
 * ViewModel for LeaderboardPresenter and GamePresenter
 */
public class ViewModel {
    Object[][] data;
    ArrayList<String> info;

    /**
     * sets data for leaderboard data
     * @param data stores top 10 of leaderboard if they exist. In the form "<Place> <Name> <Points> <Difficulty> \n <Place> <Name> <Points> <Difficulty> ..."
     */
    public void setData(Object[][] data) {
        this.data = data;
    }

    /**
     * sets info of game
     * @param info stores [position, time, score]
     */
    public void updateGame(ArrayList<String> info) {
        this.info = info;
    }

    /**
     * getter for data
     * @return data (refer above)
     */
    public Object[][] getData(){
        return this.data;
    }

    /**
     * getter for info
     * @return info (refer above)
     */
    public ArrayList<String> getInfo(){
        return this.info;
    }
}