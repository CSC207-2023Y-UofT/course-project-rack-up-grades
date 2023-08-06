package ApplicationBusiness;

/**
 * Implementation for methods in input boundary to withhold SOLID.
 * For both Liskov's principle and Dependency inversion principle
 */
public class InputBoundaryImpl implements InputBoundary{

    private GameUseCase useCase;
    private MediumUseCase midUseCase;

    /**
     * Create an instance of this class
     * @param useCase the useCase that can be a easy, medium, or hard useCase
     */
    public InputBoundaryImpl(GameUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Facade design pattern that will call useCases methods to update name, add to leaderboard, and tell presenter its updated
     * @param newName
     */
    @Override
    public void addToLeaderboard(String newName) {
        this.useCase.setName(newName);
        this.useCase.addToLeaderboard();
        this.useCase.setData();
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


}
