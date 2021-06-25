package stack;

import stack.Map.Stage;
import stack.Map.Tile;
import stack.Panels.ShopMenu;
import stack.Panels.StartMenu;
import stack.entities.Enemy;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.*;

public class Screen extends JPanel implements ActionListener, KeyListener,Cloneable {
    public Integer stagecount=1;
    public Timer t = new Timer(10,this);
    public Random rand = new Random();
    public Stage stage = new Stage();
    public ArrayList<Enemy> enemies = new ArrayList<>();
    public ArrayList<Tile> tiles = new ArrayList<>();
    public Integer clock;

    public void emptyMap(){
        while(!tiles.isEmpty()){
            tiles.remove(0);
        }
    }

    public void printMap(){
        for (int y=0;y<7;y++){
            for (int x=0;x<10;x++){
                if (x==0||x==9||y==0||y==6) {
                    if (stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getTypeRoom()[y][x] == 1) {
                        tiles.add(new Tile(true, x * 100, y * 100, 1));
                    } else if (stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getTypeRoom()[y][x] == 0) {
                        tiles.add(new Tile(false, x * 100, y * 100, 0));
                    }
                }else {
                    if (stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getRoomData()[y][x] == 1) {
                        tiles.add(new Tile(true, x * 100, y * 100, 1));
                    } else if (stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getRoomData()[y][x] == 0) {
                        tiles.add(new Tile(false, x * 100, y * 100, 0));
                    } else if (stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getRoomData()[y][x] == 2) {
                        tiles.add(new Tile(false, x * 100, y * 100, 2));
                    } else if (stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getRoomData()[y][x] == 3) {
                        tiles.add(new Tile(false, x * 100, y * 100, 3));
                    }else if (stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getRoomData()[y][x] == 4) {
                        tiles.add(new Tile(false, x * 100, y * 100, 4));
                    }else if (stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getRoomData()[y][x] == 5) {
                        tiles.add(new Tile(false, x * 100, y * 100, 5));
                    }
                }
            }
        }
    }

    public void addEnemy(){

        while (!enemies.isEmpty()){
            enemies.remove(0);
        }
        if (stagecount==1) {
            for (int x = 0; x < stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getEnemyAmount(); x++) {
                enemies.add(new Enemy(rand.nextInt(600) + 200, rand.nextInt(500) + 100, 100, 100, 0, 0, 1));
            }
        }else if (stagecount>1&&stagecount<5){
            for (int x = 0; x < stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getEnemyAmount(); x++) {
                int randenemy = rand.nextInt(3)+2;
                enemies.add(new Enemy(rand.nextInt(600) + 200, rand.nextInt(500) + 100, 100, 100, 0, 0, randenemy));
            }
        }else {
            for (int x = 0; x < stage.rooms.get(stage.getRoomx() + (stage.getRoomy() * 3)).getEnemyAmount(); x++) {
                int randenemy = rand.nextInt(3)+2;
                enemies.add(new Enemy(rand.nextInt(600) + 200, rand.nextInt(500) + 100, 300, 300, 0, 0, 5));
            }
        }
    }

