package stack.Panels;

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
    private JButton a10DMG50CoinsButton;
    private JButton a5HP50CoinsButton;
    private JLabel playerhealth;
    private JLabel playercoins;
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


    public ShopMenu() {
        thread1.start();
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
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
