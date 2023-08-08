package ApplicationBusiness;

/**
 * GameOutputBoundary is and interface implemented by GamePresenter and has methods that it must implement
 * for the purpose of dependency inversion and CA
 */
public interface GameOutputBoundary {
    void updateGame(String position, int time, int score);
}
