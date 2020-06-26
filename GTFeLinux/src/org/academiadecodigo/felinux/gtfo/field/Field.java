package org.academiadecodigo.felinux.gtfo.field;

import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.npcs.Npcs;
import org.academiadecodigo.felinux.gtfo.characters.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private Rectangle field;
    private static final int PADDING = 7;
    private static final int SIZE = 100;
    private static final int PIXEL = 33;
    private Player player;
    private Enemy[] enemy;
    private Npcs[] npcs;
    private SpriteType[] spriteTypes;
    private Picture picture;


    public Field(Player player, Enemy[] enemy, Npcs[] npcs) {
        field = new Rectangle(PADDING, PADDING, SIZE * PIXEL, SIZE * PIXEL);
        field.setColor(Color.BLACK);
        this.player = player;
        this.enemy = enemy;
        this.npcs = npcs;
        this.spriteTypes = SpriteType.values();
        showMap();
    }

    public Field() {
        field = new Rectangle(PADDING, PADDING, SIZE * PIXEL, SIZE * PIXEL);
        field.setColor(Color.BLACK);
        showMap();
    }


    /**
     * Show full map
     */
    private void showMap() {
        field.draw();
        //drawField();
    }

    /**
     * fill sprites on the field
     */
    private void drawField() {
        for (SpriteType sprite : spriteTypes) {

        }
    }

    public void makePosition() {

    }

    public int getCellSize() {
        return PIXEL;
    }

    public void setPicture(int x, int y, String source) {
        picture = new Picture(x, y, source);
    }

        /*public Enum TerranType{
        BLOCK1,
        BLOCK2
    }*/

}

