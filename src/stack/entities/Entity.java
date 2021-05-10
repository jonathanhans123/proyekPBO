package stack.entities;

import javax.swing.*;
import java.awt.*;

public class Entity extends Rectangle {
    ImageIcon rightplayer = new ImageIcon(getClass().getResource("/resources/walkright.gif"));
    ImageIcon downplayer = new ImageIcon(getClass().getResource("/resources/walkdown1.gif"));
    ImageIcon leftplayer = new ImageIcon(getClass().getResource("/resources/walkleft.gif"));
    ImageIcon upplayer = new ImageIcon(getClass().getResource("/resources/walkup.gif"));
    protected boolean up,down,left,right=true;
    public int lastpressed;
    private int dx,dy;

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public Entity(int x, int y, int width, int height, int dx, int dy) {
        setBounds(x,y,width,height);
        this.dx = dx;
        this.dy = dy;
    }

    public void tick(){
        this.x += dx;
        this.y += dy;
    }

    public void draw(Graphics g){
        if (right) {
            g.drawImage(rightplayer.getImage(), this.x, this.y, this.width, this.width, null);
        }else if (left) {
            g.drawImage(leftplayer.getImage(), this.x, this.y, this.width, this.width, null);
        }else if (up){
            g.drawImage(upplayer.getImage(), this.x, this.y, this.width, this.width, null);
        }else if (down){
            g.drawImage(downplayer.getImage(), this.x, this.y, this.width, this.width, null);
        }else if (lastpressed==65){
            g.drawImage(leftplayer.getImage(), this.x, this.y, this.width, this.width, null);
        }


    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
