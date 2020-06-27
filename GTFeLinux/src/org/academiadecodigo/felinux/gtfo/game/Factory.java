package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.EnemyType;
import org.academiadecodigo.felinux.gtfo.characters.moveable.player.PlayerType;
import org.academiadecodigo.felinux.gtfo.characters.npcs.NpcType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Factory extends Picture {


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


    public static Picture gameObjectFactory(GameObjectType gameObject) {

        switch (gameObject) {

            case MILK:

                return new Picture(70, 70, "resources/images/tile000.png");


            case BUSH:

                return new Picture(50, 50, "BUSH");


            case WOODEN_BOX:

                return new Picture(50, 50, "WOODEN BOX");


            case STAIRS:

                return new Picture(50, 50, "STAIRS");


            default:
            case SAND:

                return new Picture(50, 50, "SAND");

        }

    }

    public static Picture playerFactory(PlayerType playerType) {
        switch (playerType) {

            case TOBIAS:
                return new Picture(50,50,"Image");

            case ROBIN:
                return new Picture(50,50,"Image1");

            case MARIANA:
                return  new Picture(50,50,"Image2");

            case SARA:
                return new Picture(50,50,"Image3");

            default:
                return new Picture(50,50,"Image4");
        }
    }

    public static Picture enemyFactory(EnemyType enemyType) {

        switch(enemyType) {

            case COP_CAR:

                return new Picture(50, 50, "Image");


            case LION:

                return new Picture(50,50,"Image1");

             default:

                 return new Picture(50,50,"Image3");

        }
    }

    public static Picture npcFactory(NpcType npcType) {

        switch (npcType) {

            case ASSAULTABLE_CAT:

                return new Picture(50, 50, "Image");


            case CAT_PROSTITUTE:

                return new Picture(50, 50, "Image1");

            case RAT:

                return new Picture(50,50,"Image2");
            default:


                return new Picture(50, 50, "Image3");
        }
    }
}

