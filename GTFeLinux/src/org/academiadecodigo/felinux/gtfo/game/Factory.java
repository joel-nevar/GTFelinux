package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.EnemyType;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Lion;
import org.academiadecodigo.felinux.gtfo.characters.npcs.*;
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


    public static Picture gameObjectFactory(GameObjectType gameObject, int posX, int posY) {

        switch (gameObject) {
            case MILK:
                return new Picture(posX, posY,"resources/images/tile000.png");
            case BUSH:
                return new Picture(posX, posY, "BUSH");
            case WOODEN_BOX:
                return new Picture(posX, posY, "WOODEN BOX");
            case STAIRS:
                return new Picture(posX, posY, "STAIRS");
            default:
                return new Picture(posX, posY, "SAND");
        }
    }

    public static Enemy enemyFactory(EnemyType enemyType, int x, int y, String image) {

        switch(enemyType) {
            case COP_CAR:
                return new CopCar(x, y, image);
            case LION:
             default:return new Lion(x, y, image);
        }
    }

    public static Npc npcFactory(NpcType npcType, int posX, int posY, String image) {

        switch (npcType) {
            case ASSAULTABLE_CAT:
                return new AssaultableCat(posX, posY, image);
            case CAT_PROSTITUTE:
                return new CatProstitute(posX, posY, image);
            case RAT:
            default:
                return new Rat(posX, posY, image);
        }
    }
}

