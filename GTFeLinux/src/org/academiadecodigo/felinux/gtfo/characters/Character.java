package org.academiadecodigo.felinux.gtfo.characters;



public abstract class Character {

    private int lives;
    private int damage;
    private  int speed;
    private Position position;
    private SpriteType image;


    public void takeDamage() {
        this.lives--;
    }

    public int getLives() {
        return lives;
    }

    public Position getPosition() {
        return position;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
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
