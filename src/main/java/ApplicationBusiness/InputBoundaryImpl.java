package ApplicationBusiness;

import InterfaceAdapters.LeaderboardPresenter;

/**
 * Implementation for methods in input boundary to withhold SOLID.
 * For both Liskov's principle and Dependency inversion principle
 */
public class InputBoundaryImpl implements InputBoundary{

    private InterfaceLeaderboardPresenter LP;
    private GameUseCase useCase;

    /**
     * Create an instance of this class
     * @param useCase the useCase that can be a easy, medium, or hard useCase
     */
    public InputBoundaryImpl(GameUseCase useCase, InterfaceLeaderboardPresenter LP) {
        this.LP = LP;
        this.useCase = useCase;
    }

    /**
     * Facade design pattern that will call useCases methods to update name, add to leaderboard, and tell presenter its updated
     * @param newName
     */
    @Override
    public void addToLeaderboard(String newName) {
        LeaderboardUseCase LbUse = new LeaderboardUseCase(useCase, LP);
        LbUse.setName(newName);
        LbUse.addToLeaderboard();
        LbUse.setData();
    }

    /**
     * if a click happens in controller, this will be called and the useCase's click method will be called
     * @param i
     */
    @Override
    public void click(Integer i) {
        this.useCase.click(i);
    }

    /**
     * run the game in the useCase's run
     */
    public void run() {
        this.useCase.run();
    }

    /**
     * stops the timer when the window closes
     */
    public void stop(){
        this.useCase.stop();
    }


}
