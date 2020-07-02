package org.academiadecodigo.felinux.gtfo.characters;

import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.felinux.gtfo.game.GameHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character implements Moveable{


    private int lives = 5;
    private String message;

    public void interact() {
    }

    public String getMessage() {
        return "Return this string";
    }

    public void takeLethalDamage() {
        this.lives--;
    }

    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Next lvl genius
     * Override this, and call the overloaded method
     * To add, this object to the interactables list
     */
    public void addToInteractables(){

        //just here to be overriden
        //dont delete thx :)
    }

    /**
     * Use this to make an Item interactable
     * @param area this object area
     * @param name the reference to it
     */
    public void addToInteractables(Area area, Character name){

        GameHandler.hashMap.put(area, name);
        System.out.println(area + " " + name);
    }
}
