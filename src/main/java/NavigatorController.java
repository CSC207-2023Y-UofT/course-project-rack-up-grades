public class NavigatorController {
    private InputBoundary input;
    private LeaderboardController LC;
    public NavigatorController(InputBoundary input) {
        this.input = input;
        LC = new LeaderboardController(input);

    }

    public void setName(String newName) {
        LC.setName(newName);
    }

}
