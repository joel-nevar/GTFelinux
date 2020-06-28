package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.EnemyType;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Lion;
import org.academiadecodigo.felinux.gtfo.characters.npcs.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Factory extends Picture {

    public static Enemy enemyFactory(EnemyType enemyType, int posX, int posY, String image) {

        switch(enemyType) {
            case COP_CAR:
                return new CopCar(posX, posY, image);
            case LION:
             default:return new Lion(posX, posY, image);
        }
    }

    public static Npc npcFactory(NpcType npcType, int posX, int posY) {

        String image;
        switch (npcType) {

            case ASSAULTABLE_CAT:
                image ="AssaultableCat_"+(int)Math.ceil(Math.random()*8);
                return new AssaultableCat(posX, posY, image);
            case CAT_PROSTITUTE:
                image = "";
                return new CatProstitute(posX, posY, image);
            case RAT:

            default:
                image = "";
                return new Rat(posX, posY, image);
        }
    }
}

