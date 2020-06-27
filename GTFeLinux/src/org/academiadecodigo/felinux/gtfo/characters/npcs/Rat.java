package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.field.Field;

/**
 * Rat production
 */
public class Rat extends Enemy {



    public Rat(Field field, int posX, int posY){

        super(field, posX, posY, "");

    }


    /**
     * Movement responsibility
     */
    public void move() {

        if (!super.isDead()) {
            return;
        }

        int random = (int) Math.floor(Math.random() * 4);

        switch (random) {
            case 0:
                moveLeft();
                break;
            case 1:
                moveRight();
                break;
            case 2:
                moveUp();
                break;
            default:
                moveDown();
                break;
        }
    }
}
