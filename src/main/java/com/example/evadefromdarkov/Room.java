package com.example.evadefromdarkov;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int roomNumber;
    private String description;
    private ArrayList<Item> items;
    private Map<String, Room> exits; // Map direction to neighboring Room

    public Room(int roomNumber,String description) {
        this.roomNumber = roomNumber;
        this.description = description;
        exits = new HashMap<>();
    }

    public Room(int roomNumber,String description, ArrayList<Item> items) {
        this.roomNumber = roomNumber;
        this.description = description;
        this.items = items;
        exits = new HashMap<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getDamage(){
        return 0;
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getExitString() {
        StringBuilder sb = new StringBuilder();
        for (String direction : exits.keySet()) {
            sb.append(direction).append(" ");
        }
        return sb.toString().trim();
    }

    public String getLongDescription() {
        return "You arrive at " + description + ".\nExits: " + getExitString();
    }
}
