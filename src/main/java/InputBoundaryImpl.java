public class InputBoundaryImpl implements InputBoundary{

    private GameUseCase useCase;

    InputBoundaryImpl(GameUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void addToLeaderboard(String newName) {
        this.useCase.setName(newName);
        this.useCase.addToLeaderboard();
        this.useCase.setData();
    }

    @Override
    public void click(Integer i) {
        this.useCase.click(i);
    }

    public void run() {
        this.useCase.run();
    }


}
