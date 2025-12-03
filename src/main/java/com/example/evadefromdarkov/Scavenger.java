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

    }
}