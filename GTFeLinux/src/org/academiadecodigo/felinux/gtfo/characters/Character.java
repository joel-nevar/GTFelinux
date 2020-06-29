package org.academiadecodigo.felinux.gtfo.characters;

import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character extends Picture implements Moveable{

    private int lives;
    private int damage;
    private  int speed;
    private String message;
    protected static final Field field = new Field();

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


    public int getPositionX(){
        return this.getX();
    }

    public int getPositionY(){
        return this.getY();
    }

    @Override
    public void move() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

}
