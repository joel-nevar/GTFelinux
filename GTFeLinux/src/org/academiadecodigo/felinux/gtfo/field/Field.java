package org.academiadecodigo.felinux.gtfo.field;

import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.npcs.Npc;
import org.academiadecodigo.felinux.gtfo.characters.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field extends Rectangle{

    private Rectangle field;
    private static final int PADDING = 5;
    private static final int SIZE_COL = 1320;    //3300 a 40%
    private static final int SIZE_ROW = 594;     //990 a 60%
    private static final int PIXEL = 2;
    private Player player;
    private Enemy[] enemy;
    private Npc[] npcs;
    private SpriteType[] spriteTypes;


    public Field (Player player, Enemy[] enemy, Npc[] npcs) {
        field = new Rectangle(PADDING,PADDING,SIZE_COL,SIZE_ROW);
        field.setColor(Color.BLACK);
        this.player = player;
        this.enemy = enemy;
        this.npcs = npcs;
        this.spriteTypes = SpriteType.values();
        showMap();
    }

    public Field () {
        this.player = new Player(this);
        field = new Rectangle(PADDING,PADDING,SIZE_COL,SIZE_ROW);
        field.setColor(Color.BLACK);
        field.draw();
    }

    public static int getPadding() {
        return PADDING;
    }

    /**
     *Show full map
     */
    private void showMap(){
        field.draw();
        drawField();
    }

    /**
     * fill sprites on the field
     */
    private void drawField(){
        for ( SpriteType sprite : spriteTypes) {

        }
    }

    public void makePosition(){

    }

    public static int getSizeRow() {
        return SIZE_ROW;
    }

    public static int getSizeCol() {
        return SIZE_COL;
    }

    public int getCellSize() {
        return PIXEL;
    }

    /*public Enum TerranType{
        BLOCK1,
        BLOCK2
    }*/

    public boolean comparePosition(Position position) {
        return false;
    }

}

