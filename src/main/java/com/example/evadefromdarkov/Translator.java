package com.example.evadefromdarkov;

import java.util.ArrayList;

import static com.example.evadefromdarkov.Launcher.game;

public class Translator {
    public static void combatCheck() {
        game.combatCheck();
    }

    public static int getCurrentEnemyNumber(){
        return game.getCurrentEnemyNumber();
    }

    public static boolean escaped(){
        return game.escaped();
    }

    public static void processCommand(String command) {
        game.processCommand(command);
    }

    public static int getPlayerHealth(){
        return game.getPlayerHealth();
    }

    public static ArrayList<String> getInventory(){
        return game.getInventory();
    }

    public static Room[][]  getMap() {
        return game.getMap();
    }

    public static ArrayList<String> getOutput() {
        return game.getOutput();
    }
}
