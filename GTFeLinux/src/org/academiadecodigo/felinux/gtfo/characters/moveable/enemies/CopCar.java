package org.academiadecodigo.felinux.gtfo.characters.moveable.enemies;

import org.academiadecodigo.felinux.gtfo.field.Field;

public class CopCar extends Enemy {

    public CopCar(Field copCarField, int posX, int posY, String spriteName) {
        super(copCarField, posX, posY, spriteName);
    }

    @Override
    public void move() {

        if (super.isDead()) {
            return;
        }

        while (true){


        }

    }
}

