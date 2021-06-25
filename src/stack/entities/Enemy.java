package stack.entities;

import stack.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy extends Entity{
    private int health,attack,id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void enemymovement(){
        Random rand = new Random();
        int randmove = rand.nextInt(2);
        if (randmove==0) {
            if (this.getX() > Main.p.getX()) {
                lastpressed = 0;
                setDx(-3);

            } if (this.getY() < Main.p.getY()) {
                lastpressed = 1;
                setDy(1);

            } if (this.getY() > Main.p.getY()) {
                lastpressed = 2;
                setDy(-1);

            } if (this.getX() < Main.p.getX()) {
                lastpressed = 3;
                setDx(3);

            }
        }else {
            setDx(0);
            setDy(0);
        }
    }



    @Override
    public void draw(Graphics g) {
        if (getId()==1){
            g.drawImage(new ImageIcon(getClass().getResource("/resources/bat.gif")).getImage(), this.x, this.y, 70, 70, null);
        }else if (getId()==2) {
            g.drawImage(new ImageIcon(getClass().getResource("/resources/bat.gif")).getImage(), this.x, this.y, this.width, this.width, null);
        }else if (getId()==3){
            g.drawImage(new ImageIcon(getClass().getResource("/resources/ghost.gif")).getImage(), this.x, this.y, this.width, this.width, null);
        }else if (getId()==4){
            g.drawImage(new ImageIcon(getClass().getResource("/resources/eyemonster.gif")).getImage(), this.x, this.y, this.width, this.width, null);
        }else if (getId()==5){
            g.drawImage(new ImageIcon(getClass().getResource("/resources/ainz ooal gown.gif")).getImage(), this.x, this.y, this.width, this.width, null);

        }
    }

    public Enemy(int x, int y, int width, int height, int dx, int dy,int id) {
        super(x,y,width,height,dx,dy);
        if (id == 5) {
            if (Main.difficult == 1) {
                setHealth(2000);
                setAttack(200);
            } else if (Main.difficult == 2) {
                setHealth(2500);
                setAttack(300);
            } else if (Main.difficult == 3) {
                setHealth(3000);
                setAttack(400);
            }
        }else {
            if (Main.difficult == 1) {
                setHealth((int) (150 * (Math.sqrt(java.lang.Double.valueOf(id)))));
                setAttack((int) (20 * Math.sqrt(java.lang.Double.valueOf(id))));
            } else if (Main.difficult == 2) {
                setHealth((int) (200 * (Math.sqrt(java.lang.Double.valueOf(id)))));
                setAttack((int) (30 * Math.sqrt(java.lang.Double.valueOf(id))));
            } else if (Main.difficult == 3) {
                setHealth((int) (250 * (Math.sqrt(java.lang.Double.valueOf(id)))));
                setAttack((int) (40 * Math.sqrt(java.lang.Double.valueOf(id))));
            }
        }
        setId(id);
    }



}