    Thread thread6 = new Thread(new Runnable() {
        @Override
        public void run() {
            Main.timer1.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    clock++;
                    Main.p.setTime(clock);
                    if (stagecount==5){
                        Main.music3.stop();
                        Main.music4.play();
                        Main.music4.loop();
                    }else {
                        Main.music4.stop();
                        Main.music3.play();
                        Main.music3.loop();
                    }
                }
            },1000,1000);
        }
    });

    public Screen(){
        addKeyListener(this);
        setFocusable(true);
        emptyMap();
        printMap();
        addEnemy();

        stagecount = Main.p.getStage();
        clock = Main.p.getTime();
        thread1.start();
        thread2.start();
        thread3.start();
        thread5.start();
        thread6.start();
        thread4.start();
        t.start();
    }

    Thread thread5 = new Thread(new Runnable() {
        @Override
        public void run() {
            Main.timer1.scheduleAtFixedRate(task5,1000,20);
        }
    });

    TimerTask task5 = new TimerTask() {
        @Override
        public void run() {
            if(Main.p.getX()<=0){
                Main.p.setLocation(900,(int) Main.p.getY() );
                stage.setRoomx(stage.getRoomx()-1);
                emptyMap();
                printMap();
                addEnemy();
            }else if (Main.p.getX()>=900){
                Main.p.setLocation(0,(int) Main.p.getY() );
                stage.setRoomx(stage.getRoomx()+1);
                emptyMap();
                printMap();
                addEnemy();
            }else if (Main.p.getY()<=0){
                Main.p.setLocation((int) Main.p.getX(),600 );
                stage.setRoomy(stage.getRoomy()-1);
                emptyMap();
                printMap();
                addEnemy();
            }else if (Main.p.getY()>=600){
                Main.p.setLocation((int) Main.p.getX(),0 );
                stage.setRoomy(stage.getRoomy()+1);
                emptyMap();
                printMap();
                addEnemy();
            }
        }
    };

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            Main.timer1.scheduleAtFixedRate(task1,1000,700);
        }
    });

    TimerTask task3 = new TimerTask() {
        @Override
        public void run() {
            Main.p.setHealth(Main.p.getHealth()+Main.p.getHealthregen());
            if (Main.p.getHealth()>Main.p.getMaxhealth()){
                Main.p.setHealth(Main.p.getMaxhealth());
            }
            if (Main.p.getHealth()<0){
                Main.music2.stop();
                Main.music3.stop();
                Main.music4.stop();
                Main.timer1.cancel();
                Main.frame.setContentPane(new StartMenu().getPanel1());
                Main.frame.setVisible(true);
                setFocusable(false);
                setVisible(false);
                Main.music2.stop();
                JOptionPane.showMessageDialog(null, "You lost!");
                Main.music2.stop();
            }else if (Main.p.getStage()==5&&stage.rooms.get(1).getEnemyAmount()==0){
                Main.music2.stop();
                Main.music3.stop();
                Main.music4.stop();
                Main.timer1.cancel();
                Main.leaderboards.add(new Leaderboard(Main.p.getName(),Main.p.getTime()));
                Main.resetPlayer();
                Main.loadLeaderboards();
                Main.frame.setContentPane(new StartMenu().getPanel1());
                Main.frame.setVisible(true);
                setFocusable(false);
                setVisible(false);
                Main.music2.stop();
                JOptionPane.showMessageDialog(null, "You won the GAME !!!");
                Main.music2.stop();
            }
        }
    };

    Thread thread3 = new Thread(() -> Main.timer1.scheduleAtFixedRate(task3,1000,1000));

    TimerTask task1 = new TimerTask() {
        @Override
        public void run() {
            checkAttack();

        }
    };
    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            Main.timer1.scheduleAtFixedRate(task2,1000,1000);
        }
    });

    TimerTask task2 = new TimerTask() {
        @Override
        public void run() {
            enemyAttack();
        }
    };

    public void enemyAttack(){
        for (int x=0;x<enemies.size();x++){
            if (enemies.get(x).getBounds().intersects(Main.p.getBounds())){
                Main.p.setHealth(Main.p.getHealth()-enemies.get(x).getAttack());
            }
        }
    }

    public void pause(){
        t.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.p.tick();

        for (int x = 0; x < enemies.size(); x++) {
            enemies.get(x).tick();
        }

        for (int x = 0; x < enemies.size(); x++) {
            enemies.get(x).enemymovement();
        }

        repaint();
    }

    public void paint(Graphics g){
        g.clearRect(0,0 ,getWidth(),getHeight());
        for (int x=0;x<tiles.size();x++){
            tiles.get(x).draw(g);
        }
        Main.p.draw(g);
        for (int x=0;x<enemies.size();x++){
            enemies.get(x).draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Main.p.setDown(false);
        Main.p.setUp(false);
        Main.p.setLeft(false);
        Main.p.setRight(false);
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
                Main.p.lastpressed = e.getKeyCode();
                Main.p.setDx(-5);
                Main.p.setLeft(true);
                break;
            case KeyEvent.VK_S:
                Main.p.lastpressed = e.getKeyCode();
                Main.p.setDy(5);
                Main.p.setDown(true);
                break;
            case KeyEvent.VK_W:
                Main.p.lastpressed = e.getKeyCode();
                Main.p.setDy(-5);
                Main.p.setUp(true);
                break;
            case KeyEvent.VK_D:
                Main.p.lastpressed = e.getKeyCode();
                Main.p.setDx(5);
                Main.p.setRight(true);
                break;
            case KeyEvent.VK_0:
                addEnemy();
                break;
            case KeyEvent.VK_M:
                Main.p.setAttack(true);
                Main.music2.play();
                Main.music2.loop();
                break;

        }
    }

    TimerTask task4 = new TimerTask() {
        @Override
        public void run() {
            intersect();
        }
    };

    Thread thread4 = new Thread(new Runnable() {
        @Override
        public void run() {
            Main.timer1.scheduleAtFixedRate(task4,1000,10);
        }
    });

    public void intersect(){
        Rectangle r3 = Main.p.getBounds();

        for (int x=0;x<tiles.size();x++){
            Rectangle r4 = new Rectangle();
            if (tiles.get(x).isWall()){
                r4 = tiles.get(x).getBounds();
            }
            if (r3.intersects(r4)){
                if (Main.p.lastpressed==65){
                    Main.p.setLocation((int) Main.p.getX()+5,(int) Main.p.getY());
                    Main.p.setDx(0);
                    Main.p.setDy(0);
                }else if (Main.p.lastpressed==68){
                    Main.p.setLocation((int) Main.p.getX()-5,(int) Main.p.getY());
                    Main.p.setDx(0);
                    Main.p.setDy(0);
                }else if (Main.p.lastpressed==87){
                    Main.p.setLocation((int) Main.p.getX(),(int) Main.p.getY()+5);
                    Main.p.setDx(0);
                    Main.p.setDy(0);
                }else if (Main.p.lastpressed==83){
                    Main.p.setLocation((int) Main.p.getX(),(int) Main.p.getY()-5);
                    Main.p.setDx(0);
                    Main.p.setDy(0);
                }
            }

            Rectangle r5 = new Rectangle();
            if (tiles.get(x).getId()==2){
                r5 = tiles.get(x).getBounds();
            }
            if (r3.intersects(r5)){
                stagecount++;
                Main.p.setLocation(500,300);
                Main.p.setStage(stagecount);
                stage = new Stage();
                emptyMap();
                printMap();
                addEnemy();
            }

        }
    }



    public void checkAttack(){

        if (Main.p.isAttack()){
            Rectangle r3 = Main.p.getBounds();

            if (Main.p.isUp()) {
                r3.setBounds((int) Main.p.getX(), (int) Main.p.getY() - 100, 100, 100);
            } else if (Main.p.isDown()) {
                r3.setBounds((int) Main.p.getX(), (int) Main.p.getY() + 100, 100, 100);
            } else if (Main.p.isLeft()) {
                r3.setBounds((int) Main.p.getX() - 100, (int) Main.p.getY(), 100, 100);
            } else if (Main.p.isRight()) {
                r3.setBounds((int) Main.p.getX() + 100, (int) Main.p.getY(), 100, 100);
            }

            for (int x = 0; x < enemies.size(); x++) {
                if (enemies.get(x).getBounds().intersects(Main.p.getBounds())) {
                    enemies.get(x).setHealth(enemies.get(x).getHealth() - Main.p.getDamage());
                    if (Main.p.lastpressed==87) {
                        enemies.get(x).setLocation((int) enemies.get(x).getX(),(int) enemies.get(x).getY()-(rand.nextInt(50)+50));
                    } else if (Main.p.lastpressed==83) {
                        enemies.get(x).setLocation((int) enemies.get(x).getX(),(int) enemies.get(x).getY()+(rand.nextInt(50)+50));
                    } else if (Main.p.lastpressed==65) {
                        enemies.get(x).setLocation((int) enemies.get(x).getX()-(rand.nextInt(50)+50),(int) enemies.get(x).getY());
                    } else if (Main.p.lastpressed==68) {
                        enemies.get(x).setLocation((int) enemies.get(x).getX()+(rand.nextInt(50)+50),(int) enemies.get(x).getY());
                    }
                    if (enemies.get(x).getHealth() <= 0) {
                        enemies.remove(x);
                        stage.rooms.get(stage.getRoomx()+(stage.getRoomy()*3)).setEnemyAmount(stage.rooms.get(stage.getRoomx()+(stage.getRoomy()*3)).getEnemyAmount()-1);
                        Main.p.setCoins(Main.p.getCoins()+20);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.p.setDx(0);
        Main.p.setDy(0);
        if (e.getKeyCode()==KeyEvent.VK_D){
            Main.p.setRight(true);
            Main.p.setLeft(false);
            Main.p.setUp(false);
            Main.p.setDown(false);
        }else if (e.getKeyCode()==KeyEvent.VK_W){
            Main.p.setLeft(false);
            Main.p.setRight(false);
            Main.p.setUp(true);
            Main.p.setDown(false);
        }else if (e.getKeyCode()==KeyEvent.VK_A) {
            Main.p.setLeft(true);
            Main.p.setRight(false);
            Main.p.setUp(false);
            Main.p.setDown(false);
        }else if (e.getKeyCode()==KeyEvent.VK_S) {
            Main.p.setLeft(false);
            Main.p.setRight(false);
            Main.p.setUp(false);
            Main.p.setDown(true);
        }else if (e.getKeyCode()==KeyEvent.VK_M){
            Main.p.setAttack(false);
            Main.music2.stop();
        }else if (e.getKeyCode()==KeyEvent.VK_O){
            for (int x=0;x<tiles.size();x++){
                if (tiles.get(x).getId()==3){
                    Rectangle r3 = tiles.get(x).getBounds();
                    if (r3.intersects(Main.p.getBounds())){
                        shopMenu();
                    }
                }
            }
            for (int x=0;x<tiles.size();x++){
                if (tiles.get(x).getId()==4){
                    Rectangle r3 = tiles.get(x).getBounds();
                    if (r3.intersects(Main.p.getBounds())&&stagecount==1){
                        JOptionPane.showMessageDialog(null,"<HTML>Hero! you need to save this kingdom from peril!<BR>" +
                                " There is a DEMON LORD at stage 5 of this dungeon.<BR>" +
                                " To defeat him, you need to defeat enemies and<BR>" +
                                " collect coins to buy upgrades.<BR>" +
                                " Find the portal to go next next level.</HTML>");
                    }if (r3.intersects(Main.p.getBounds())&&stagecount==5){
                        JOptionPane.showMessageDialog(null,"Congratulations! You have made it this far, the DEMON LORD is just in the next room!");
                    }
                }
            }
        }
    }

    public void shopMenu(){

        JFrame frame = new JFrame("Shop");
        frame.setContentPane(new ShopMenu().getPanel1());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500,500);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                t.start();
            }
        });

        frame.setVisible(true);
    }
}
