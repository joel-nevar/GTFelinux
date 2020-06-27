package org.academiadecodigo.felinux.gtfo.field;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.npcs.Npc;
import org.academiadecodigo.felinux.gtfo.characters.moveable.player.Player;
import org.academiadecodigo.felinux.gtfo.game.SpriteType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field extends Picture {

    private Picture field;
    private final int PADDING = 5;
    public final int SIZE_COL = 1320;    //3300 a 40%
    public final int SIZE_ROW = 594;     //990 a 60%
    private final int PIXEL = 2;

    public Field () {
        field = new Picture(PADDING,PADDING,"resources/images/backGround.png");
    }

    public int getPadding() {
        return PADDING;
    }

    /**
     *Show full map
     */
    public void showMap(){
        field.draw();
    }

    /**
     * fill sprites on the field
     */


    public int getSizeRow() {
        return SIZE_ROW;
    }

    public int getSizeCol() {
        return SIZE_COL;
    }

    public int getCellSize() {
        return PIXEL;
    }

    public enum TerranType{
        BLOCK1,
        BLOCK2
    }

    private enum walkable{
        IS_WALKABLE,
        NOT_WALKABLE;
    }

}

