package org.academiadecodigo.felinux.gtfo.field;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Area {

    private int xMin;
    private int yMin;
    private int xSize;
    private int ySize;
    private Rectangle boundArea;

    public Area(int xMin, int yMin, int xSize, int ySize) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xSize = xSize;
        this.ySize = ySize;
        boundArea = new Rectangle(xMin,yMin,xSize,ySize);
    }

    public int getX() {
        return xMin;
    }

    public int getY() {
        return yMin;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public Rectangle getBoundArea(){
        return boundArea;
    }

    /**
     * Pure dark magic, DONT FKN TOUCH
     * @param player the player Area
     * @param rect the area to compare with
     * @return true if collide, false if not
     */
    public static boolean contains (Area player, Area rect){

        int xA = ((player.getBoundArea().getX())*2+player.getBoundArea().getWidth())/2;
        int yA = ((player.getBoundArea().getY())*2+player.getBoundArea().getHeight())/2;

        int xB = (rect.getBoundArea().getX()*2+rect.getBoundArea().getWidth())/2;
        int yB = (rect.getBoundArea().getY()*2+rect.getBoundArea().getHeight())/2;

        System.out.println(xA);
        int distance = player.getBoundArea().getWidth()/2;

        return Math.sqrt(Math.pow((xA-xB),2)+Math.pow((yA-yB),2))<=distance;

    }
}
