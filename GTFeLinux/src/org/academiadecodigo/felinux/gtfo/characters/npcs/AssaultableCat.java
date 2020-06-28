package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Assaultable cats
 */
public class AssaultableCat extends Npc {


    private boolean robbed;
    private boolean dead;

    //control the route taken
    private int routeX;
    private int routeY;
    private int moveCounter;
    private boolean forward;
    private final int DISTANCE = 100;
    private Rectangle redLifeBar;
    private Rectangle greenLifeBar;

    @Override
    public String getMessage() {
        return "I am an Assaultable Cat";
    }

    public AssaultableCat(int posX, int posY, String spriteName) {
        super(posX, posY, spriteName);

        this.redLifeBar = new Rectangle(posX - 9, posY - 8, 50,7);
        this.redLifeBar.setColor(new Color(255,0,0));
        this.greenLifeBar = new Rectangle(posX - 9, posY - 8, 50,7);
        this.greenLifeBar.setColor(new Color(0,255,0));

        defineRoute();
    }

    public Rectangle getGreenLifeBar() {
        return greenLifeBar;
    }

    public Rectangle getRedLifeBar() {
        return redLifeBar;
    }

    public boolean isRobbed() {
        return robbed;
    }

    public boolean isDead() {
        return dead;
    }

    /**
     * Move all assaultable cat
     */
    @Override
    public void move(){

        if(isDead()){
            return;
        }
        if (forward) {

                moveCounter++;
                getNpc().translate(routeX, routeY);
                redLifeBar.translate(routeX,routeY);
                greenLifeBar.translate(routeX,routeY);

                if(moveCounter > DISTANCE){
                forward = false;
            }
            return;
        }
        moveCounter--;
        getNpc().translate(-routeX, -routeY);
        redLifeBar.translate(-routeX,-routeY);
        greenLifeBar.translate(-routeX,-routeY);

        if(moveCounter<0){
            forward = true;
        }
    }

    @Override
    public Picture getNpc() {
        return super.getNpc();
    }

    /**
     * Defines how this will move
     */
    private void defineRoute(){

        if(Math.ceil(Math.random()*2)==2){

            routeX = 1;
            return;

        }
        routeY = 1;
    }
}
