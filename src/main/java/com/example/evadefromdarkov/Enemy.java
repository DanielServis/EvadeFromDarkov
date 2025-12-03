package com.example.evadefromdarkov;

import java.io.Serial;
import java.io.Serializable;

public abstract class Enemy implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    protected String description;
    protected int health;
    protected int damage;
    protected Room currentRoom;

    public Enemy(String description,Room room,int health,int damage){;
        this.description = description;
        this.currentRoom = room;
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
