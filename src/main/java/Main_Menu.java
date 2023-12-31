import ApplicationBusiness.*;
import UI.FrameworksAndDrivers.EasyUI;
import UI.FrameworksAndDrivers.HardUI;
import UI.FrameworksAndDrivers.Leaderboard_Frame;
import UI.FrameworksAndDrivers.MediumUI;
import InterfaceAdapters.GamePresenter;
import InterfaceAdapters.LeaderboardPresenter;
import InterfaceAdapters.NavigatorController;
import InterfaceAdapters.ViewModel;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * set Main Menu and the name of labels.
 */
public class Main_Menu extends JFrame {
    JButton i,easy,medium,hard,leader;
    JDialog leaderboard;
    public Main_Menu(String title) {
        super(title);
        this.i = new JButton("I"); //Icon will be done
        this.easy = new JButton("Easy");
        this.medium = new JButton("Medium");
        this.hard = new JButton("Hard");
        this.leader = new JButton("Leaderboard");//buttons
    }

    /**
     * set and add the buttons for Content Pane.
     * @param bdmainmenu background ContentPane for Main Menu
     */
    public void setAndAdd(JComponent bdmainmenu) {
        i.setBounds(1000,100,100,100);
        bdmainmenu.add(i);

        easy.setBounds(200,350,200,100);
        bdmainmenu.add(easy);

        medium.setBounds(500,350,200,100);
        bdmainmenu.add(medium);

        hard.setBounds(800,350,200,100);
        bdmainmenu.add(hard);

        leader.setBounds(400,500,400,80);
        bdmainmenu.add(leader);

    }
    /**
     * Set the Main Menu size, location and title,
     * add the background image and Content Pane.
     * @param args
     */

    public static void main(String[] args) {

        final String fs = System.getProperty("file.separator");


        Main_Menu mainmenu = new Main_Menu("Rack Up Grade - Main Menu");
        mainmenu.setSize(1200,700);
        mainmenu.setLocationRelativeTo(null);
        ViewModel V = new ViewModel();
        InterfaceLeaderboardPresenter P = new LeaderboardPresenter(V);
        GameOutputBoundary GP = new GamePresenter(V);
        mainmenu.setUpButtonListeners(V, P, GP);

        //
        JLabel bdmainmenu = new JLabel(new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"java" +fs+ "UI" +fs+"Background-MainMenu.jpg"));
        bdmainmenu.setBounds(0,0,1200,700);
        mainmenu.getContentPane().add(bdmainmenu);
        //
        mainmenu.setAndAdd(bdmainmenu);
        mainmenu.setResizable(false);
        mainmenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainmenu.setVisible(true);

    }

    /**
     * A button listener work as Action Performance,
     * click on easy/medium/hard lead to a different difficultly level game window;
     * click on i to the Message dialog that introduce the game;
     * click on leaderboard to the leaderboard frame.
     * @param V View Model
     * @param P Interface Leaderboard Presenter
     * @param GP Game Presenter
     */
    public void setUpButtonListeners(ViewModel V, InterfaceLeaderboardPresenter P, GameOutputBoundary GP) {
        final String fs = System.getProperty("file.separator");
        EasyUseCase EG = new EasyUseCase("e", GP);
        MediumUseCase MG = new MediumUseCase("m", GP);
        HardUseCase HG = new HardUseCase("h", GP);
        InputBoundary EasyIB = new InputBoundaryImpl(EG, P);
        InputBoundary MedIB = new InputBoundaryImpl(MG, P);
        InputBoundary HardIB = new InputBoundaryImpl(HG, P);
        NavigatorController EasyNav = new NavigatorController(EasyIB);
        NavigatorController MedNav = new NavigatorController(MedIB);
        NavigatorController HardNav = new NavigatorController(HardIB);

        ActionListener bs = e -> {
            Object click = e.getSource();
            if(click == i) {
                JOptionPane.showMessageDialog(this,
                        "Moles living underground of Toronto" +
                                " are taking over the U of T library, \n" +
                                "protect the library and stop moles' " +
                                "evil plan by clicking them! \nIn the medium level you can't miss the moles and in the hard you can't click the bomb!",
                        "Introduction",JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+ "java" +fs+"UI" +fs+"Intro.png"));
            }
            if (click == easy){
                System.out.println("easy");
                EasyNav.run();
                EasyUI eUI = new EasyUI(EasyNav, V);

            }
            if (click == medium){
                System.out.println("medium");
                MediumUI med = new MediumUI(MedNav, V);
                MedNav.run();
            }
            if (click == hard){
                System.out.println("hard");
                HardUI hard = new HardUI(HardNav, V);
                HardNav.run();
            }
            if (click == leader){
                EasyNav.addToLeaderboard("");
                Leaderboard_Frame leaderboard_Frame = new Leaderboard_Frame();
            }
        };
        i.addActionListener(bs);
        easy.addActionListener(bs);
        medium.addActionListener(bs);
        hard.addActionListener(bs);
        leader.addActionListener(bs);
    }

}

