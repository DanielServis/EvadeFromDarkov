package com.example.evadefromdarkov;

import java.io.Serializable;

class GameSaver implements Serializable {
    Room[][] tilesLayout;
    Player player;
    Dog dog;
    Trader trader;
    Scavenger scavenger1;
    Scavenger scavenger2;
    Creature creature;
}