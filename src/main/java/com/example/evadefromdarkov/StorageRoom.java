package com.example.evadefromdarkov;

import java.util.ArrayList;

public class StorageRoom <T extends Enemy> extends Room{
    ArrayList<T> storageList = new ArrayList<T>();

    public StorageRoom(int roomNumber, String description, ArrayList<Item> items) {
        super(roomNumber, description, items);
    }

    public void addEnemy(T enemy){
        storageList.add(enemy);
    }

    public T getEnemy(){
        return storageList.getFirst();
    }

    public void removeEnemy(T enemy){
        storageList.remove(enemy);
    }
}