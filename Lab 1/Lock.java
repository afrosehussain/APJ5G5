/*a Java Swing GUI application for an electronic lock*/
/**********************************************
*Lab session number      : 01
*Type of lab             : In Lab
*Problem No.             : 01
*Programmer              : Afrose
*Date                    : 18/10/2021
*Program name            : Lock.java
*Topics                  : GUI applications using Java Swings
************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lock implements ActionListener {
    JPanel p;
    JPanel p1;
    JPanel p2;
    static String pin = "9999";
    JTextField pinbox = new JTextField(30);
    JButton[] jbtns = new JButton[12];
    String enteredPin = "";

    public Lock() {
        // creation
        JFrame f = new JFrame();
        p = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();

        jbtns[0] = new JButton("1");
        jbtns[1] = new JButton("2");
        jbtns[2] = new JButton("3");
        jbtns[3] = new JButton("4");
        jbtns[4] = new JButton("5");
        jbtns[5] = new JButton("6");
        jbtns[6] = new JButton("7");
        jbtns[7] = new JButton("8");
        jbtns[8] = new JButton("9");
        jbtns[9] = new JButton("CLEAR");
        jbtns[10] = new JButton("0");
        jbtns[11] = new JButton("Enter");

        // configuration
        // frame
        f.setVisible(true);
        f.setSize(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // panel
        p.setBounds(0, 0, 300, 300);
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p1.setLayout(new GridLayout(1, 1));
        p2.setLayout(new GridLayout(4, 3));

        // adding to parent
        // panel to frame
        f.add(p);
        p.add(p1);
        p.add(p2);

        p1.add(pinbox);

        p2.add(jbtns[0]);
        p2.add(jbtns[1]);
        p2.add(jbtns[2]);
        p2.add(jbtns[3]);
        p2.add(jbtns[4]);
        p2.add(jbtns[5]);
        p2.add(jbtns[6]);
        p2.add(jbtns[7]);
        p2.add(jbtns[8]);
        p2.add(jbtns[9]);
        p2.add(jbtns[10]);
        p2.add(jbtns[11]);

        jbtns[0].addActionListener(this);
        jbtns[1].addActionListener(this);
        jbtns[2].addActionListener(this);
        jbtns[3].addActionListener(this);
        jbtns[4].addActionListener(this);
        jbtns[5].addActionListener(this);
        jbtns[6].addActionListener(this);
        jbtns[7].addActionListener(this);
        jbtns[8].addActionListener(this);
        jbtns[9].addActionListener(this);
        jbtns[10].addActionListener(this);
        jbtns[11].addActionListener(this);
    }

    public static void main(String... args) {
        Lock mywindow = new Lock();
    }

    // listening for events
    public void actionPerformed(ActionEvent e) {
        // to add any actions
        String command = e.getActionCommand();
        if (command.equals("CLEAR")) {
            pinbox.setText("");
            enteredPin = "";
        } else if (command.equals("Enter")) {
            if (enteredPin.equals(pin)) {
                pinbox.setText("OPEN");
            } else {
                pinbox.setText("WRONG PIN");
            }
            enteredPin = "";
        } else {
            enteredPin = enteredPin + command;
            pinbox.setText("*".repeat(enteredPin.length()));
        }
    }
}


