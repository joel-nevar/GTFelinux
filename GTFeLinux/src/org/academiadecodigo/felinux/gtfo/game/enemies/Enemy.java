package org.academiadecodigo.felinux.gtfo.game.enemies;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import javax.swing.text.Position;


public abstract class Enemy {

    private int speed;
    private Grid grid;
    private Position position;
    private boolean kill;
    GridDirection currentDirection;

    Grid setGrid(Grid grid){
       return this.grid = grid;
    }

    public boolean isKill() {
        return kill;
    }

    public Position getPosition() {
        return position;
    }

    public void movement(){

    }
}
