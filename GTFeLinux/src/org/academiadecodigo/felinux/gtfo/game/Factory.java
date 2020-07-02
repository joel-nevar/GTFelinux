package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.enemies.EnemyType;
import org.academiadecodigo.felinux.gtfo.characters.enemies.CowBoss;
import org.academiadecodigo.felinux.gtfo.characters.npcs.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Factory extends Picture {

    public static Enemy enemyFactory(EnemyType enemyType, int posX, int posY, String image) {

        switch(enemyType) {
            case COP_CAR:
                return new CopCar(posX,posY, image); //SPECIAL CASE copCars Spawn on Y =350
             // CowBoss
            default:
                return new CowBoss(posX, posY, image);
        }
    }

    public static Npc npcFactory(NpcType npcType, int posX, int posY, int direction) {

        String image ="AssaultableCat_"+(int)Math.ceil(Math.random()*8);
        switch (npcType) {
            case ASSAULTABLE_CAT:
                return new AssaultableCat(posX, posY, image, direction);
            case CAT_PROSTITUTE:
                return new CatProstitute(posX, posY,"catpro", direction);
                // RAT
            default:
                return new Rat(posX, posY,"rat", direction);
        }
    }
}

