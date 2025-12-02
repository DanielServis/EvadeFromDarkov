package com.example.evadefromdarkov;

import java.io.*;
import java.util.ArrayList;

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static int saveIncrement;
    private String name;
    private int health;
    private ArrayList<Item> inventory;
    private Room currentRoom;
    private Room heaven;

    public Player(String name, Room startingRoom, ArrayList<Item> inventory) {
        this.name = name;
        this.currentRoom = startingRoom;
        this.inventory = inventory;
        health = 100;
    }

    public String getName() {
        return name;
    }

    public void changeHealth(int change) {
        health += change;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You moved to: " + currentRoom.getDescription());
        } else {
            System.out.println("You can't go that way!");
        }
    }
}
