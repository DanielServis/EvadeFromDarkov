package com.example.evadefromdarkov;

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

    public void dropItems() {

    }
}