package com.example.evadefromdarkov;

import java.io.Serializable;

public class Creature extends Enemy
{
    boolean released;

    public Creature(String description, Room room, int health, int damage){
        super(description,room,health,damage);
        this.released = false;
    }

    public void move(){
        if (released){
            //creature makes a move
        }
    }

    public boolean getReleased(){
        return released;
    }

    public void setReleased(boolean released){
        this.released = released;
    }

    public void dropItems(){
        Item creatureCorpse = new Item("creature's-corpse","the shriveled husk of an overgrown man");
        getCurrentRoom().getItems().add(creatureCorpse);
    }
}