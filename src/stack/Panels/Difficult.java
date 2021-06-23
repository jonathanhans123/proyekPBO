package stack.Panels;

import stack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficult {
    private JButton EASYButton;
    private JButton MEDIUMButton;
    private JButton HARDButton;
    private JButton cancelButton;
    private JButton OKButton;
    private JPanel difficult;

    JFrame frame = new JFrame("Difficult");

    public JPanel getPanel1() {
        return difficult;
    }

    public Difficult() {
        EASYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int difficult = JOptionPane.showConfirmDialog(null, "you choose easy difficult");
                difficult = 1;
            }
        });
        MEDIUMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int difficult = JOptionPane.showConfirmDialog(null, "you choose medium difficult");
                difficult = 2;
            }
        });
        HARDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int difficult = JOptionPane.showConfirmDialog(null, "you choose hard difficult");
                difficult = 3;
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Difficult");
        frame.setContentPane(new Difficult().difficult);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
