public class GamePresenter implements GameOutputBoundary {
    // Not really sure what to do here
    /* Responsibility
       Translates data from output boundary to be usable by ViewModel

       Gives only the information required to produce a view to the ViewModel

     */

    GamePresenter(MainMenu view, GameUseCase gameUseCase){
        this.gameUseCase = gameUseCase;
        this.view = MainMenu;
    }
    public void presenter(String position, int time, int score) {
        // another way is for the presenter to return something but that would mean the main menu takes care of the
        // timing which is a violation of CA
        view.updateGame(position, time, score);
    }
}
