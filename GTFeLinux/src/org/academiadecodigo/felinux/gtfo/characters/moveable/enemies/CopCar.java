package org.academiadecodigo.felinux.gtfo.characters.moveable.enemies;

import org.academiadecodigo.felinux.gtfo.field.Field;

public class CopCar extends Enemy {

    public CopCar(Field copCarField, int posX, int posY, String spriteName) {
        super(copCarField, posX, posY, spriteName);
    }

    @Override
    public void move() {

        if (super.isDead()) {
            System.out.println("A cop car is now dead");
            return;
        }
        int random = (int) Math.floor(Math.random() * 4);

        switch (random) {
            case 0:
                moveLeft();
                System.out.println("Cop Here 0");
                break;
            case 1:
                moveRight();
                System.out.println("Cop Here 1");
                break;
            case 2:
                moveUp();
                System.out.println("Cop Here 2");
                break;
            default:
                moveDown();
                System.out.println("Cop Here 3");
                break;
        }
    }
}

