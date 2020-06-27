package org.academiadecodigo.felinux.gtfo.characters.moveable.enemies;

import org.academiadecodigo.felinux.gtfo.field.Field;

public class Lion extends Enemy {

    public Lion(Field fieldOfLion) {
        super(fieldOfLion, 1000, 1000, "olá");
    }

    @Override
    public void move() {

        if(super.isDead()){
            System.out.println("A cop car is now dead");
            return;
        }

        int random = (int) Math.floor(Math.random()*4);

        switch (random){
            case 0:
                moveLeft();
                System.out.println("Lion Here 0");
                break;
            case 1:
                moveRight();
                System.out.println("Lion Here 1");
                break;
            case 2:
                moveUp();
                System.out.println("Lion Here 2");
                break;
            default:
                moveDown();
                System.out.println("Lion Here 3");
                break;
        }
    }
}
