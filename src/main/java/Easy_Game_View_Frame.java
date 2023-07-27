import javax.swing.*;

public class Easy_Game_View_Frame extends JFrame{
    JLabel easy,time,pt;
    JPanel view = new JPanel();
    public Easy_Game_View_Frame(){
        setLayout(null);
        setSize(1200,700);
        setTitle("Easy-Rack_Up_Grades");
        //
        view.setLayout(null);
        //set bounds for view in null layout is important
        view.setBounds(0,0,1200,700);
        add(view);
        //
        easy = new JLabel("Easy Model");
        //
        time = new JLabel("Seconds");
        //
        pt = new JLabel("points");
        //
        setLabel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    };
    public void setLabel(){
        view.add(easy);
        easy.setBounds(50,50,100,50);
        view.add(time);
        time.setBounds(600,50,100,50);
        view.add(pt);
        pt.setBounds(1050,50,100,50);

    }
}
