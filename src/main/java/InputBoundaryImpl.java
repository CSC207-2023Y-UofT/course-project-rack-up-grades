public class InputBoundaryImpl implements InputBoundary{

    private GameUseCase useCase;

    InputBoundaryImpl(GameUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void addToLeaderboard(String newName) {
        useCase.setName(newName);
        useCase.addToLeaderboard();
    }

    @Override
    public void click(Integer i) {
        useCase.click(i);
    }

    @Override
    public void setData() {
        useCase.setData();
    }

    public void run() {
        useCase.run();
    }


}
