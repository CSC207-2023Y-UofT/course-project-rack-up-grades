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
        // This will call on view model to set the data (trusting that view will get that data from view model)
        this.viewModel.updateGame(position, time, score);
    }

    public ViewModel getViewModel(){
        return this.viewModel;
    }
}

