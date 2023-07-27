public class GamePresenter implements GameOutputBoundary {
    // Not really sure what to do here
    /* Responsibility
       Translates data from output boundary to be usable by ViewModel

       Gives only the information required to produce a view to the ViewModel

     */

    GamePresenter(ViewModel vm){
        this.viewModel = vm;
    }
    public void updateGame(String position, int time, int score) {
        // another way is for the presenter to return something but that would mean the main menu takes care of the
        // timing which is a violation of CA
        this.viewModel.updateGame(position, time, score);
    }

    public ViewModel getViewModel(){
        return this.viewModel;
    }
}

