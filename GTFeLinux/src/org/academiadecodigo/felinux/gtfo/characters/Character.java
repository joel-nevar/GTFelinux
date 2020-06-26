package org.academiadecodigo.felinux.gtfo.characters;

import org.academiadecodigo.felinux.gtfo.field.Position;
import org.academiadecodigo.felinux.gtfo.field.SpriteType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character extends Picture implements Position {

    private int lives;
    private int damage;
    private  int speed;
    private Position position;
    private SpriteType image;
    private String message;


    public void interact(Character char1, Character char2) {
        System.out.println(char1.getMessage());
        System.out.println(char2.getMessage());

    }


   public String getMessage() {
        return message;
    }

    public void takeDamage() {
        this.lives--;
    }

    public int getLives() {
        return this.lives;
    }

    public Position getPosition() {
        return this.position;
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
