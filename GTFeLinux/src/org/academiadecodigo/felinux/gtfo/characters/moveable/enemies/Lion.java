package org.academiadecodigo.felinux.gtfo.characters.moveable.enemies;

import org.academiadecodigo.felinux.gtfo.field.Field;

public class Lion extends Enemy {

    public Lion(Field fieldOfLion) {
        super(fieldOfLion, 1000, 1000, "olá");
    }

    @Override
    public void move() {

        if(super.isDead()){
            return;
        }

        int random = (int) Math.floor(Math.random()*4);

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
