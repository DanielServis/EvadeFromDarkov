package com.example.evadefromdarkov;

import java.io.Serializable;

public abstract class Enemy implements Serializable
{
    protected String description;
    protected int health;
    protected int damage;
    protected int currentRoomNumber;
    transient protected Room currentRoom;

    public Enemy(String description,Room room,int health,int damage){;
        this.description = description;
        this.currentRoom = room;
        this.currentRoomNumber = room.getRoomNumber();
        this.health = health;
        this.damage = damage;
    }

    public String getDescription()
    {
        return description;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getCurrentRoomNumber(){
        return currentRoomNumber;
    }

    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
        this.currentRoomNumber = newRoom.getRoomNumber();
    }

    public int getHealth(){
        return health;
    };

    public void changeHealth(int healthChange){
        this.health += healthChange;
    }

    public int getDamage(){
        return damage;
    }

    public abstract void dropItems();
}
