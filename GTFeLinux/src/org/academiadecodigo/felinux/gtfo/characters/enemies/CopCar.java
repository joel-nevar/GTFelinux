package org.academiadecodigo.felinux.gtfo.characters.enemies;

import org.academiadecodigo.felinux.gtfo.field.Field;

public class CopCar extends Enemy {

    public CopCar(Field copCarField, int posX, int posY, String spriteName) {
        super(copCarField, posX, posY, spriteName);

    }

    @Override
    public void move() {
        int count = 0;
        while (count < 10) {
            int random = (int) Math.floor(Math.random() * 5);
            System.out.println(random);
            switch (random) {
                case 0:
                    moveLeft();
                    count++;
                    break;
                case 1:
                    moveRight();
                    count++;
                    break;
                case 2:
                    moveUp();
                    count++;
                    break;
                default:
                    moveDown();
                    count++;
                    break;
            }
        }
    }
}
