package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.Moveable;

public class Rat extends Npc implements Moveable {

    public Rat(int posX, int posY, String spriteName) {
        super(posX, posY, spriteName);
    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    /*  private Rat[] ratArray;
    private int ratCounter = 0;
    private static final int maxRats = 10;

    public Rat[] makeRat(){

        if(ratArray == null){
            ratArray = new Rat[maxRats];
        }

        if(ratCounter<=maxRats){

            ratArray[ratCounter] = new Rat(field,(int)(Math.random()*field.SIZE_COL), (int)(Math.random()*field.SIZE_ROW));
            ratCounter++;
        }

        return ratArray;
    }


    public int getRatCounter() {
        return ratCounter;
    } */
}
