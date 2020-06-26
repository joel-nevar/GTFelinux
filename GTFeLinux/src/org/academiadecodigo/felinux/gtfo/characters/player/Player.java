package org.academiadecodigo.felinux.gtfo.characters.player;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.felinux.gtfo.field.Position;
import org.academiadecodigo.felinux.gtfo.field.SpriteType;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends Character {

    private Picture playerImage;
    private static final int IMAGE_SIZE = 33;
    private boolean dead = false;
    private Position checkpoint;
    private int energy = 100;
    private boolean hasMilk = false;
    private int clawDamage = 1;
    private KeyboardHandler keyboardHandler;


    public Player() {
        super();
        this.keyboardHandler = new PlayerKeyboard();
        this.playerImage = new Picture(checkpoint.getCol(),checkpoint.getRow(), "Caminho");
        this.playerImage.draw();

    }

    public void moveLeft(Field field){
        if(playerImage.getWidth() == 0){
            return;     //Player doesn't move
        }
        this.playerImage.translate(-IMAGE_SIZE*checkpoint.getCol(),0);
    }
    public void moveRight(Field field){
        if(playerImage.getWidth() == field.getWidth()){
            return;
        }
        this.playerImage.translate(IMAGE_SIZE*checkpoint.getCol(),0);
    }
    public void moveUp(Field field){
        if(playerImage.getHeight() == 0){
            return;
        }
        this.playerImage.translate(0,-IMAGE_SIZE*checkpoint.getRow());
    }
    public void moveDown(Field field){
        if(playerImage.getHeight() == field.getHeight()){
            return;
        }
        this.playerImage.translate(0,IMAGE_SIZE*checkpoint.getRow());
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

    public Position getCheckpoint() {
        return this.checkpoint;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setCheckpoint(Position checkpoint) {
        this.checkpoint = checkpoint;
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

    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public void setCol(int column) {

    }

    @Override
    public void setRow(int row) {

    }

    @Override
    public SpriteType getSprite() {
        return null;
    }
}
