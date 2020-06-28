package org.academiadecodigo.felinux.gtfo.field;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Area {

    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;
    private Rectangle showArea;

    public Area(int xMin, int yMin, int xMax, int yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.showArea = new Rectangle (xMin,yMin,xMax,yMax);
        showArea.setColor(Color.BLACK);
    }

    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public boolean isXArea(int x) {
        return (x >= xMin && x <= xMax);
    }

    public boolean isYArea(int y) {
        return (y >= yMin && y <= yMax);
    }

    public boolean include(int x, int y) {
        return (x >= xMin + Field.PADDING_X && x <= xMax - xMin && y >= yMin + Field.PADDING_Y && y <= yMax - yMin);
    }

    public Rectangle getShowArea() {
        return showArea;
    }
}
