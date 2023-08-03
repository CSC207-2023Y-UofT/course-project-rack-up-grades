package InterfaceAdapters;

import ApplicationBusiness.GameOutputBoundary;

import java.util.ArrayList;

public class GamePresenter implements GameOutputBoundary {
    // Not really sure what to do here
    /* Responsibility
       Translates data from output boundary to be usable by InterfaceAdapters.ViewModel

       Gives only the information required to produce a view to the InterfaceAdapters.ViewModel

     */

    /**
     * This is the constructor that is used by the Use case in order to present the information onto the view model
     * It stores the view model so that it can be accessed by the presenter in the later methods
     * @param vm
     */
    ViewModel viewModel;
    
    public GamePresenter(ViewModel vm){
        this.viewModel = vm;
    }

    /**
     * This is how the presenter sends and sets the information on the view model
     * It gives position, time and total score to the view model in an array for them to access
     * @param position
     * @param time
     * @param score
     */
    public void updateGame(String position, int time, int score) {

        ArrayList<String> info = new ArrayList<String>();
        info.add(position);
        info.add(Integer.toString(time));
        info.add(Integer.toString(score));
        this.viewModel.updateGame(info);
    }

}

