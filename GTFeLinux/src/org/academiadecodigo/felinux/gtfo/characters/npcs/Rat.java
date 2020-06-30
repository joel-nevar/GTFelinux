package org.academiadecodigo.felinux.gtfo.characters.npcs;


public class Rat extends Npc {

    public Rat(int posX, int posY, String spriteName) {
        super(posX, posY, spriteName);
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
