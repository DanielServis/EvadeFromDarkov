package com.example.evadefromdarkov;

import java.io.Serial;
import java.io.Serializable;

public class Item implements Serializable, ID{
    @Serial
    private static final long serialVersionUID = 1L;
    private String description;
    private String name;
    private String location;
    private int id;
    private boolean isVisible;

    public Item(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.isVisible = true;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
