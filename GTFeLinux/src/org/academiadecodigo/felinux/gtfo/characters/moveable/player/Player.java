package org.academiadecodigo.felinux.gtfo.characters.moveable.player;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.moveable.Moveable;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.felinux.gtfo.field.Position;
import org.academiadecodigo.felinux.gtfo.game.SpriteType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends Character implements Moveable{

    private Picture playerImage;
    private int col = 72;       //Y
    private int row = 198;      //X
    private boolean dead = false;
    private Position checkpoint;
    private Field playerField;
    private int energy = 100;
    private boolean hasMilk = false;
    private int clawDamage = 1;
    private KeyboardHandler keyboardHandler;


    public Player(Field field) {
        super();
        this.playerField = field;
        this.playerImage = new Picture(getCol(),getRow(),"resources/images/tobias.png");
        this.keyboardHandler = new PlayerKeyboard(this);
    }

    public Picture getPlayerImage() {
        return playerImage;
    }

    public void moveLeft(){
        if(this.playerField.getPadding()  >= playerImage.getX()){
            return;
        } playerImage.translate(-playerField.getCellSize(),0);
        System.out.println(playerImage.getY());
        System.out.println(playerImage.getX());
    }

    public void moveUp(){
        if(this.playerField.getPadding() >= playerImage.getY()){
            return;
        } playerImage.translate(0,-playerField.getCellSize());
        System.out.println(playerImage.getY());
        System.out.println(playerImage.getX());
    }

    public void moveRight(){
        if(this.playerField.getSizeCol() <= playerImage.getMaxX() - this.playerField.getPadding()){
            return;
        } playerImage.translate(playerField.getCellSize(),0);
        System.out.println(playerImage.getY());
        System.out.println(playerImage.getX());
    }

    public void moveDown(){
        if(this.playerField.getSizeRow() <= playerImage.getMaxY() - this.playerField.getPadding()){
            return;
        } playerImage.translate(0, playerField.getCellSize());
        //System.out.println(playerImage.getY());  //284 - 318    Y road size Left
        //System.out.println(playerImage.getX());  //004                                                 //1292 X
    }                                            //Castelo fica em 1180x - 100y
                                                // AC  fica em  1126 - 1124


    public void energyDecay() throws InterruptedException {
        if(this.energy == 0){
            super.setLives(super.getLives()- 1);
            System.out.println("Player energy is: " + this.energy + " which means he's dead");
        }
        while(this.energy > 0){
            Thread.sleep(300);
            this.energy--;
            System.out.println("Player energy is: " + this.energy);
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
        return this.col;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public void setCol(int column) {
        this.col = column;
    }

    @Override
    public void setRow(int row) {
        this.row=row;
    }

    @Override
    public SpriteType getSprite() {
        return null;
    }
}
