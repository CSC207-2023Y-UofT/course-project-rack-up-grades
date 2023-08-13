import ApplicationBusiness.*;
import EnterpriseBusiness.GameEntity;
import InterfaceAdapters.GamePresenter;
import InterfaceAdapters.LeaderboardPresenter;
import InterfaceAdapters.NavigatorController;
import InterfaceAdapters.ViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class MediumGameTest {
    ViewModel V = new ViewModel();
    InterfaceLeaderboardPresenter P = new LeaderboardPresenter(V);
    GameOutputBoundary GP = new GamePresenter(V);
    MediumUseCase GMed = new MediumUseCase("m", GP);
    GameEntity GEMed = new GameEntity("m");
    InputBoundary MedIB = new InputBoundaryImpl(GMed, P);
    NavigatorController NCMed = new NavigatorController(MedIB);


    /**
     * The purpose of this test is to test as a unit Controllers, InputBoundary, UseCase, OutputBoundary & Presenter
     * as a whole for easy to ensure that the correct final score is being outputted in the ViewModel
     * @throws InterruptedException
     */
    @Test
    public void testRunMedWithFiveMoleMiss1() throws InterruptedException {

        //Starting a simulation of medium
        this.NCMed.run();
        //Creating a set of preset to for testing
        ArrayList<String> preset = new ArrayList<String>();
        preset.add("2P"); preset.add("5P"); preset.add("1P"); preset.add("2P"); preset.add("4P");

        //A hard coded fix for a bug
        preset.add(preset.get(preset.size()-1));

        //Change our random preset to our preset for testing
        this.GMed.setPreset(preset);

        //Run the simulation and click on all the "buttons" in our preset
        //sleep used to account for the 3-second delay before run actually starts
        //and 1 second before every new mole shows up
        //could be rewritten with loop for larger tests
        //purposely miss the last mole
        Thread.sleep(3010);
        NCMed.click(2);
        Thread.sleep(1000);
        NCMed.click(5);
        Thread.sleep(1000);
        NCMed.click(1);
        Thread.sleep(1000);
        NCMed.click(2);
        Thread.sleep(1000);

//        Miss last mole
//        NCMed.click(4);
        Thread.sleep(1000);

        NCMed.stop();

        int ExpectedFinalScore = 4*this.GEMed.getIncrement() - this.GEMed.getIncrement();

        //Check if score is correct. The score in our data structure is ExpectedFinalScore
        Assertions.assertEquals(ExpectedFinalScore, Integer.parseInt(this.V.getInfo().get(2)));

    }

}
