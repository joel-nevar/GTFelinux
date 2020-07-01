package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Npc extends Character {

    private Picture npc;
    private int routeX;
    private int routeY;
    private int moveCounter;
    private boolean forward;
    private int distance = 100;
    private Rectangle redLifeBar;
    private Rectangle greenLifeBar;
    private boolean dead;

    public Npc(int posX, int posY, String spriteName) {

        this.npc = new Picture(posX, posY, "resources/images/" + spriteName + ".png");
        this.redLifeBar = new Rectangle(posX - 9, posY - 8, 50, 7);
        this.redLifeBar.setColor(new Color(255, 0, 0));
        this.greenLifeBar = new Rectangle(posX - 9, posY - 8, 50, 7);
        this.greenLifeBar.setColor(new Color(0, 255, 0));

        defineRoute();
        defineDistance();
        defineDirection();
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
            redLifeBar.translate(routeX, routeY);
            greenLifeBar.translate(routeX, routeY);

            if (moveCounter > distance) {
                forward = false;
            }
            return;
        }
        moveCounter--;
        getNpc().translate(-routeX, -routeY);
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

        if (Math.ceil(Math.random() * 2) == 2) {

            routeX = 1;
            return;

        }
        routeY = 1;
    }

    /**
     * Defines how long
     */
    private void defineDistance() {

        distance = (int) (Math.random() * 120) + 50;
    }

    /**
     * Defines this cat direction
     */
    private void defineDirection() {

        if (Math.random() < 0.5) {
            forward = true;
            return;
        }
        forward = false;
    }

    public Picture getNpc() {
        return npc;
    }


    public Rectangle getGreenLifeBar() {
        return greenLifeBar;
    }

    public Rectangle getRedLifeBar() {
        return redLifeBar;
    }



    public boolean isDead() {
        return dead;
    }
}