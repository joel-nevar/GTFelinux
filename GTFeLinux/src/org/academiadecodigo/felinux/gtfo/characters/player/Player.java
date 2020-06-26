package org.academiadecodigo.felinux.gtfo.characters.player;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.felinux.gtfo.field.Position;
import org.academiadecodigo.felinux.gtfo.field.SpriteType;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;


public class Player extends Character {

    private Picture playerImage;
    private boolean dead = false;
    private Position checkpoint;
    private Field fieldOfThePlayer;
    private int energy = 100;
    private boolean hasMilk = false;
    private int clawDamage = 1;
    private KeyboardHandler keyboardHandler;


    public Player(Field field) {

        super();
        this.fieldOfThePlayer = field;
        this.keyboardHandler = new PlayerKeyboard(this);
        this.playerImage = new Picture(100,100,"C:/Users/David/Documents/Repository_Jogo_GTF/gtfelinux/GTFeLinux/src/org/academiadecodigo/felinux/gtfo/images/tile000.png");
        playerImage.draw();
    }
    public void moveLeft(){
        if(this.fieldOfThePlayer.getPaddingX() == playerImage.getX()){
            return;
        }
        playerImage.translate(-fieldOfThePlayer.getCellSize(),0);
    }
    public void moveUp(){
        if(this.fieldOfThePlayer.getPaddingY() == playerImage.getY()){
            return;
        }
        playerImage.translate(0,-fieldOfThePlayer.getCellSize());
    }
    public void moveRight(){
        if(this.fieldOfThePlayer.getWidth() == playerImage.getMaxX()){
            return;
        }
        playerImage.translate(fieldOfThePlayer.getCellSize(),0);
    }

    public void moveDown(){
        if(this.fieldOfThePlayer.getHeight() == playerImage.getMaxY()){
            return;
        }
        playerImage.translate(0,fieldOfThePlayer.getCellSize());
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
