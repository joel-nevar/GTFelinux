package org.academiadecodigo.felinux.gtfo.characters.moveable.player;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.moveable.Moveable;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.felinux.gtfo.game.SpriteType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends Character implements Moveable{

    private Picture player;
    private boolean dead = false;
    private Field playerField;
    private int energy = 100;
    private boolean hasMilk = false;
    private int clawDamage = 1;
    private KeyboardHandler keyboardHandler;


    public Player(Field field) {
        super();
        this.playerField = field;
        this.player = new Picture(50,50,"resources/images/tobias.png");
        this.keyboardHandler = new PlayerKeyboard(this);
    }

    public Picture getPlayer() {
        return player;
    }

    public void moveLeft(){
        if(this.playerField.getPadding()  >= player.getX()){
            return;
        } player.translate(-playerField.getCellSize(),0);
        System.out.println(player.getY());
        System.out.println(player.getX());
    }

    public void moveUp(){
        if(this.playerField.getPadding() >= player.getY()){
            return;
        } player.translate(0,-playerField.getCellSize());
        System.out.println(player.getY());
        System.out.println(player.getX());
    }

    public void moveRight(){
        if(this.playerField.getSizeCol() <= player.getMaxX() - this.playerField.getPadding()){
            return;
        } player.translate(playerField.getCellSize(),0);
        System.out.println(player.getY());
        System.out.println(player.getX());
    }

    public void moveDown(){
        if(this.playerField.getSizeRow() <= player.getMaxY() - this.playerField.getPadding()){
            return;
        } player.translate(0, playerField.getCellSize());
        System.out.println(player.getY());  //284 - 318    Y road size Left
        System.out.println(player.getX());  //004                                                 //1292 X
    }                                            //Castelo fica em 1180x - 100y
                                                // AC  fica em  1126 - 1124


    public void energyDecay() throws InterruptedException {
        System.out.println("Player energy is: " + this.energy);
        if(this.energy == 0){
            super.setLives(super.getLives()- 1);
        }
        while(this.energy > 0){
            Thread.sleep(100);
            this.energy--;
        }
    }

    public int attack(Enemy enemy) {
        return 0;
    }

    public void loseEnergy() {
        this.energy--;
    }

    public void stealMilk() {
        this.hasMilk = true;
    }

    public int getClawDamage() {
        return this.clawDamage;
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public int getLives() {
        return super.getLives();
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void takeDamage() {
        super.takeDamage();
    }

    public void gainLife() {
        super.setLives(super.getLives() + 1);
    }

}
