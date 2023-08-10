package FrameworksAndDrivers;

import InterfaceAdapters.NavigatorController;
import InterfaceAdapters.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;
import java.util.TimerTask;

/**
 * set a medium mode game
 */
public class MediumUI extends JFrame implements ActionListener {
    private ViewModel viewM;
    private NavigatorController nc;
    final String fs = System.getProperty("file.separator");
    Icon pig = new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Button-GiantMole_Cathy.png");
    Icon cat = new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Button-Abstract_Hery.png");
    Icon bunny = new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Button-Magician_Kura.png");
    Icon mimi = new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Button-Love&Mimi.png");
    JLabel medium,time,pt;
    JButton but1, but2, but3, but4 ,but5;
    JFrame med_game_view = new JFrame("Easy-Rack_Up_Grades");
    private java.util.Timer T;

    /**
     * set a medium mode game frame,ContentPane,labels,buttons.
     * @param NC Navigator Controller
     * @param V View Model
     */
    public MediumUI(NavigatorController NC, ViewModel V){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                NC.stop();
                T.cancel();
            }
        });
        //
        this.nc = NC;
        this.viewM = V;
        //
        this.setLayout(null);
        this.setSize(1200,700);
        this.setLocationRelativeTo(null);
        //
        JLabel bdmed = new JLabel(new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Background-Easy.jpg"));
        bdmed.setBounds(0,0,1200,700);
        med_game_view.getContentPane().add(bdmed);
        //
        bdmed.setLayout(null);
        bdmed.setBounds(0,0,1200,700);
        this.add(bdmed);
        //
        this.medium = new JLabel("Medium Mode");
        bdmed.add(this.medium);
        //
        this.time = new JLabel("Time: 60");
        bdmed.add(this.time);
        //
        this.pt = new JLabel("Points: 0");
        bdmed.add(this.pt);
        //
        this.but1 = new JButton(pig);
        bdmed.add(this.but1);
        this.but1.addActionListener(this);
        this.but1.setVisible(false);
        //
        this.but2 = new JButton(cat);
        bdmed.add(this.but2);
        this.but2.addActionListener(this);
        this.but2.setVisible(false);
        //
        this.but3 = new JButton(bunny);
        bdmed.add(this.but3);
        this.but3.addActionListener(this);
        this.but3.setVisible(false);
        //
        this.but4 = new JButton(mimi);
        bdmed.add(this.but4);
        this.but4.addActionListener(this);
        this.but4.setVisible(false);
        //
        this.but5 = new JButton(mimi);
        bdmed.add(this.but5);
        this.but5.addActionListener(this);
        this.but5.setVisible(false);
        //
        set_Labels();
        set_buttons();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        //
        T = new java.util.Timer();
        TimerTask TT = new TimerTask() {

            @Override
            public void run() {
                if (!Objects.equals(viewM.getInfo().get(1), "0")) {
                    but1.setVisible(false);
                    but2.setVisible(false);
                    but3.setVisible(false);
                    but4.setVisible(false);
                    but5.setVisible(false);
                    String position = (viewM.getInfo().get(0)).substring(0,1);
                    switch (position){
                        case "1":
                            but1.setVisible(true);
                            break;
                        case "2":
                            but2.setVisible(true);
                            break;
                        case "3":
                            but3.setVisible(true);
                            break;
                        case "4":
                            but4.setVisible(true);
                            break;
                        case "5":
                            but5.setVisible(true);
                            break;
                    }
                    time.setText("Time " + viewM.getInfo().get(1) + "s");
                    pt.setText("Points: " + viewM.getInfo().get(2));
                    System.out.println(viewM.getInfo());
                }

                else {
                    time.setText("Time " + viewM.getInfo().get(1) + "s");
                    pt.setText("Points: " + viewM.getInfo().get(2));
                    System.out.println(viewM.getInfo());
                    setDialog();
                    T.cancel();
                    but1.setVisible(false);
                    but2.setVisible(false);
                    but3.setVisible(false);
                    but4.setVisible(false);
                    but5.setVisible(false);

                }
            }
        };
        T.scheduleAtFixedRate(TT, 3050, 1000);};

    /**
     * set the location and size for labels, which shows up at upper frame.
     */
    public void set_Labels(){
        this.medium.setBounds(100,65,100,50);
        this.time.setBounds(565,50,100,50);
        this.pt.setBounds(1000,65,100,50);
    };

    /**
     * set the names, location and size for buttons.
     */
    public void set_buttons(){
        this.but1.setVerticalAlignment(AbstractButton.TOP);
        this.but1.setHorizontalAlignment(AbstractButton.LEFT);
        this.but1.setBounds(100,300,300,300);
        this.but1.setName("1");
        //
        this.but2.setVerticalAlignment(AbstractButton.TOP);
        this.but2.setHorizontalAlignment(AbstractButton.RIGHT);
        this.but2.setBounds(900,300,300,300);
        this.but2.setName("2");
        //
        this.but3.setVerticalAlignment(AbstractButton.BOTTOM);
        this.but3.setHorizontalAlignment(AbstractButton.LEFT);
        this.but3.setBounds(300,300,300,300);
        this.but3.setName("3");
        //
        this.but4.setVerticalAlignment(AbstractButton.BOTTOM);
        this.but4.setHorizontalAlignment(AbstractButton.RIGHT);
        this.but4.setBounds(600,250,300,300);
        this.but4.setName("4");
        //
        this.but5.setVerticalAlignment(AbstractButton.BOTTOM);
        this.but5.setHorizontalAlignment(AbstractButton.RIGHT);
        this.but5.setBounds(400,200,300,300);
        this.but5.setName("5");
    }

    /**
     * set the action performed for the event for click on the buttons.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton o = (JButton)e.getSource(); //the button that was clicked name
        String name = o.getText();
        switch (name){
            case "1":
                this.nc.click(1);
                this.but1.setVisible(false);
                break;
            case "2":
                this.nc.click(2);
                this.but2.setVisible(false);
                break;
            case "3":
                this.nc.click(3);
                this.but3.setVisible(false);
                break;
            case "4":
                this.nc.click(4);
                this.but4.setVisible(false);
                break;
            case "5":
                this.nc.click(5);
                this.but5.setVisible(false);
                break;
        }
    }

    /**
     * Set a confirm Dialog for end_game, with info and two option for player
     * save their name or leave the current game.
     */
    public void setDialog(){

        int event = JOptionPane.showConfirmDialog(null,
                "Your Final Grade is "+ this.viewM.getInfo().get(2) +"! Would you like to save it?", "Congratulation!",JOptionPane.YES_NO_OPTION);
        if(event == 0){
            String input_name,output_name;
            input_name = JOptionPane.showInputDialog("Type your name in 8 characters.");
            this.nc.addToLeaderboard(input_name);
//            this.nc.setData();
            Leaderboard_Frame leaderboard_Frame = new Leaderboard_Frame();
            dispose();

            ///output_name should link with view model
        };
        if(event == 1){
            dispose();
        };
    }


}
