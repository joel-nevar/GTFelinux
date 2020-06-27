package org.academiadecodigo.felinux.gtfo.field;

import org.academiadecodigo.felinux.gtfo.characters.Factory;
import org.academiadecodigo.felinux.gtfo.characters.GameObjectType;
import org.academiadecodigo.felinux.gtfo.characters.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.npcs.Npc;
import org.academiadecodigo.felinux.gtfo.characters.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field extends Picture {

    private Picture field;
    private final int PADDING = 5;
    private final int SIZE_COL = 1320;    //3300 a 40%
    private final int SIZE_ROW = 594;     //990 a 60%
    private final int PIXEL = 2;
    private Player player;
    private Enemy enemy;
    private Npc[] npcs;
    private SpriteType[] spriteTypes;
    private Factory factory;
    private Picture picture;


    public Field (Player player, Enemy enemy, Npc[] npcs) {
        field = new Picture(PADDING,PADDING,"resources/images/backGround.png");
        showMap();
        this.player = player;
        this.enemy = enemy;
        this.npcs = npcs;
        this.spriteTypes = SpriteType.values();
    }

    public Field () {
        field = new Picture(PADDING,PADDING,"resources/images/backGround.png");
        this.player = new Player(this);
        this.enemy = new CopCar(this, 200,200,"tile000");
        showMap();
        enemy.move();
        picture = factory.gameObjectFactory(GameObjectType.MILK, this);

    }

    public int getPadding() {
        return PADDING;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    /**
     *Show full map
     */
    private void showMap(){
        field.draw();
        player.getPlayerImage().draw();
        enemy.getEnemyPosition().draw();
    }

    /**
     * fill sprites on the field
     */
    private void drawField(){
        player.draw();
    }

    public void makePosition(){

    }

    public int getSizeRow() {
        return SIZE_ROW;
    }

    public int getSizeCol() {
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

    private enum walkable{
        IS_WALKABLE,
        NOT_WALKABLE;
    }

}

