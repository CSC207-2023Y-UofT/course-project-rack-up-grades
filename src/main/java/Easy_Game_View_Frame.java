import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class Easy_Game_View_Frame extends JFrame{
    JLabel easy,time,s,pt;
    JFrame easy_game_view = new JFrame("Easy-Rack_Up_Grades");
    ImageIcon easy_background = new ImageIcon(
            "/Users/magicbook/Desktop/UI/Easy-Background.jpg");
    ViewModel V;
    public Easy_Game_View_Frame(ViewModel V){
        this.V = V;
        setLayout(null);
        setSize(1200,700);
        //
        Container view = easy_game_view.getContentPane();
        //
        view.setLayout(null);
        //set bounds for view in null layout is important
        view.setBounds(0,0,1200,700);
        add(view);
        //
        easy = new JLabel("Easy Model");
        view.add(easy);
        //
        s = new JLabel("Seconds");
        view.add(s);
        //
        pt = new JLabel("points");
        view.add(pt);
        //
        String t = this.V.getInfo()[1];
        time = new JLabel(t);
        view.add(time);
        //
        setLabel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDialog();
    };
    public void setLabel(){
        easy.setBounds(50,50,100,50);
        time.setBounds(500,50,100,50);
        s.setBounds(600,50,100,50);
        pt.setBounds(1050,50,100,50);

    }
    public void setMole(){};
    public void setDialog(){
        if(V.getInfo()[1] == 0){
            int event = JOptionPane.showConfirmDialog(null,
                    JOptionPane.QUESTION_MESSAGE,
                    "Your Final Grade is"+"points"+"!Would you like to save it?", JOptionPane.YES_NO_OPTION);
            if(event == 0){
                String input_name,output_name;
                input_name = JOptionPane.showInputDialog("Type your name in 8 characters.");
                output_name = input_name.substring(0,8);
                ///output_name should link with view model.
            };
            if(event == 1){
                dispose();
            };
        }

    };

}
