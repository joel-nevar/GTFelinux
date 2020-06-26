package org.academiadecodigo.felinux.gtfo.characters.player;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.field.Position;


public class Player extends Character {


    private boolean dead = false;
    private Position checkpoint;
    private int energy = 100;
    private boolean hasMilk = false;
    private int clawDamage = 1;


    public Player(){
        super();

    }


   public int attack(Enemy enemy){
            return 0;
   }


    public void loseEnergy(){
       this.energy--;
   }

    public void stealMilk(){
        this.hasMilk = true;
    }

    public int getClawDamage() {
        return clawDamage;
    }

    public int getEnergy() {
        return energy;
    }
    @Override
    public int getLives() {
        return super.getLives();
    }

    public Position getCheckpoint() {
        return checkpoint;
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
}
