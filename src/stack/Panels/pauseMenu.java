package stack.Panels;

import stack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pauseMenu {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel1;

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public pauseMenu() {
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.savePlayer();

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


}
