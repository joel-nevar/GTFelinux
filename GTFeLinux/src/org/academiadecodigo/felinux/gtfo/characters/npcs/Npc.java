package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Npc class
 */
public abstract class Npc extends Character {


    private Picture npc;
    private  int routeX = 0;
    private  int routeY = 0;
    private int moveCounter;
    private boolean forward;
    private int distance = 100;
    private Rectangle redLifeBar;
    private Rectangle greenLifeBar;
    private Area area;
    private boolean dead;
    private int horizontalVertical = 0;

    public Npc(int posX, int posY, String spriteName, int direction) {

        horizontalVertical = direction;
        this.npc = new Picture(posX, posY, "resources/images/" + spriteName + ".png");
        this.area = new Area(getNpc().getX(),getNpc().getY(),getNpc().getWidth(),getNpc().getHeight());

        //hp animations
        this.redLifeBar = new Rectangle(posX - 9, posY - 8, 50, 7);
        this.redLifeBar.setColor(new Color(255, 0, 0));
        this.greenLifeBar = new Rectangle(posX - 9, posY - 8, 50, 7);
        this.greenLifeBar.setColor(new Color(0, 255, 0));

        defineRoute();
        defineDistance();
    }

    /**
     * Call this to add objects to the interactables list
     */
    @Override
    public void addToInteractables() {

        super.addToInteractables(area, this);
    }

    /**
     * Move all assaultable cat
     */
    @Override
    public void move() {

        if (isDead()) {
            return;
        }
        if (forward) {

            moveCounter++;
            getNpc().translate(routeX, routeY);
            area.getBoundArea().translate(routeX, routeY);
            redLifeBar.translate(routeX, routeY);
            greenLifeBar.translate(routeX, routeY);


            if (moveCounter > distance) {
                forward = false;
            }
            return;
        }

        moveCounter--;
        getNpc().translate(-routeX, -routeY);
        area.getBoundArea().translate(-routeX, -routeY);
        redLifeBar.translate(-routeX, -routeY);
        greenLifeBar.translate(-routeX, -routeY);

        if (moveCounter < 0) {
            forward = true;
        }
    }

    /**
     * Defines how this cat will move
     */
    private void defineRoute() {
        horizontalVertical++;
        if (horizontalVertical % 2 == 1) {

          routeY = 2;
            return;
        }

       routeX = 2;
    }

    public Picture getNpc() {
        return npc;
    }
    /**
     * Defines how long
     */
    private void defineDistance() {

        distance = (int) (Math.random() * 25 ) + 20;
    }


    public Rectangle getGreenLifeBar() {
        return greenLifeBar;
    }

    public Rectangle getRedLifeBar() {
        return redLifeBar;
    }

    public void takeDamage(){
        this.greenLifeBar.translate(-29,0);
    }

    public boolean isDead() {
        return dead;
    }
}