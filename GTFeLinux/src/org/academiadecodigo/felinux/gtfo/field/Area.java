package org.academiadecodigo.felinux.gtfo.field;


public class Area {

    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;

    public Area(int xMin, int yMin, int xMax, int yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
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

    public boolean isArea(int x, int y) {
        return (x >= xMin && x <= xMax && y >= yMin && y <= yMax);
    }
}
