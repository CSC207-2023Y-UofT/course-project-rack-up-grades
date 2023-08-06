package ApplicationBusiness;

/**
 * InputBoundary is for the InputBoundaryImpl, Navigator controller will call on these methods
 * for the purpose of dependency inversion and CA
 */
public interface InputBoundary {
    void addToLeaderboard(String newName);

    void click(Integer i);

    void run();
}
