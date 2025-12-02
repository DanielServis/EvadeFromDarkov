package com.example.evadefromdarkov;

import javafx.application.Application;

public class Launcher
{
    public static EFDGame game;

    public static void main(String[] args) {
        game = new EFDGame();
        Application.launch(GameGui.class, args);
    }
}