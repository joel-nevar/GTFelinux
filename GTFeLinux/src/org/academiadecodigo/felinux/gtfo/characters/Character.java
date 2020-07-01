package org.academiadecodigo.felinux.gtfo.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character extends Picture implements Moveable{

    private int lives;
    private String message;

    //resolver
    public void interact() {
        //TODO tem de interagir com o leite e prostitutas
        System.out.println("Qualuqercoisa");
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

    @Override
    public void move() {
    }
}
