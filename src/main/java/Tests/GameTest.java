package Tests;
import ApplicationBusiness.*;
import InterfaceAdapters.GamePresenter;
import InterfaceAdapters.LeaderboardPresenter;
import InterfaceAdapters.NavigatorController;
import InterfaceAdapters.ViewModel;
import EnterpriseBusiness.GameEntity;
import jdk.jfr.Name;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.Array;
import java.util.*;

public class GameTest {
    ViewModel V = new ViewModel();
    InterfaceLeaderboardPresenter P = new LeaderboardPresenter(V);
    GameOutputBoundary GP = new GamePresenter(V);
    GameUseCase G = new GameUseCase("e", P, GP);
    GameEntity GEasy = new GameEntity("e");
    InputBoundary IB = new InputBoundaryImpl(G);
    NavigatorController NC = new NavigatorController(IB);

    @Test
    @DisplayName("Run Simulation")
    public void testRunEasyWithFiveMole() throws InterruptedException {

        //Starting a simulation of easy
        this.NC.run();
        //Creating a set of preset to for testing
        ArrayList<String> preset = new ArrayList<String>();
        preset.add("1P"); preset.add("3P"); preset.add("4P"); preset.add("1P"); preset.add("2P");

        //A hard coded fix for a bug that last item can never be clicked
        preset.add(preset.get(preset.size()-1));

        //Change our random preset to our preset for testing
        this.G.setPreset(preset);

        //Check if its changed
        assertEquals(this.G.getPreset(), preset);

        //Run the simulation and click on all the "buttons" in our preset
        Thread.sleep(3005);
        G.click(1);
        Thread.sleep(1000);
        G.click(3);
        Thread.sleep(1000);
        G.click(4);
        Thread.sleep(1000);
        G.click(1);
        Thread.sleep(1000);
        G.click(2);
        Thread.sleep(1000);

        //Calculating expected score
        int ExpectedFinalScore = 5*this.GEasy.getIncrement();

        //Check if score is correct. The score in our data structure is ExpectedFinalScore
        assertEquals(Integer.parseInt(this.V.getInfo().get(2)), ExpectedFinalScore);

    }



}
