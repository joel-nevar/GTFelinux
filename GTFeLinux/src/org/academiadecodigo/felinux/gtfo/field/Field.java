package org.academiadecodigo.felinux.gtfo.field;

import org.academiadecodigo.felinux.gtfo.game.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.game.npcs.Npcs;
import org.academiadecodigo.felinux.gtfo.game.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

    public class Field {
        private Rectangle field;
        private static final int PADDING = 5;
        private static final int SIZE = 100;
        private static final int PIXEL = 2;
        private Player player;
        private Enemy[] enemy;
        private Npcs[] npcs;
        private SpriteType[] spriteTypes;


        public Field (Player player, Enemy[] enemy, Npcs[] npcs) {
            field = new Rectangle(PADDING,PADDING,SIZE,SIZE);
            field.setColor(Color.BLACK);
            this.player = player;
            this.enemy = enemy;
            this.npcs = npcs;
            this.spriteTypes = SpriteType.values();
            showMap();
        }

        public Field () {
            field = new Rectangle(PADDING,PADDING,SIZE,SIZE);
            field.setColor(Color.BLACK);
            field.draw();
        }


        /**
         *Show full map
         */
        private void showMap(){
            field.draw();
            drawField();
        }

        /**
         * fill sprites on the field
         */
        private void drawField(){
            for ( SpriteType sprite : spriteTypes) {

            }
        }

        public void makePosition(){

        }

        public int getCellSize() {
            return PIXEL;
        }

    /*public Enum TerranType{
        BLOCK1,
        BLOCK2
    }*/

    }
}
