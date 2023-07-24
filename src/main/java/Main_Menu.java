import javax.swing.*;
import java.awt.*;

public class Main_Menu extends JPanel {

    public static void main(String[] args) {
        JFrame mainmenu = new JFrame("Rack Up Grade - Main Menu");
        mainmenu.setSize(1200,700);
        mainmenu.setLocationRelativeTo(null);
        JButton i = new JButton("I"); //Icon will be done
        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");
        JButton leaderboard = new JButton("Leaderboard");//buttons
        //
        JPanel menu = new JPanel();
        menu.setLayout(null);
        menu.add(i);
        i.setBounds(1000,100,100,100);
        menu.add(easy);
        easy.setBounds(200,350,200,100);
        menu.add(medium);
        medium.setBounds(500,350,200,100);
        menu.add(hard);
        hard.setBounds(800,350,200,100);
        menu.add(leaderboard);
        leaderboard.setBounds(400,500,400,80);
        mainmenu.add(menu);
        //
        mainmenu.setResizable(false);
        mainmenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainmenu.setVisible(true);
        menu.setVisible(true);
    }
}
