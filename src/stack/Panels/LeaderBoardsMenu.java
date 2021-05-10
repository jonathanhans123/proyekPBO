package stack.Panels;

import stack.Main;

import javax.swing.*;

public class LeaderBoardsMenu {
    private JLabel name1;
    private JLabel name2;
    private JLabel name3;
    private JLabel name4;
    private JLabel name5;
    private JLabel time1;
    private JLabel time2;
    private JLabel time3;
    private JLabel time4;
    private JLabel time5;
    private JPanel panel1;

    public LeaderBoardsMenu() {

        if (Main.leaderboards.size()>=1) {
            name1.setText("1. " + Main.leaderboards.get(0).getName());
        }if (Main.leaderboards.size()>=2) {
            name2.setText("2. " + Main.leaderboards.get(1).getName());
        }if (Main.leaderboards.size()>=3) {
            name3.setText("3. " + Main.leaderboards.get(2).getName());
        }if (Main.leaderboards.size()>=4) {
            name4.setText("4. " + Main.leaderboards.get(3).getName());
        }if (Main.leaderboards.size()>=5) {
            name5.setText("5. " + Main.leaderboards.get(4).getName());
        }
        if (Main.leaderboards.size()>=1) {
            if (Main.leaderboards.get(0).getTime()%60<10) {
                time1.setText(Main.leaderboards.get(0).getTime() / 60 + ":0" + Main.leaderboards.get(0).getTime() % 60);
            }else {
                time1.setText(Main.leaderboards.get(0).getTime() / 60 + ":" + Main.leaderboards.get(0).getTime() % 60);
            }
        }if (Main.leaderboards.size()>=2) {
            if (Main.leaderboards.get(1).getTime()%60<=9) {
                time2.setText(Main.leaderboards.get(1).getTime() / 60 + ":0" + Main.leaderboards.get(1).getTime() % 60);
            }else {
                time2.setText(Main.leaderboards.get(1).getTime() / 60 + ":" + Main.leaderboards.get(1).getTime() % 60);
            }
        }if (Main.leaderboards.size()>=3) {
            if (Main.leaderboards.get(2).getTime()%60<10) {
                time3.setText(Main.leaderboards.get(2).getTime() / 60 + ":0" + Main.leaderboards.get(2).getTime() % 60);
            }else {
                time3.setText(Main.leaderboards.get(2).getTime() / 60 + ":" + Main.leaderboards.get(2).getTime() % 60);
            }
        }if (Main.leaderboards.size()>=4) {
            if (Main.leaderboards.get(3).getTime()%60<10) {
                time4.setText(Main.leaderboards.get(3).getTime() / 60 + ":0" + Main.leaderboards.get(3).getTime() % 60);
            }else {
                time4.setText(Main.leaderboards.get(3).getTime() / 60 + ":" + Main.leaderboards.get(3).getTime() % 60);
            }
        }if (Main.leaderboards.size()>=5) {
            if (Main.leaderboards.get(4).getTime()%60<10) {
                time5.setText(Main.leaderboards.get(4).getTime() / 60 + ":0" + Main.leaderboards.get(4).getTime() % 60);
            }else {
                time5.setText(Main.leaderboards.get(4).getTime() / 60 + ":" + Main.leaderboards.get(4).getTime() % 60);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Leaderboards");
        frame.setContentPane(new LeaderBoardsMenu().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}


