package stack.Panels;

import stack.Leaderboard;
import stack.Main;
import stack.Music;
import stack.entities.Player;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.MissingFormatArgumentException;
import java.util.Timer;
import java.util.TimerTask;

public class StartMenu extends JPanel {
    private JButton button1;
    private JPanel panel1;
    private JButton Leaderboards;
    private JButton quitButton;
    private JButton controlsButton;
    JFrame frame = new JFrame("DungeonCrawl");
    Timer t  = new Timer();

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }


    public StartMenu(){
        Main.music1.setFile(getClass().getResource("/resources/mainmusic.wav"));
        Main.music2.setFile(getClass().getResource("/resources/swordhit1.wav"));
        Main.music3.setFile(getClass().getResource("/resources/stagemusic.wav"));
        Main.music4.setFile(getClass().getResource("/resources/bossmusic.wav"));
        thread2.start();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.loadplayer();
                if (Main.psave.size()<4) {
                    String name = JOptionPane.showInputDialog(null, "Enter your name!(wait 5 sec before start");
                    if (name.equalsIgnoreCase("cheat")){
                        Main.p = new Player(200, 200, 80, 80, 0, 0, name,1000,1000,100,1,0,1);
                    }else {
                        Main.p = new Player(200, 200, 80, 80, 0, 0, name,1);
                    }
                    Main.frame.dispose();
                    frame.setContentPane(new Frames().getMainpanel());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setVisible(true);
                }else {
                    int input = JOptionPane.showConfirmDialog(null,"Continue last saved game?(wait 5 sec before start");
                    if (input==0){

                        Main.p = new Player(200,200,80,80,0,0,Main.psave.get(0),
                                Integer.parseInt(Main.psave.get(1)), Integer.parseInt(Main.psave.get(2)),
                                Integer.parseInt(Main.psave.get(3)),Integer.parseInt(Main.psave.get(4)),
                                Integer.parseInt(Main.psave.get(5)),1);
                        Main.frame.dispose();
                        frame.setContentPane(new Frames().getMainpanel());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setResizable(false);
                        frame.setVisible(true );
                    }else if (input==1){
                        Main.resetPlayer();
                        String name = JOptionPane.showInputDialog(null, "Enter your name!(wait 5 sec before start");
                        if (name.equalsIgnoreCase("cheat")){
                            Main.p = new Player(200, 200, 80, 80, 0, 0, name,1000,1000,100,1,0,1);
                        }else {
                            Main.p = new Player(200, 200, 80, 80, 0, 0, name,1);
                        }
                        Main.frame.dispose();
                        frame.setContentPane(new Frames().getMainpanel());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setResizable(false);
                        frame.setVisible(true );
                    }else {

                    }
                }
            }
        });
        controlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "<HTML>WASD to move around<BR>" +
                                "M to attack<BR>" +
                                "O to interact</HTML>");
            }
        });
        Leaderboards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.leaderboards.sort(Leaderboard::compareTo);
                JFrame frame = new JFrame("LeaderBoardsMenu");
                frame.setContentPane(new LeaderBoardsMenu().getPanel1());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        thread1.start();
    }


    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            t.scheduleAtFixedRate(task1,0,100);
        }
    });

    TimerTask task1 = new TimerTask() {
        @Override
        public void run() {
            if (Main.frame.isVisible()){
                frame.dispose();
                Main.p = null;
            }
        }
    };

    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            Main.timersong.scheduleAtFixedRate(task2,100,1000);
        }
    });

    TimerTask task2 = new TimerTask() {
        @Override
        public void run() {
            if(!frame.isVisible()){
                Main.music1.play();
                Main.music1.loop();
            }else {
                Main.music1.stop();
            }
        }
    };


    public static void main(String[] args) {
        JFrame frame = new JFrame("StartMenu");
        frame.setContentPane(new StartMenu().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
