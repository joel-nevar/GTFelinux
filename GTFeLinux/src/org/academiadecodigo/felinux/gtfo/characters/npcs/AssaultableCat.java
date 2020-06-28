package org.academiadecodigo.felinux.gtfo.characters.npcs;

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

    @Override
    public String getMessage() {
        return "I am an Assaultable Cat";
    }

    public AssaultableCat(int posX, int posY, String spriteName) {
        super(posX, posY, spriteName);
        defineRoute();

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
            System.out.println(1);

                moveCounter++;
                getNpc().translate(routeX, routeY);

            if(moveCounter>DISTANCE){
                forward = false;
            }

            return;
        }

        moveCounter--;
        getNpc().translate(-routeX, -routeY);

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
