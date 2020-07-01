package org.academiadecodigo.felinux.gtfo.characters.player;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.DirectionType;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends Character{

    private Field map;
    private Picture player;                     //Draws player on the field
    private Picture clawAnimation;              //Draws claws on the field
    private int clawTick = 0;                   //Timer to make the claw disappear from the field
    private boolean clawUsed = false;           //Checks if the claw was used or not
    private boolean dead = false;               //Checks if the player is dead
    private int energy = 300;                   //Animation scaled to 300
    private boolean hasMilk = false;            //Doesn't have Milk yet
    private int clawDamage = 1;                 //Damage when attacking
    private Picture energyBar;                  //Background image for the Energy bar
    private Rectangle energyAnimation;          //The actual energy bar
    private Picture hpBar;                      //Background image for the Energy bar
    private Rectangle hpAnimation;              //The actual energy bar
    private DirectionType lastDirection = DirectionType.STOP;

    //These are used for movement
    public static float dx;
    public static float dy;

    //used for collision UPDATE ON PLAYER MOVE
    private Area playerArea;

    public Player(String name) {
        super();
        super.setLives(7);
        map = new Field();
        this.player = new Picture(50, 300, "resources/images/" + name);
        this.energyBar = new Picture(5, 5, "resources/images/EmptyEnergyBar.png");
        this.hpBar = new Picture(162, 5, "resources/images/EmptyHpBar.png");
        //ENERGY BAR
        this.energyAnimation = new Rectangle(55, 27, 100, 10); //pos x pos y size size
        energyAnimation.setColor(new Color(255, 255, 0));
        //HP BAR
        this.hpAnimation = new Rectangle(207, 26, 100, 10);
        hpAnimation.setColor(new Color(255, 0, 0));

        //collisionBox
        playerArea = new Area(getPlayer().getX(),getPlayer().getY(),getPlayer().getWidth(),getPlayer().getHeight());
    }


    @Override
    public void interact() {

    }

    public void energyDecay() {
        if (this.energy <= 0) {
            if (super.getLives() <= 1) {
                this.dead = true;
                //HP BAR
                hpAnimation.translate(-7, 0);
                hpAnimation.grow(-7, 0);
                return;
            }
            this.takeLethalDamage();
            this.energyReset();
            //HP Bar
            hpAnimation.translate(-7, 0);
            hpAnimation.grow(-7, 0);
        }
        //Energy Bar
        this.loseEnergy();
        energyAnimation.translate(-0.16, 0);
        energyAnimation.grow(-0.16, 0);
    }

    public void gainLife() {
        super.setLives(super.getLives() + 1);
        hpAnimation.translate(29, 0);   //size / 7 vidas
    }

    public void energyReset() {
        this.setEnergy(300);
        energyAnimation.translate(48, 0);   // 0.16 * 300
        energyAnimation.grow(48, 0);
    }

    public void playerAttackVerification() {
        //Attack animation appear
        if (clawUsed == true) {
            this.getClawAnimation().draw();

            //Tick to measure animation time
            this.setClawTick(getClawTick() + 1);

            //Attack animation disappear
            if (getClawTick() == 4) {
                this.setClawUsed(false);
                this.getClawAnimation().delete();
                this.setClawTick(0);
            }
        }
    }

    public void attack(Enemy enemy) {

        this.clawUsed = true;
        clawAnimation = new Picture(this.getPlayer().getX(), this.getPlayer().getY(), "resources/images/Claw_attack.png");

        if (200 > (Math.abs(this.getX() - enemy.getEnemy().getX())) && 200 > (Math.abs(this.getY() - enemy.getEnemy().getY()))) {

            if (enemy.getLives() <= 1) {
                enemy.setDead();
                return;
            }
            enemy.setLives(enemy.getLives() - 1);
            System.out.println(enemy.getLives());
        }
    }

    public int getClawTick() {
        return clawTick;
    }

    public void setClawTick(int clawTick) {
        this.clawTick = clawTick;
    }

    public void setClawUsed(boolean clawUsed) {
        this.clawUsed = clawUsed;
    }

    public boolean isClawUsed() {
        return clawUsed;
    }

    public Picture getClawAnimation() throws NullPointerException {
        return clawAnimation;
    }

    /**
     * Actual movement called by method move()
     */
    @Override
    public void move() {

        if (isDead()) {
            return;
        }

        if(collisionCheck()){
            System.out.println("collide");
            //return;  //not working YET!
        }

        //checkUp
        if ((Field.getPADDING_Y() >= player.getY())) {
            if(dy<=0){
                dy=0;
            }
        }

        //checkRight
        if ((Field.width <= player.getMaxX() - Field.getPADDING_X())) {
            if(dx>=0){
                dx=0;
            }
        }

        //checkDown
        if ((Field.height <= player.getMaxY() - Field.getPADDING_Y())) {
            if(dy>=0){
                dy=0;
            }
        }

        //checkLeft
        if ((Field.getPADDING_X() >= player.getX())) {
            if(dx<=0){
                dx=0;
            }
        }

        player.translate(dx,dy);
        playerArea.getBoundArea().translate(dx,dy);
    }

    @Override
    public void moveLeft() {
    }

    @Override
    public void moveUp() {
    }

    @Override
    public void moveRight() {
    }

    @Override
    public void moveDown() {
    }

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

    public boolean isDead() {
        return dead;
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

    public void setLastDirection(DirectionType lastDirection) {
        this.lastDirection = lastDirection;
    }

    /*
    private boolean isWalkable() {
        return (Field.isWalkable(player.getX(), player.getY()));
    }*/

    public boolean collisionCheck(){

        for ( Area area : Field.notWalkable ) {

            if(Area.contains(playerArea ,area)){

                return true;
            }
        }
       return false;
    }
}
