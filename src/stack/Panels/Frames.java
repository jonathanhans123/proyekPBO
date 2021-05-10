package stack.Panels;

import stack.Main;
import stack.Screen;

import javax.swing.*;
import java.awt.event.*;
import java.util.TimerTask;

public class Frames {
    private JButton button1;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel mainpanel;
    public Screen screen1;
    private JLabel health;
    private JLabel speed;
    private JLabel damage;
    private JList list1;
    private JLabel healthRegen;
    private JLabel coins;
    private JPanel screenPanel;
    private JLabel stage;
    private JLabel time;
    DefaultListModel listmodel;
    JFrame frame = new JFrame("pauseMenu");





    public JList getList1() {
        return list1;
    }

    public void setList1(JList list1) {
        this.list1 = list1;
    }

    public void setScreen1(Screen screen1) {
        this.screen1 = screen1;
    }

    public Screen getScreen1() {
        return screen1;
    }

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            Main.timer1.scheduleAtFixedRate(task1,700,1000);
        }
    });

    TimerTask task1 = new TimerTask() {
        @Override
        public void run() {
            Integer temp1 = listmodel.getSize();
            for (int x=0;x<temp1;x++){
                    listmodel.remove(0);
            }
            for (int x=0;x<screen1.enemies.size();x++) {
                listmodel.addElement("enemy "+(x+1)+" "+screen1.enemies.get(x).getHealth()+" "+(int) screen1.enemies.get(x).getX()+" "+(int)screen1.enemies.get(x).getY());
            }
            list1.setModel(listmodel);
            health.setText("Health : "+ Main.p.getHealth()+"/"+Main.p.getMaxhealth());
            damage.setText("Damage : " + Main.p.getDamage());
            speed.setText("Speed  : "+ Main.p.getSpeed());
            healthRegen.setText("Regen  : "+Main.p.getHealthregen());
            coins.setText("Coins  : "+Main.p.getCoins());
            stage.setText("STAGE - "+Main.p.getStage());
            if (screen1.clock%60<10) {
                time.setText("TIME " + screen1.clock / 60 + ":0" + screen1.clock % 60);
            }else {
                time.setText("TIME " + screen1.clock / 60 + ":" + screen1.clock % 60);
            }
        }
    };

    public Frames() {


        listmodel = new DefaultListModel();
        thread1.start();
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                screen1.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                screen1.keyReleased(e);
            }
        };

        button1.addKeyListener(listener);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setContentPane(new pauseMenu().getPanel1());
                frame.setDefaultCloseOperation(2);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
                frame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        screen1.pause();
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        screen1.t.start();
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {

                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });

            }
        });

    }

    public JPanel getMainpanel() {
        return mainpanel;
    }



}
