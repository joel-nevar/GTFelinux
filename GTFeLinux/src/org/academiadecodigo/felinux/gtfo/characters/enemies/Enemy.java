package org.academiadecodigo.felinux.gtfo.characters.enemies;
import javax.swing.text.Position;


public abstract class Enemy {
    private int speed;
    private Position position;
    private boolean isDead;




    public boolean isKill() {
        return isDead;
    }

    public Position getPosition() {
        return position;
    }

    public void movement(){

    }
}
