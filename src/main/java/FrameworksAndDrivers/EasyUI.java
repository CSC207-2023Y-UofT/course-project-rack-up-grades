package FrameworksAndDrivers;

import InterfaceAdapters.NavigatorController;
import InterfaceAdapters.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.TimerTask;


public class EasyUI extends JFrame implements ActionListener {
    private ViewModel viewM;
    private NavigatorController nc;
    final String fs = System.getProperty("file.separator");
    Icon pig = new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Test-Pig.png");
    Icon cat = new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Test-Cat.png");
    Icon bunny = new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Button-Magician_Kura.png");
    Icon mimi = new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Button-Love&Mimi.png");
    JLabel easy,time,pt;
    JButton but1, but2,but3,but4;
    JFrame easy_game_view = new JFrame("Easy-Rack_Up_Grades");


    public EasyUI(NavigatorController NC, ViewModel V){
        //
        this.nc = NC;
        this.viewM = V;
        //
        this.setLayout(null);
        this.setSize(1200,700);
        this.setLocationRelativeTo(null);
        //
        Container view = easy_game_view.getContentPane();
        //
        view.setLayout(null);
        view.setBounds(0,0,1200,700);
        this.add(view);
        //
        this.easy = new JLabel("Easy Model");
        view.add(this.easy);
        //
        this.time = new JLabel("Time: 60");
        view.add(this.time);
        //
        this.pt = new JLabel("Points: 0");
        view.add(this.pt);
        //
        this.but1 = new JButton("1",pig);
        view.add(this.but1);
        this.but1.addActionListener(this);
        this.but1.setVisible(false);
        //
        this.but2 = new JButton("2",cat);
        view.add(this.but2);
        this.but2.addActionListener(this);
        this.but2.setVisible(false);
        //
        this.but3 = new JButton("3",bunny);
        view.add(this.but3);
        this.but3.addActionListener(this);
        this.but3.setVisible(false);
        //
        this.but4 = new JButton("4",mimi);
        view.add(this.but4);
        this.but4.addActionListener(this);
        this.but4.setVisible(false);
        //
        set_Labels();
        set_buttons();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        //
        java.util.Timer T = new java.util.Timer();
        TimerTask TT = new TimerTask() {

            @Override
            public void run() {
                if (!Objects.equals(viewM.getInfo().get(1), "0")) {
                    but1.setVisible(false);
                    but2.setVisible(false);
                    but3.setVisible(false);
                    but4.setVisible(false);
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
                    }
                    time.setText("Time " + viewM.getInfo().get(1) + "s");
                    pt.setText("Points: " + viewM.getInfo().get(2));
                    System.out.println(viewM.getInfo());
                }

                else {
                    time.setText("Time " + viewM.getInfo().get(1) + "s");
                    pt.setText("Points: " + viewM.getInfo().get(2));
                    System.out.println(viewM.getInfo());
                    setDialog(NC);
                    T.cancel();
                    but1.setVisible(false);
                    but2.setVisible(false);
                    but3.setVisible(false);
                    but4.setVisible(false);

                }
            }
        };
        T.scheduleAtFixedRate(TT, 3050, 1000);};
        public void set_Labels(){
            this.easy.setBounds(50,50,100,50);
            this.time.setBounds(500,50,100,50);
            this.pt.setBounds(1050,50,100,50);
    };

        public void set_buttons(){
            this.but1.setVerticalAlignment(AbstractButton.TOP);
            this.but1.setHorizontalAlignment(AbstractButton.LEFT);
            this.but1.setBounds(200,300,300,300);
            this.but1.setName("1");
            //
            this.but2.setVerticalAlignment(AbstractButton.TOP);
            this.but2.setHorizontalAlignment(AbstractButton.RIGHT);
            this.but2.setBounds(500,300,300,300);
            this.but2.setName("1");
            //
            this.but3.setVerticalAlignment(AbstractButton.BOTTOM);
            this.but3.setHorizontalAlignment(AbstractButton.LEFT);
            this.but3.setBounds(800,300,300,300);
            this.but3.setName("1");
            //
            this.but4.setVerticalAlignment(AbstractButton.BOTTOM);
            this.but4.setHorizontalAlignment(AbstractButton.RIGHT);
            this.but4.setBounds(450,250,300,300);
            this.but4.setName("1");
            //
        }


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
        }
    }

    public void setDialog(NavigatorController NC){

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
