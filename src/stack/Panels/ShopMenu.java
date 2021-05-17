package stack.Panels;

import stack.Leaderboard;
import stack.Main;
import stack.Screen;
import stack.entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class ShopMenu extends JPanel{
    private JPanel panel1;
    private JButton button1;
    private JButton OkButton;
    private JButton a10DMG50CoinsButton;
    private JButton a5HP50CoinsButton;
    private JLabel playerhealth;
    private JLabel playercoins;
    private JComboBox comboBox;
    private JButton okButton;
    Timer t = new Timer();

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            t.scheduleAtFixedRate(task1,0,100);
        }
    });

    TimerTask task1 = new TimerTask() {
        @Override
        public void run() {
            playercoins.setText(String.valueOf(Main.p.getCoins()));
        }
    };

    public static void main(String[] args) {
        Main.p = new Player(200, 200, 80, 80, 0, 0, "",1);

        JFrame frame = new JFrame("ShopMenu");
        frame.setContentPane(new ShopMenu().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ShopMenu() {

        comboBox.addItem("Silver Sword");
        comboBox.addItem("Gold Sword");
        comboBox.addItem("Diamond Sword");

        thread1.start();

        Main.p.setCoins(10000);

        playercoins.setText(String.valueOf(Main.p.getCoins()));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Main.p.getCoins()>=50) {
                    Main.p.setMaxhealth(Main.p.getMaxhealth()+40);
                    Main.p.setCoins(Main.p.getCoins() - 50);
                    JOptionPane.showMessageDialog(button1,"You have purchased +40Max Hp");
                }else {
                    JOptionPane.showMessageDialog(button1,"You dont have enough money :(");
                }

            }
        });
        a5HP50CoinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.p.getCoins()>=50) {
                    Main.p.setHealthregen(Main.p.getHealthregen()+10);
                    Main.p.setCoins(Main.p.getCoins() - 50);
                    JOptionPane.showMessageDialog(button1,"You have purchased +10Regen");
                }else {
                    JOptionPane.showMessageDialog(button1,"You dont have enough money :(");
                }
            }
        });
        a10DMG50CoinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.p.getCoins()>=50) {
                    Main.p.setDamage(Main.p.getDamage()+20);
                    Main.p.setCoins(Main.p.getCoins() - 50);
                    JOptionPane.showMessageDialog(button1,"You have purchased +20 Dmg");
                }else {
                    JOptionPane.showMessageDialog(button1,"You dont have enough money :(");
                }
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String terpilih = comboBox.getSelectedItem().toString();
                if(Main.p.getCoins()>=100&&terpilih.equalsIgnoreCase("Silver Sword")){
                    Main.p.setCoins(Main.p.getCoins()-100);
                    JOptionPane.showMessageDialog(null, terpilih);
                    Main.p.setTipe(2);
                    Main.p.setDamage(25);
                }else if(Main.p.getCoins()>=150&&terpilih.equalsIgnoreCase("Gold Sword")){
                    Main.p.setCoins(Main.p.getCoins()-150);
                    JOptionPane.showMessageDialog(null, terpilih);
                    Main.p.setTipe(3);
                    Main.p.setDamage(35);
                }else if(Main.p.getCoins()>=200&&terpilih.equalsIgnoreCase("Diamond Sword")){
                    Main.p.setCoins(Main.p.getCoins()-200);
                    JOptionPane.showMessageDialog(null, terpilih);
                    Main.p.setTipe(4);
                    Main.p.setDamage(45);
                }else{
                    JOptionPane.showMessageDialog(button1,"You dont have enough money :(");

                }


            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }


}
