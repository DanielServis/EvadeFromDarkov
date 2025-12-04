package com.example.evadefromdarkov;

import java.io.Serializable;

public class Creature extends Enemy
{
    private boolean released;
    private int cooldown = 2;

    public Creature(String description, Room room, int health, int damage){
        super(description,room,health,damage);
        this.released = false;
    }

    public void move(Room room){
        cooldown--;
        if (cooldown <= 0){
            this.currentRoom = room;
            cooldown = 5;
        }
        System.out.println(cooldown);
    }

    public boolean getReleased(){
        return released;
    }

    public void setReleased(boolean released){
        this.released = released;
    }

    public void dropItems(){

    }
}