package org.academiadecodigo.felinux.gtfo.field;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.Arrays;

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
     * @return true if within interact range, false if not
     */
    public static boolean checkInteract (Area player, Area rect){

        int xA = ((player.getBoundArea().getX())*2+player.getBoundArea().getWidth())/2;
        int yA = ((player.getBoundArea().getY())*2+player.getBoundArea().getHeight())/2;

        int xB = (rect.getBoundArea().getX()*2+rect.getBoundArea().getWidth())/2;
        int yB = (rect.getBoundArea().getY()*2+rect.getBoundArea().getHeight())/2;

        int distance = player.getBoundArea().getWidth()/2; //this line is touchable

        return getDistance(xA,yA,xB,yB)<=distance;

    }

    /**
     * If U didnt understand the previous Spell, you can't handle this one (trust me)
     * Simple Trigonometry
     * @param player the player Area
     * @param rect the Area to verify if the player is into
     * @return true if player is inside the Rectangle, false if not
     */
    public static boolean contains (Area player, Area rect){

        int xP = ((player.getBoundArea().getX())*2+player.getBoundArea().getWidth())/2;
        int yP = ((player.getBoundArea().getY())*2+player.getBoundArea().getHeight())/2;

        int xA = rect.getBoundArea().getX();
        int yA = rect.getBoundArea().getY();
        int xB = rect.getBoundArea().getX()+rect.getBoundArea().getWidth();
        int yB = rect.getBoundArea().getY();
        int xC = rect.getBoundArea().getX()+rect.getBoundArea().getWidth();
        int yC = rect.getBoundArea().getY()+rect.getBoundArea().getHeight();
        int xD = rect.getBoundArea().getX();
        int yD = rect.getBoundArea().getY()+rect.getBoundArea().getHeight();

        int[] xCoords = new int[]{xP,xA,xB,xC,xD};
        int[] yCoords = new int[]{yP,yA,yB,yC,yD};

        double[] distances = new double[8];

        for (int i = 0; i < 4 ; i++){

            distances[i] = getDistance(xCoords[0],yCoords[0],xCoords[i+1],yCoords[i+1]);

            if(i == 3){
                distances[i+4] = getDistance(xCoords[1],yCoords[1],xCoords[i+1],yCoords[i+1]);
                break;
            }
            distances[i+4] = getDistance(xCoords[i+1],yCoords[i+1],xCoords[i+2],yCoords[i+2]);
        }

        //now is the semi-perimeter
        //right into triangle Area

        double[] triangleAreas = new double[4];

        for(int i = 0; i < 4; i++){

            if(i==3){

                triangleAreas[i] = calcArea(semiPerimeter(distances[i], distances[0], distances[i+4]),distances[i],distances[0],distances[i+4]);
                break;
            }
            triangleAreas[i] = calcArea(semiPerimeter(distances[i], distances[i+1], distances[i+4]),distances[i],distances[i+1],distances[i+4]);
        }


        int rectArea = rect.getBoundArea().getWidth()*rect.getBoundArea().getHeight();

        //forcing an int for rounding problems
        int triangleArea = 0;

        for (double triangle: triangleAreas ) {

            triangleArea += triangle;
        }

        return !(triangleArea > rectArea);
    }

    /**
     * Almighty God, calculator of distance, ruler of the maths
     * Aka DONT TOUCH
     * @param xA
     * @param yA
     * @param xB
     * @param yB
     * @return the distance between 2 points
     */
    private static double getDistance(double xA, double yA, double xB, double yB){

        return Math.sqrt(Math.pow((xA-xB),2)+Math.pow((yA-yB),2));
    }

    /**
     * Semi-Perimeter of a triangle
     * @param a
     * @param b
     * @param c
     * @return  s = 1/2 ( a + b + c )
     */
    private static double semiPerimeter(double a, double b, double c){

        return (a + b + c)/2;
    }

    /**
     * Another calc, area of triangle -Z Heron's formula
     * @param s semiPerimeter
     * @param a
     * @param b
     * @param c
     * @return Area = sqrt ( s ( s-a) ( s-b) ( s-c) )
     */
    private static double calcArea(double s, double a, double b, double c){

        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
