package stack.Map;


import stack.Main;
import stack.Map.Room;

import java.util.ArrayList;
import java.util.Random;

public class Stage {
    private int stage;
    public ArrayList<Room> rooms = new ArrayList<>();
    private int roomx,roomy;
    private int[] roomLayout = new int[9];
    Random rand = new Random();



    public int getRoomx() {
        return roomx;
    }

    public void setRoomx(int roomx) {
        this.roomx = roomx;
    }

    public int getRoomy() {
        return roomy;
    }

    public void setRoomy(int roomy) {
        this.roomy = roomy;
    }

    public void nextStage(){
        stage++;
    }

    public Stage (){
        roomx=1;
        roomy=1;
        stage=1;
        if (Main.p.getStage()==5){
            rooms.add(new Room(1));
            rooms.add(new Room(11));
            rooms.add(new Room(3));
            rooms.add(new Room(10));
            rooms.add(new Room(10));
            rooms.add(new Room(6));
            rooms.add(new Room(7));
            rooms.add(new Room(8));
            rooms.add(new Room(9));
        }else {
            rooms.add(new Room(1));
            rooms.add(new Room(2));
            rooms.add(new Room(3));
            rooms.add(new Room(4));
            rooms.add(new Room(5));
            rooms.add(new Room(6));
            rooms.add(new Room(7));
            rooms.add(new Room(8));
            rooms.add(new Room(9));
        }

        roomLayout = new int[]{1, 2, rand.nextInt(6) + 5, rand.nextInt(6) + 5, rand.nextInt(6) + 5, rand.nextInt(6) + 5,
                rand.nextInt(6) + 5, rand.nextInt(6) + 5, rand.nextInt(6) + 5, rand.nextInt(6) + 5};
        for (int x=0;x<9;x++){
            for (int y=0;y<9;y++){
                int rnd = rand.nextInt(9);
                int temp = roomLayout[rnd];
                roomLayout[rnd] = roomLayout[y];
                roomLayout[y] = temp;
            }
        }
        if (Main.p.getStage() == 1){
            System.out.println("yes");
            rooms.get(4).setEnemyAmount(0);
            if (roomLayout[4]==2) {
                roomLayout[0] = 2;
                roomLayout[4] = 11;
            }else {
                roomLayout[4] = 11;
            }
        }
        if (Main.p.getStage() == 5){
            rooms.get(1).setEnemyAmount(1);
            rooms.get(4).setEnemyAmount(0);
            roomLayout[4] = 11;
            roomLayout[1] = rand.nextInt(6)+5;
        }
        for(int x=0;x<9;x++){
            rooms.get(x).summonLayout(roomLayout[x]);
        }



    }
}
