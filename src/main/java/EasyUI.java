import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.TimerTask;


public class EasyUI extends JPanel implements ActionListener {

    private ViewModel viewM;
    private NavigatorController nc;
    
    JButton but1;
    JButton but2;
    JButton but3;
    JButton but4;
    

    EasyUI(NavigatorController NC, ViewModel V){

        this.nc = NC;
        this.viewM = V;

        JFrame frame = new JFrame("the game");
        JLabel title = new JLabel("The actual game");
        this.but1 = new JButton("1");
        this.but1.setVerticalAlignment(AbstractButton.TOP);
        this.but1.setHorizontalAlignment(AbstractButton.LEFT);

        this.but2 = new JButton("2");
        this.but2.setVerticalAlignment(AbstractButton.TOP);
        this.but2.setHorizontalAlignment(AbstractButton.RIGHT);

        this.but3 = new JButton("3");
        this.but3.setVerticalAlignment(AbstractButton.BOTTOM);
        this.but3.setHorizontalAlignment(AbstractButton.LEFT);

        this.but4 = new JButton("4");
        this.but4.setVerticalAlignment(AbstractButton.BOTTOM);
        this.but4.setHorizontalAlignment(AbstractButton.RIGHT);

        this.but1.setName("1");
        this.but2.setName("2");
        this.but3.setName("3");
        this.but4.setName("4");


        this.but1.addActionListener(this);
        this.but2.addActionListener(this);
        this.but3.addActionListener(this);
        this.but4.addActionListener(this);

        title.setBounds(0,0,100,50);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setVisible(true);


        this.but1.setBounds(10,50,100,50);
        this.but2.setBounds(220,50,100,50);
        this.but3.setBounds(10,150,100,50);
        this.but4.setBounds(220,150,100,50);

        this.but1.setVisible(false);
        this.but2.setVisible(false);
        this.but3.setVisible(false);
        this.but4.setVisible(false);

        frame.add(title);

        frame.add(this.but1);

        frame.add(this.but2);
        frame.add(this.but3);
        frame.add(this.but4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);


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
                    System.out.println(viewM.getInfo());
                    }

                else {
                    T.cancel();

                }
            }
        };
        T.scheduleAtFixedRate(TT, 3050, 1000);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton o = (JButton)e.getSource(); //the button that was clicked name
        String name = o.getName();
        switch (name){
            case "1":
                this.nc.click(1);
                break;
            case "2":
                this.nc.click(2);
                break;
            case "3":
                this.nc.click(3);
                break;
            case "4":
                this.nc.click(4);
                break;
        }
//        this.but1.setVisible(false);
//        this.but2.setVisible(false);
//        this.but3.setVisible(false);
//        this.but4.setVisible(false);
    }
}
