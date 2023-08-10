package Tests;

import ApplicationBusiness.*;
import EnterpriseBusiness.GameEntity;
import InterfaceAdapters.GamePresenter;
import InterfaceAdapters.LeaderboardPresenter;
import InterfaceAdapters.NavigatorController;
import InterfaceAdapters.ViewModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class GameTest {
    ViewModel V = new ViewModel();
    InterfaceLeaderboardPresenter P = new LeaderboardPresenter(V);
    GameOutputBoundary GP = new GamePresenter(V);
    EasyUseCase G = new EasyUseCase("e", GP);
    GameEntity GEasy = new GameEntity("e");
    InputBoundary IB = new InputBoundaryImpl(G, P);
    NavigatorController NC = new NavigatorController(IB);


    /**
     * The purpose of this test is to test as a unit Controllers, InputBoundary, UseCase, OutputBoundary & Presenter
     * as a whole to ensure that the correct final score is being outputted in the ViewModel
     * @throws InterruptedException
     */
    @Test
    public void testRunEasyWithFiveMole() throws InterruptedException {

        //Starting a simulation of easy
        this.NC.run();
        //Creating a set of preset to for testing
        ArrayList<String> preset = new ArrayList<String>();
        preset.add("1P"); preset.add("3P"); preset.add("4P"); preset.add("1P"); preset.add("2P");

        //A hard coded fix for a bug
        preset.add(preset.get(preset.size()-1));

        //Change our random preset to our preset for testing
        this.G.setPreset(preset);

        //Run the simulation and click on all the "buttons" in our preset
        //sleep used to account for the 3-second delay before run actually starts
        //and 1 second before every new mole shows up
        //could be rewritten with loop for larger tests
        Thread.sleep(3005);
        NC.click(1);
        Thread.sleep(1000);
        NC.click(3);
        Thread.sleep(1000);
        NC.click(4);
        Thread.sleep(1000);
        NC.click(1);
        Thread.sleep(1000);
        NC.click(2);
        Thread.sleep(1000);

        //Calculating expected score
        int ExpectedFinalScore = 5*this.GEasy.getIncrement();

        //Check if score is correct. The score in our data structure is ExpectedFinalScore
        assertEquals(ExpectedFinalScore, Integer.parseInt(this.V.getInfo().get(2)));

    }

    /**
     * The purpose of this test is to test as a unit the Controllers, InputBoundary, UseCase, OutputBoundary, and
     * Presenter as a whole to ensure that the correct final score is being outputted in the ViewModel.
     * This test will always be random, but always pass. It will only click on one of four easy mode moles for
     * the entire game. The game generation (preset) will always also be random. Then calculate the expected score
     * the game should have got with the action (click) and compare with the score calculated in the UseCase
     * DO EXPECT IT TO TAKE LONG (1 full minute) AS A FULL SIMULATION OF THE GAME WILL HAVE TO RUN
     * @throws InterruptedException
     */
    @Test
    public void testRunEasyWithRandomPresetClickOnlyOneOfFourMole() throws InterruptedException {
        //This test will always be random, however it should always pass
        //DO EXPECT IT TO TAKE LONG AS A FULL SIMULATION OF THE GAME WILL HAVE TO RUN


        //Choosing which of four mole to click for the entire run duration
        Random r = new Random();
        Integer i = r.nextInt(4)+1;

        //Counter for number of clicks
        Integer j = 0;

        //Run a simulation
        this.NC.run();

        //Sleep is for TimerTask Fixed Rate Schedule
        Thread.sleep(3005);

        //While the preset isn't empty the game is still running
        while (!G.getPreset().isEmpty()) {

            //Only click on the one of four mole we plan to click,
            //For each its a click occurs add to number of clicks
            if (((Integer)Integer.parseInt(this.V.getInfo().get(0).substring(0,1))).equals(i)) {
                NC.click(i);
                j+=1;
            }
            Thread.sleep(1000);

        }

        //Calculate expectedScore with number of clicks and how much that mole is worth
        int expectedScore = j*this.GEasy.getIncrement();

        //The score that is processed in the game should be the same as the calculated expected score
        assertEquals(expectedScore, Integer.parseInt(this.V.getInfo().get(2)));


    }


}
