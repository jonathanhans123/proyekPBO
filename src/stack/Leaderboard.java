package stack;

import java.util.Comparator;

public class Leaderboard implements Comparable {
    private String name;
    private int time;

    public Leaderboard(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public int compareTo(Object o) {
        Leaderboard temp = (Leaderboard) o;
        if (temp.getTime()<this.getTime()){
            return 1;
        }else if(temp.getTime()>this.getTime()) {
            return -1;
        }
        return 0;
    }
}
