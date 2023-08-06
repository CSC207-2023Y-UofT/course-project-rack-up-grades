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

public class LeaderboardTest {
    ViewModel V = new ViewModel();
    InterfaceLeaderboardPresenter P = new LeaderboardPresenter(V);
    GameOutputBoundary GP = new GamePresenter(V);
    GameUseCase G = new EasyUseCase("e", P, GP);
    GameEntity GEasy = new GameEntity("e");
    InputBoundary IB = new InputBoundaryImpl(G);
    NavigatorController NC = new NavigatorController(IB);

    @Test
    public void testAddToLeaderboard(){

    }
}
