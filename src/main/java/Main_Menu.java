import javax.swing.*;
import java.awt.event.ActionListener;

public class Main_Menu extends JFrame {
    JButton i,easy,medium,hard,leader;
    public Main_Menu(String title) {
        super(title);
        this.i = new JButton("I"); //Icon will be done
        this.easy = new JButton("Easy");
        this.medium = new JButton("Medium");
        this.hard = new JButton("Hard");
        this.leader = new JButton("Leaderboard");//buttons
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
        menu.add(leader);
        leader.setBounds(400,500,400,80);
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
                JOptionPane.showMessageDialog(this,
                        "Moles living underground of Toronto" +
                                " are taking over the U of T library," +
                                "protect the library and stop moles'" +
                                "evil plan by clicking them!",
                        "Introduction",JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("/Users/magicbook/Desktop/UI/intro.png"));
            }
            if (click == easy){
                Easy_Game_View_Frame easy_view = new Easy_Game_View_Frame(ViewMoudel);
                easy_view.setDefaultCloseOperation(EXIT_ON_CLOSE);
                easy_view.setVisible(true);
            }
            if (click == medium){
                System.out.println("medium");
            }
            if (click == hard){
                System.out.println("hard");
            }
            if (click == leader){
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

