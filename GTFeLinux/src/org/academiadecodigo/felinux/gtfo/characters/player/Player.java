package org.academiadecodigo.felinux.gtfo.characters.player;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.CheckpointType;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Lion;
import org.academiadecodigo.felinux.gtfo.characters.npcs.AssaultableCat;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.felinux.gtfo.game.GameHandler;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends Character {

    private Field map;
    private Picture player;                     //Draws player on the field
    private Picture clawAnimation;              //Draws claws on the field
    private Picture oneUp;                      //Animation for 1 life gained
    private int oneUpTimer = 5;                 //Timer for oneUp animation to disappear
    private boolean oneUpExists = false;        //Checks if player won a life
    private int clawTick = 0;                   //Timer to make the claw disappear from the field
    private boolean clawUsed = false;           //Checks if the claw was used or not
    private boolean dead = false;               //Checks if the player is dead
    private int energy = 150;                   //Animation scaled to 300
    private boolean hasMilk = false;            //Doesn't have Milk yet
    private int clawDamage = 1;                 //Damage when attacking
    private Picture energyBar;                  //Background image for the Energy bar
    private Rectangle energyAnimation;          //The actual energy bar
    private Picture hpBar;                      //Background image for the Energy bar
    private Rectangle hpAnimation;              //The actual energy bar
    private CheckpointType checkpoint;
    private int loseLife;
    private int lifeCounter = 0;                //Used to check death of cat and set animation
    private boolean assaultableCatIsDead = false;
    private boolean cowIsDead = false;

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

        //set Checckpoint to start
        checkpoint = CheckpointType.START;

        //collisionBox
        playerArea = new Area(getPlayer().getX(), getPlayer().getY(), getPlayer().getWidth(), getPlayer().getHeight());
    }

    /**
     * Call this method to check interactions
     * Remove the milk part, to reuse this
     */
    @Override
    public void interact() {

        Character interactWith = GameHandler.checkInteraction();

        //this is to check the default
        if (interactWith instanceof Player) {
            if (GameHandler.checkMilk()) {
                this.hasMilk = true;
            }
            return;
        }
        //Attacks enemy, or not
        if(interactWith instanceof AssaultableCat){
            if(this.isClawUsed()){
                //Gives damage to that instance
                interactWith.setLives( interactWith.getLives() - 1 );
                ((AssaultableCat) interactWith).getGreenLifeBar().grow(-5,0);
                ((AssaultableCat) interactWith).getGreenLifeBar().translate(-6,0);
                //kills the cat and gives hp to the player
                if(interactWith.getLives() == 0){
                    this.assaultableCatIsDead = true;
                    ((AssaultableCat) interactWith).kill();
                    this.gainLife();
                }
                this.assaultableCatIsDead = false;
            }
            return;
        }

        if(interactWith instanceof Lion){
            if(this.isClawUsed()){
                //Gives damage to that instance
                interactWith.setLives( interactWith.getLives() - 1 );
                ((Lion) interactWith).getGreenLifeBar().grow(-4,0);
                ((Lion) interactWith).getGreenLifeBar().translate(-6,0);
                //kills the cow and gives hp to the player
                if(interactWith.getLives() == 0){
                    this.cowIsDead = true;
                    ((Lion) interactWith).kill();
                    this.gainLife();
                }
                this.cowIsDead = false;
            }
            return;
        }
        //In range for interaction, interact with
        interactWith.interact();
    }

    public boolean isOneUpExists() {
        return oneUpExists;
    }

    public void setOneUpExists(boolean oneUpExists) {
        this.oneUpExists = oneUpExists;
    }

    public boolean isAssaultableCatIsDead() {
        return assaultableCatIsDead;
    }

    public Picture getOneUp() {
        return oneUp;
    }

    public boolean HasMilk(){
        return hasMilk;
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
        energyAnimation.translate(-0.32, 0);
        energyAnimation.grow(-0.32, 0);
    }

    public void gainLife() {

        if(super.getLives() >= 7){
            return;
        }

        this.oneUpExists = true;
        this.oneUp = new Picture(this.getArea().getBoundArea().getX() + 20, this.getArea().getBoundArea().getY() - 20, "resources/images/1life.png");
        oneUp.draw();
        System.out.println("Oneup exists");

        super.setLives(super.getLives() + 1);
        System.out.println("Player has " + super.getLives() + " lives");
        this.hpAnimation.translate(7, 0);  // TRANSLATE 7 FOR 7 LIVES OMEGALUL
        this.hpAnimation.grow(7, 0);
    }

    public void energyReset() {
        this.setEnergy(150);
        energyAnimation.translate(48, 0);   // 0.16 * 300
        energyAnimation.grow(48, 0);
    }

    public void setAssaultableCatDead(boolean assaultableCatDead) {
        this.assaultableCatIsDead = assaultableCatDead;
    }

    public void playerAttackVerification() throws NullPointerException {
        //Attack animation appear
        if (clawUsed == true) {
            this.clawAnimation.draw();
            GameHandler.GameSound.CATCLAW.sounds.play(true);

            //Tick to measure animation time
            this.clawTick += 1;

            //Attack animation disappear
            if (clawTick == 4) {
                this.clawUsed = false;
                this.clawAnimation.delete();
                this.clawTick = 0;
            }
        }
    }

    public void attack(Enemy enemy) {

        this.clawUsed = true;
        clawAnimation = new Picture(this.getPlayer().getX(), this.getPlayer().getY(), "resources/images/Claw_attack.png");

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

        if (interactCollisionCheck(dx,dy)){
            energyDecay();
        }


        if (collisionCheck(dx, dy)) {

            dx = 0;
            dy = 0;
        }

        //checkUp
        if ((Field.getPADDING_Y() >= player.getY())) {
            if (dy <= 0) {
                dy = 0;
            }
        }

        //checkRight
        if ((Field.width <= player.getMaxX() - Field.getPADDING_X())) {
            if (dx >= 0) {
                dx = 0;
            }
        }

        //checkDown
        if ((Field.height <= player.getMaxY() - Field.getPADDING_Y())) {
            if (dy >= 0) {
                dy = 0;
            }
        }

        //checkLeft
        if ((Field.getPADDING_X() >= player.getX())) {
            if (dx <= 0) {
                dx = 0;
            }
        }

        player.translate(dx, dy);
        playerArea.getBoundArea().translate(dx, dy);
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

    public boolean collisionCheck(float dx, float dy) {

        if (GameHandler.firstMap) {

            for (Area area : Field.notWalkable) {

                if (Area.contains(playerArea, area, dx, dy)) {

                    return true;
                }
            }
            return false;
        }

        return false;
    }

    public Area getArea() {
        return playerArea;
    }

    public boolean interactCollisionCheck(float dx, float dy){

        if(GameHandler.canEnterCastle()){

            GameHandler.changeMap();

            return false;
        }

        for (Area area : Field.notWalkableMap2) {

            if (Area.contains(playerArea, area, dx, dy)) {

                return true;
            }
        }
        return false;
    }

    public void toCheckpoint(){

    }
}
