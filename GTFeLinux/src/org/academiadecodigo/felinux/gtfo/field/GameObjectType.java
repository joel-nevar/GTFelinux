package org.academiadecodigo.felinux.gtfo.field;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public enum GameObjectType implements Position {

    MILK(10,10, ""),
    BUSH(20,20,""),
    WOODEN_BOX(30,30,"");

    private int col;
    private int row;
    private Picture picture;
    private String source;


    GameObjectType(int col, int row ,String source){
        this.col = col;
        this.row = row;
        this.source = source;
        picture = new Picture(col ,row ,source);
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setCol(int column) {
        col = column;
    }

    @Override
    public void setRow(int row) {
    row = row;
    }

    @Override
    public SpriteType getSprite() {
        return null;
    }

    @Override
    public boolean comparePosition(Position position) {
        return false;
    }

    public void setPicture(String source) {
        picture = new Picture(this.col ,this.row, source);
    }
}
