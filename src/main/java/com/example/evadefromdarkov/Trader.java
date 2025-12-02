package com.example.evadefromdarkov;

import java.util.ArrayList;

public class Trader extends Enemy implements Talkable {
    private ArrayList<Item> inventory;
    private ArrayList<String> dialog = new ArrayList<>();

    public Trader(String name, Room room, int health, int damage) {
        super(name,room,health,damage);
        this.inventory = new ArrayList<>();
    }

    public void dropItems(){
        for(Item item:inventory){
            getCurrentRoom().getItems().addLast(item);
        }
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public ArrayList<String> getDialog(){
        return dialog;
    }
}