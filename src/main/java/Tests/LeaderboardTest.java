package Tests;
import ApplicationBusiness.*;
import EnterpriseBusiness.GameEntity;
import FrameworksAndDrivers.DataAccess;
import InterfaceAdapters.GamePresenter;
import InterfaceAdapters.LeaderboardPresenter;
import InterfaceAdapters.NavigatorController;
import InterfaceAdapters.ViewModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;


public class LeaderboardTest {
    ViewModel V = new ViewModel();
    InterfaceLeaderboardPresenter P = new LeaderboardPresenter(V);
    GameOutputBoundary GP = new GamePresenter(V);
    EasyUseCase EG = new EasyUseCase("e", P, GP);
    GameEntity GEasy = new GameEntity("e");
    InputBoundary IB = new InputBoundaryImpl(EG);
    NavigatorController NC = new NavigatorController(IB);
    final String fs = System.getProperty("file.separator");
    final String FILE = System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"JAVA"+fs+ "FrameworksAndDrivers/file.txt";

    private final DataAccessInterface DataAccIn = new DataAccess(FILE);


    @Test
    public void testAddToLeaderboard(){
        // Checks the case that name is added to leaderboard
        EG.setScore(290);
        IB.addToLeaderboard("mike");
        String expected = "mike,290,e";
        boolean result = false;

        ArrayList<String> data = DataAccIn.read();
        for (int i = 0; i < data.size(); i++){
            if(expected.equals(data.get(i))){
                result = true;
            }
        }

        assertTrue("the data is found in the file", result);

    }

    @Test
    public void testNotAddToLeaderboard(){
        // Checks the case that name is added to leaderboard because score too low
        // Make sure the txt file has 10 scores that are more than 0
        EG.setScore(0);
        IB.addToLeaderboard("name");
        String expected = "name,0,e";
        boolean res = false;

        ArrayList<String> data = DataAccIn.read();
        for (int i = 0; i < data.size(); i++){
            if(expected.equals(data.get(i))){
                res = true;
            }
        }

        assertFalse("the data is not found in file since score is too low", res);

    }
}
