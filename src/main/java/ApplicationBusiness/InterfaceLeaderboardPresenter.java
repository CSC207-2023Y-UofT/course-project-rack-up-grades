package ApplicationBusiness;

import java.util.ArrayList;

/**
 * InterfaceLeaderboardPresenter is and interface implemented by LeaderboardPresenter and has methods that it must implement
 * for the purpose of dependency inversion and CA
 */
public interface InterfaceLeaderboardPresenter {
    void setData(ArrayList<String> data);
}