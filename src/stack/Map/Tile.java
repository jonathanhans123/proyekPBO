package stack.Map;

import javax.swing.*;
import java.awt.*;

public class Tile extends Rectangle {
    private boolean wall;
    private int id;
    ImageIcon portal = new ImageIcon(getClass().getResource("/resources/portal.gif"));

    public Tile(boolean wall,int posx,int posy,int id){
        super(posx,posy,100,100);
        this.wall = wall;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }


    public void draw(Graphics g){
        if (getId()==0){
            g.drawImage(new ImageIcon(getClass().getResource("/resources/floor2.jpg")).getImage(),(int) getX(),(int) getY(),null,null);
        }else if (getId()==1) {
            g.drawImage(new ImageIcon(getClass().getResource("/resources/wall2.jpg")).getImage(),(int) getX(),(int) getY(),null,null);
        }else if (getId()==2){
            g.drawImage(portal.getImage(),(int) getX(),(int) getY(),null,null);
        }else if (getId()==3){
            g.drawImage(new ImageIcon(getClass().getResource("/resources/floor2.jpg")).getImage(),(int) getX(),(int) getY(),null,null);
            g.drawImage(new ImageIcon(getClass().getResource("/resources/shop.png")).getImage(),(int) getX(),(int) getY(),null,null);
        }else if (getId()==4){
            g.drawImage(new ImageIcon(getClass().getResource("/resources/floor2.jpg")).getImage(),(int) getX(),(int) getY(),null,null);
            g.drawImage(new ImageIcon(getClass().getResource("/resources/wizard1.gif")).getImage(),(int) getX(),(int) getY(),null,null);
        }else if (getId()==5){
            g.drawImage(new ImageIcon(getClass().getResource("/resources/floor2.jpg")).getImage(),(int) getX(),(int) getY(),null,null);
            g.drawImage(new ImageIcon(getClass().getResource("/resources/GoldChest.gif")).getImage(),(int) getX(),(int) getY(),null,null);
        }
    }
}
