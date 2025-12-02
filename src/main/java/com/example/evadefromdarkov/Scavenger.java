package com.example.evadefromdarkov;

import java.util.ArrayList;

public class Scavenger extends Enemy {
    private ArrayList<Item> items;

    public Scavenger(String description,Room room,int health,int damage,ArrayList<Item> items)
    {
        super(description,room,health,damage);
        this.items = items;
    }

    public void dropItems()
    {
        Item rocks = new Item("scavenger's-rocks","a key hangs from the pocket of the corpse");
        Item key = new Item("key","a key hangs from the pocket of the corpse");
        getCurrentRoom().getItems().addLast(rocks);
        getCurrentRoom().getItems().addLast(key);
    }
}