package com.example.evadefromdarkov;

public class Tool extends Item{
    int stat;

    public Tool(String name, String description, int stat) {
        super(name, description);
        this.stat = stat;
    }

    public int getStat() {
        return stat;
    }

    public void changeStat(int stat) {
        this.stat += stat;
    }
}
