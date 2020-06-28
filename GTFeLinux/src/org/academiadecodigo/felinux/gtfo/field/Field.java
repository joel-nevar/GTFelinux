package org.academiadecodigo.felinux.gtfo.field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Field extends Picture {

    private Picture map;
    private final int PADDING_X = 5;
    private final int PADDING_Y = 65;
    private final int PIXEL = 2;
    private ArrayList<Area> notWalkable = new ArrayList<>();


    public Field () {
        map = new Picture(PADDING_X, PADDING_Y,"resources/images/backGround.png");
        setNotWalkable();
    }

    public int getPADDING_X() {
        return PADDING_X;
    }

    public int getPADDING_Y() {
        return PADDING_Y;
    }

    public Picture getMap() {
        return map;
    }
    /**
     *Show full map
     */


    /**
     * fill sprites on the field
     */

    public int getSizeRow() {
        return map.getHeight();
    }

    public int getSizeCol() {
        return map.getWidth();
    }

    public int getCellSize() {
        return PIXEL;
    }

    public ArrayList<Area> getNotWalkable() {
        return notWalkable;
    }

    public boolean isWalkable(int x, int y) {
        for (Area area : notWalkable) {
            if (area.include(x,y)){
                return false;
            }
        }
        return true;
    }

    private void addNotWalkable(int xMin, int yMin, int xMax, int yMax){
        Area area =new Area(xMin, yMin, xMax, yMax);
        area.getShowArea().setColor(Color.RED);
        notWalkable.add(area);
    }

    public void setNotWalkable(){
        addNotWalkable(50,282,1320,318);
    }

}

