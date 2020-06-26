package org.academiadecodigo.felinux.gtfo.characters.enemies;

import org.academiadecodigo.felinux.gtfo.field.Field;

public class CopCar extends Enemy {

    public CopCar(Field copCarField, int posX, int posY, String spriteName) {
        super(copCarField, posX, posY, spriteName);

    }

    @Override
    public void move() {
        int random = (int) Math.random()*5;
        switch (random){
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
