package com.example.evadefromdarkov;

@SuppressWarnings("")
public enum GameState
{
    Fighting(true), Talking(false), Using(false), Dropping(false), MapLook(false), Dead(false), Escaped(false);

    boolean state = false;

    GameState (boolean state){
        this.state = state;
    }
}