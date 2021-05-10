package stack;

import stack.Panels.StartMenu;
import stack.entities.Player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static Player p = null;
    public static ArrayList<Leaderboard> leaderboards = new ArrayList<>();
    public static Player ptemp = null;
    public static ArrayList<String> psave = new ArrayList<>();
    public static Timer timer1;
    public static Timer timersong;
    public static Music music1 = new Music();
    public static Music music2 = new Music();
    public static Music music3 = new Music();
    public static Music music4 = new Music();


    public static void saveLeaderboards(){
        try {
            FileWriter myWriter = new FileWriter("leaderboard.txt");
            for (int x=0;x<leaderboards.size();x++) {
                myWriter.write(leaderboards.get(x).getName()+" "+leaderboards.get(x).getTime());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void savePlayer(){
        try {
            FileWriter myWriter = new FileWriter("player.txt");
            myWriter.write(Main.p.getName()+" "+Main.p.getMaxhealth()+" "+Main.p.getDamage()+" "+Main.p.getHealthregen()+" "+Main.p.getStage()+" "+Main.p.getTime());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void resetPlayer(){
        try {
            FileWriter myWriter = new FileWriter("player.txt");
            myWriter.write("");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void loadLeaderboards(){
        try {
            File myObj = new File("leaderboard.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("")){

                }else {
                    String[] temp = data.split(" ");
                    leaderboards.add(new Leaderboard(temp[0], Integer.parseInt(temp[1])));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void loadplayer(){
        try {
            File myObj = new File("player.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("")){

                }else {
                    String[] temp = data.split(" ");
                    psave = new ArrayList<>();
                    psave.add(temp[0]);
                    psave.add(temp[1]);
                    psave.add(temp[2]);
                    psave.add(temp[3]);
                    psave.add(temp[4]);
                    psave.add(temp[5]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static JFrame frame = new JFrame("StartMenu");
    public static void main(String[] args) {
	// write your code here
        timer1 = new Timer();
        timersong = new Timer();
        loadLeaderboards();

        Main.leaderboards.sort(Leaderboard::compareTo);
        for (int x=0;x< leaderboards.size();x++){
            System.out.println("1"+leaderboards.get(x).getName());
        }

        frame.setContentPane(new StartMenu().getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);



//        frame.setContentPane(new Frames().getMainpanel());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true );
    }
}
