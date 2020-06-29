package org.academiadecodigo.felinux.gtfo.characters.moveable.enemies;

import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CopCar extends Enemy {


    private Rectangle redLifeBar;
    private Rectangle greenLifeBar;
    private boolean forward = true;
    private boolean turning;
    private final float MAX_SPEED = 3.5f;
    private final float ACCEL = 0.7f;
    private float cSpeed;
    private int turningCounter;

    public CopCar(int posX, int posY, String spriteName) {

        super(EnemyAreaType.COP_CAR, posX, posY, spriteName, 10);
        this.redLifeBar = new Rectangle(posX - 9, posY - 8, 50,7);
        this.redLifeBar.setColor(new Color(255,0,0));
        this.greenLifeBar = new Rectangle(posX - 9, posY - 8, 50,7);
        this.greenLifeBar.setColor(new Color(0,255,0));
    }
    public Rectangle getGreenLifeBar() {
        return greenLifeBar;
    }

    public Rectangle getRedLifeBar() {
        return redLifeBar;
    }

    /**
     * Gets the position, kinda, for now thats how it works
     *
     * @return Picture that has the position of the stuff, like i said, for now
     */
    @Override
    public Picture getEnemy() {
        return super.getEnemy();
    }

    /**
     * Traces the route for the policeCar
     * and calls the methods on the super class
     * or should
     */
    @Override
    public void move() {
        /*Cars dont die bud

            //check death
            if(isDead()){
                return;
        }*/
        //check if turning
        if(turning) {

            cSpeed = 1;
            turnCar();

            if(turningCounter > 4) {

                if(forward){
                    System.out.println("forward false, turning false");
                    forward = false;
                    turning = false;
                    turningCounter = 0;
                    return;
                }
                System.out.println("forward true, turning false");
                forward = true;
                turning = false;
                turningCounter = 0;
            }
            return;
        }

        //if it is not turning it gains speed
        //and moves accordingly
        if(cSpeed < MAX_SPEED) {
            cSpeed += ACCEL;
        }

        //direction that the car is moving and the movement
        if (forward) {
            if(getEnemy().getX() < Field.width){        //Horizontal

                System.out.println("Moving horizontally");
                getEnemy().translate(cSpeed,0);
                redLifeBar.translate(cSpeed,0);
                greenLifeBar.translate(cSpeed,0);
                return;
            } else if(getEnemy().getX() >= Field.width){
                turning = true;
                return;
            }
        }

        /*//other direction
        if(getEnemy().getX() > Field.PADDING_X){

            getEnemy().translate(-cSpeed,0);
            redLifeBar.translate(-cSpeed,0);
            greenLifeBar.translate(-cSpeed,0);
            return;
        }
        turning = false;*/
    }

    //handles turning
    private void turnCar(){

        if(forward = false) {

            getEnemy().translate(0, cSpeed);
            redLifeBar.translate(0, cSpeed);
            greenLifeBar.translate(0, cSpeed);
            turningCounter++;
            if(turningCounter == 5){
                forward = true;
            }
            return;

        }
        getEnemy().translate(0, cSpeed);
        redLifeBar.translate(0, cSpeed);
        greenLifeBar.translate(0, cSpeed);
        turningCounter++;

    }
}


