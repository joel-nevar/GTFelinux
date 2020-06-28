package org.academiadecodigo.felinux.gtfo.characters;

import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character extends Picture{

    private int lives;
    private int damage;
    private  int speed;
    private String message;
    protected static final Field field = new Field();



    //resolver
    public void interact(Character char1) {
        System.out.println(char1.getMessage());
    }


   public String getMessage() {
        return message;
    }

    public void takeLethalDamage() {
        this.lives--;
    }

    public int getLives() {
        return this.lives;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
