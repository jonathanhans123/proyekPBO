package stack.Map;

import java.util.Random;

public class Room {
    private int[][] typeRoom = new int[10][7];
    private int[][] roomData = new int[10][7];
    private int enemyAmount;
    Random rand = new Random();

    public int getEnemyAmount() {
        return enemyAmount;
    }

    public void setEnemyAmount(int enemyAmount) {
        this.enemyAmount = enemyAmount;
    }

    public int[][] getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(int[][] typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int[][] getRoomData() {
        return roomData;
    }

    public void setRoomData(int[][] roomData) {
        this.roomData = roomData;
    }

    public Room() {
    }

    //1 shop
    //2 portal
    //5-10 map

    public Room(int typeroom) {
        enemyAmount = 3;
        if (typeroom == 1) {
            typeRoom = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}};
        } else if (typeroom == 2) {
            typeRoom = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}};
        } else if (typeroom == 3) {
            typeRoom = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}};
        } else if (typeroom == 4) {
            typeRoom = new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}};
        } else if (typeroom == 5) {
            typeRoom = new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}};
        } else if (typeroom == 6) {
            typeRoom = new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}};
        } else if (typeroom == 7) {
            typeRoom = new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        } else if (typeroom == 8) {
            typeRoom = new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        } else if (typeroom == 9) {
            typeRoom = new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        } else if (typeroom == 10){
            typeRoom = new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        } else if (typeroom == 11){
            typeRoom = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}};
        }
    }

    public void summonLayout(int room){
        if (room==1){//shop
            setEnemyAmount(0);
            setRoomData(new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}});
        }else if (room==2){//portal
            setRoomData(new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}});
        }else if (room==5){
            setRoomData(new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                    {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                                    {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}});
        }else if (room==6){
            setRoomData(new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                                    {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                                    {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}});
        }else if (room==7){
            setRoomData(new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}});
        }else if (room==8){
            setRoomData(new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}});
        }else if (room==9){
            setRoomData(new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                    {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}});
        }else if (room==10){
            setRoomData(new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                                    {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}});
        }else if (room==11){//starting wizrd
            setRoomData(new int[][]{{1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 4, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1}});
        }
    }
}
