package stack.entities;

import javax.swing.*;
import java.awt.*;

public class Player extends Entity implements Cloneable  {
    private int health,damage,speed,healthregen,maxhealth,coins,stage;
    private boolean attack = false;
    private String name;
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealthregen() {
        return healthregen;
    }

    public void setHealthregen(int healthregen) {
        this.healthregen = healthregen;
    }

    public Player(int x, int y, int width, int height, int dx, int dy,String name) {
        super(x,y,width,height,dx,dy);
        setHealth(100);
        setDamage(20);
        setSpeed(3);
        setAttack(false);
        setHealthregen(5);
        setMaxhealth(100);
        setStage(1);
        lastpressed=68;
        setName(name);
        setTime(0);
    }

    public Player(int x, int y, int width, int height, int dx, int dy,String name,int health,int attack,int regen,int stage,int time) {
        super(x,y,width,height,dx,dy);
        setName(name);
        setHealth(health);
        setDamage(attack);
        setSpeed(3);
        setAttack(false);
        setHealthregen(regen);
        setMaxhealth(health);
        setStage(stage);
        setTime(time);
        lastpressed=68;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public void setMaxhealth(int maxhealth) {
        this.maxhealth = maxhealth;
    }

    @Override
    public void draw(Graphics g) {
        if (right) {
            g.drawImage(rightplayer.getImage(), this.x, this.y, this.width, this.height, null);
            if (isAttack()) {
                g.drawImage(new ImageIcon(getClass().getResource("/resources/swordright.gif")).getImage(), (int) getX() + 60, (int) getY(), 100, 100, null);
            }
        } else if (left) {
            g.drawImage(leftplayer.getImage(), this.x, this.y, this.width, this.height, null);
            if (isAttack()) {
                g.drawImage(new ImageIcon(getClass().getResource("/resources/swordleft.gif")).getImage(), (int) getX() - 50, (int) getY(), 100, 100, null);
            }
        } else if (up) {
            if (isAttack()) {
                g.drawImage(new ImageIcon(getClass().getResource("/resources/swordup.gif")).getImage(), (int) getX(), (int) getY() - 50, 100, 100, null);
            }
            g.drawImage(upplayer.getImage(), this.x, this.y, this.width, this.height, null);
        } else if (down) {
            g.drawImage(downplayer.getImage(), this.x, this.y, this.width, this.height, null);
            if (isAttack()) {
                g.drawImage(new ImageIcon(getClass().getResource("/resources/sworddown.gif")).getImage(), (int) getX(), (int) getY() + 60, 100, 100, null);
            }
        } else if (lastpressed==65){
            g.drawImage(leftplayer.getImage(), this.x, this.y, this.width, this.height, null);
            if (isAttack()) {
                g.drawImage(new ImageIcon(getClass().getResource("/resources/swordleft.gif")).getImage(), (int) getX() - 50, (int) getY(), 100, 100, null);
            }
        } else if (lastpressed==68){
            g.drawImage(rightplayer.getImage(), this.x, this.y, this.width, this.height, null);
            if (isAttack()) {
                g.drawImage(new ImageIcon(getClass().getResource("/resources/swordright.gif")).getImage(), (int) getX() + 60, (int) getY(), 100, 100, null);
            }
        } else if (lastpressed==83){
            g.drawImage(downplayer.getImage(), this.x, this.y, this.width, this.height, null);
            if (isAttack()) {
                g.drawImage(new ImageIcon(getClass().getResource("/resources/sworddown.gif")).getImage(), (int) getX(), (int) getY() + 60, 100, 100, null);
            }
        } else if (lastpressed==87){
            if (isAttack()) {
                g.drawImage(new ImageIcon(getClass().getResource("/resources/swordup.gif")).getImage(), (int) getX(), (int) getY() - 50, 100, 100, null);
            }
            g.drawImage(upplayer.getImage(), this.x, this.y, this.width, this.height, null);

        }
    }
}
