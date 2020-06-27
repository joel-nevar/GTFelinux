package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.GameObjectType;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.EnemyType;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Lion;
import org.academiadecodigo.felinux.gtfo.characters.moveable.player.Player;
import org.academiadecodigo.felinux.gtfo.characters.moveable.player.PlayerType;
import org.academiadecodigo.felinux.gtfo.characters.npcs.AssaultableCat;
import org.academiadecodigo.felinux.gtfo.characters.npcs.NpcType;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Factory extends Picture{

    public static Picture gameObjectFactory(GameObjectType gameObject) {

        switch (gameObject) {

            case MILK:
                Picture picture = new Picture(70, 70, "resources/images/tile000.png");
                return picture;

            case BUSH:

                return new Picture(50, 50, "BUSH");


            case WOODEN_BOX:

                return new Picture(50, 50, "WOODEN BOX");


            case STAIRS:

                return new Picture(50, 50, "STAIRS");


            default:
            case SAND:

                return new Picture(50, 50, "SAND");

        }

    }

    public static Picture playerFactory (PlayerType playerType) {
       return new Player();
    }
        public static Picture enemyFactory(EnemyType enemyType) {
        return new Lion();
        }
            public static Picture npcFactory(NpcType npcType) {
                return new AssaultableCat();
            }

}
