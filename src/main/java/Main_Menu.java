import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Menu extends JFrame {
    JButton i,easy,medium,hard,leaderboard;

    public Main_Menu(String title) {
        super(title);
        this.i = new JButton("I"); //Icon will be done
        this.easy = new JButton("Easy");
        this.medium = new JButton("Medium");
        this.hard = new JButton("Hard");
        this.leaderboard = new JButton("Leaderboard");//buttons
    }

    public void setAndAdd(JPanel menu) {
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
    }

    public static void main(String[] args) {
        Main_Menu mainmenu = new Main_Menu("Rack Up Grade - Main Menu");
        mainmenu.setSize(1200,700);
        mainmenu.setLocationRelativeTo(null);
        mainmenu.setUpButtonListeners();
        JPanel menu = new JPanel();
        menu.setLayout(null);
        mainmenu.setAndAdd(menu);
        mainmenu.add(menu);
        mainmenu.setResizable(false);
        mainmenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainmenu.setVisible(true);
        menu.setVisible(true);

    }
    public void setUpButtonListeners() {
        ActionListener bs = e -> {
            Object click = e.getSource();
            if(click == i) {
                System.out.println("INFO");
            }
            if (click == easy){
                System.out.println("easy");
            }
            if (click == medium){
                System.out.println("medium");
            }
            if (click == hard){
                System.out.println("hard");
            }
            if (click == leaderboard){
                System.out.println("Leaderboard");
            }
        };
        i.addActionListener(bs);
        easy.addActionListener(bs);
        medium.addActionListener(bs);
        hard.addActionListener(bs);
        leaderboard.addActionListener(bs);
    }

}

