package com.example.evadefromdarkov;

import java.util.ArrayList;

public class DangerRoom extends Room {
    int damage;

    public DangerRoom(int roomNumber, String description, int damage) {
        super(roomNumber, description);
        this.damage = damage;
    }

    public DangerRoom(int roomNumber, String description, int damage, ArrayList<Item> items) {
        super(roomNumber, description, items);
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
