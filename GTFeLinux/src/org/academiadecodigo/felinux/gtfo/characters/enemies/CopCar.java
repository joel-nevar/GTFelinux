package org.academiadecodigo.felinux.gtfo.characters.enemies;


import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class CopCar extends Enemy {


    private Rectangle redLifeBar;
    private Rectangle greenLifeBar;
    private boolean forward;
    private boolean turning;
    private final float MAX_SPEED = 4.5f;
    private final float ACCEL = 1.5f;
    private float cSpeed;
    private int turningCounter;
    private Text shoot;

    public CopCar(int posX, int posY, String spriteName) {

        super(EnemyAreaType.COP_CAR, posX, posY, spriteName, 10);

        //hp animations
        this.redLifeBar = new Rectangle(posX - 9, posY - 8, 50, 7);
        this.redLifeBar.setColor(new Color(255, 0, 0));
        this.greenLifeBar = new Rectangle(posX - 9, posY - 8, 50, 7);
        this.greenLifeBar.setColor(new Color(0, 255, 0));
        this.shoot = new Text(posX,posY,"...");
    }

    public Rectangle getGreenLifeBar() {
        return greenLifeBar;
    }

    public Rectangle getRedLifeBar() {
        return redLifeBar;
    }

    @Override
    public Picture getEnemy() {
        return super.getEnemy();
    }

    /**
     * Traces the route for the policeCar
     * And makes the movement
     */
    @Override
    public void move() {

        if (turning) {
            cSpeed = 1;
            if (turningCounter > 4) {

                turningCounter = 0;
                turning = false;

                if (forward) {

                    forward = false;
                    return;
                }
                forward = true;
                return;
            }
            turnCar();
            return;
        }

        //if it is not turning it gains speed
        //and moves accordingly
        if (cSpeed < MAX_SPEED) {
            cSpeed += ACCEL;
        }

        //direction that the car is moving and the movement
        if (!forward) {

            if (getEnemy().getX() < Field.width - 50) {

                getEnemy().translate(cSpeed, 0);
                getArea().getBoundArea().translate(cSpeed, 0);
                redLifeBar.translate(cSpeed, 0);
                greenLifeBar.translate(cSpeed, 0);
                //shotLeft(MAX_SPEED+2);
                return;
            }
            turning = true;
            return;
        }

        //other direction
        if (getEnemy().getX() > Field.PADDING_X + 50) {

            getEnemy().translate(-cSpeed, 0);
            getArea().getBoundArea().translate(-cSpeed, 0);
            redLifeBar.translate(-cSpeed, 0);
            greenLifeBar.translate(-cSpeed, 0);
            //shotLeft(-(MAX_SPEED+2));

            return;
        }
        turning = true;
    }

    //handles turning
    private void turnCar() {

        turningCounter++;
        if (forward) {

            getEnemy().translate(0, cSpeed);
            getArea().getBoundArea().translate(0, cSpeed);
            redLifeBar.translate(0, cSpeed);
            greenLifeBar.translate(0, cSpeed);
           // shootRight(MAX_SPEED+2);
            return;

        }
        getEnemy().translate(0, -cSpeed);
        getArea().getBoundArea().translate(0, -cSpeed);
        redLifeBar.translate(0, -cSpeed);
        greenLifeBar.translate(0, -cSpeed);
       // shootRight(-(MAX_SPEED+2));

    }

    public void shotLeft(float kill) {
        shoot.draw();
        shoot.translate(kill , 0);
        if (shoot.getX() == Field.width - 50) {
            shoot.delete();
        }
    }

    public void shootRight(float kill) {
        shoot.draw();
        shoot.translate(0 ,  kill);
        if (shoot.getX() == Field.width + 50) {
            shoot.delete();
        }
    }

}


