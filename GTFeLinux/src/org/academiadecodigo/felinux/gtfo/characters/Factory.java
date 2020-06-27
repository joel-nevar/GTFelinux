package org.academiadecodigo.felinux.gtfo.characters;

import org.academiadecodigo.felinux.gtfo.characters.npcs.Rat;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Factory extends Picture{


    Field field;
    private Rat[] ratArray;
    private int ratCounter = 0;
    private static final int maxRats = 10;


    public void setField(Field field) {
        this.field = field;
    }

    public Picture gameObjectFactory(GameObjectType gameObject, Field field) {

        switch (gameObject) {

            case MILK:
                Picture picture = new Picture(70, 70, "resources/images/tile000.png");
                picture.draw();
                return picture;

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

    /**
     * Instantiates a new Rat on every call, at random location
     *
     * @return Rat[] with every Rat created,
     */
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
    }

    /*public Player playerFactory(Field field) {

        return new Player(field);
    }

    public Enemy enemyFactory(Enemy enemy) {
        return new Enemy() {
        };
    }

    public Picture npcFactory(Npc npc) {

        switch(npc){

            case
                return  new AssaultableCat();

            case
                return new CatProstitute();
        }
    } */
}
