import javax.swing.*;

public class Leaderboard_Frame extends JFrame {

    public Leaderboard_Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setTitle("TOP 10 Leaderboard");
        this.setLocationRelativeTo(null);
        JScrollPane ld = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(ld);
        this.setContentPane(ld);
        this.setLayout(null);
        this.setVisible(true);
    }
}
