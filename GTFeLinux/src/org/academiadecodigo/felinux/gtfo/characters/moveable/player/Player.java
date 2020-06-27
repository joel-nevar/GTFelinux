package org.academiadecodigo.felinux.gtfo.characters.moveable.player;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.moveable.Moveable;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
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
    private Picture energyBar;
    private Rectangle energyAnimation;
    private Picture hpBar;
    private Rectangle hpAnimation;


    public Player(Field field) {
        super();
        super.setLives(7);
        this.playerField = field;
        this.player = new Picture(50,50,"resources/images/tobias.png");
        this.energyBar = new Picture(5, 5, "resources/images/EmptyEnergyBar.png");
        this.hpBar = new Picture(162, 5, "resources/images/EmptyHpBar.png");
        this.keyboardHandler = new PlayerKeyboard(this);
        //ENERGY BAR
        this.energyAnimation = new Rectangle(55, 27, 100, 10); //pos x pos y size size
        energyAnimation.setColor(new Color(255,255,0));
        //HP BAR
        this.hpAnimation = new Rectangle(207, 26, 100, 10);
        hpAnimation.setColor(new Color(255,0,0));
    }

    public void energyDecay(){
        //energyBarHolder = new Picture();
        if(super.getLives() <= 0){
            System.out.println("U dead.");
            this.dead = true;
            return;
        }
        if(this.energy <= 0){
            this.takeLethalDamage();
            this.energyReset();
            //HP BAR
            hpAnimation.translate( -7,0);       //tentativa erro xD Nao percebi mas fiz
            hpAnimation.grow(-7,0);
            System.out.println("You have " + getLives() + " lives left!");
        }else if(this.energy > 0){
            this.loseEnergy();
            energyAnimation.translate(-0.5,0);
            energyAnimation.grow(-0.5,0);
        }
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


    public Picture getPlayer() {
        return player;
    }

    public Picture getEnergyBar() {
        return energyBar;
    }

    public Picture getHpBar() {
        return hpBar;
    }

    public Rectangle getEnergyAnimation() {
        return energyAnimation;
    }

    public Rectangle getHpAnimation() {
        return hpAnimation;
    }

    public void energyReset(){
        this.setEnergy(100);
        energyAnimation.translate(50,0);  //funciona com metade dos valores, dunno why
        energyAnimation.grow(50,0);
    }
    public boolean isDead() {
        return dead;
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
    public void gainLife() {
        super.setLives(super.getLives() + 1);
        hpAnimation.translate( 29,0);
    }

}
