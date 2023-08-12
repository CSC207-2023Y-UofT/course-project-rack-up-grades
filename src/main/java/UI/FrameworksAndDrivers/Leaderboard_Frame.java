package UI.FrameworksAndDrivers;

import InterfaceAdapters.ViewModel;

import javax.swing.*;

/**
 * set a Leaderboard with size,title,include a Scroll panel and a JTable on it
 * to show the top 10 info with NO, Player name, points and Game level.
 * get the data from View Model.
 */
public class Leaderboard_Frame extends JFrame {

    public Leaderboard_Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setTitle("TOP 10 Leaderboard");
        this.setLocationRelativeTo(null);
        String[] columns = new String[]{
                "NO.","Player Name","Points","Game Level"
        };
        JTable table = new JTable(ViewModel.getData(),columns);
        table.setEnabled(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(new JScrollPane(table));
        this.pack();
        this.setLayout(null);
        this.setVisible(true);
    };
};
