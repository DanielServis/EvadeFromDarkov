package com.example.evadefromdarkov;

import java.io.Serializable;

public class Dog extends Enemy {
    private boolean tame;

    public Dog(String description, Room room, int health, int damage)
    {
        super(description,room,health,damage);
        this.tame = false;
    }

    public void setTame(boolean tame){
        this.tame = tame;
    }

    public boolean getTame(){
        return tame;
    }

    public void dropItems()
    {
        Item dogCarcass = new Item("dog-carcass","look what you've done, a dead dog");
        getCurrentRoom().getItems().addLast(dogCarcass);
        dogCarcass.setLocation("heaven");
    }
}