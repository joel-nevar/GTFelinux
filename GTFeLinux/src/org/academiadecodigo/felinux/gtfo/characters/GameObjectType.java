package org.academiadecodigo.felinux.gtfo.characters;

import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

    public enum GameObjectType {

        MILK(50, 50,"resources/images/tile000.png"),
        BUSH(0, 0, "BUSH"),
        WOODEN_BOX(0, 0, "BOX"),
        SAND(0,0,"SAND"),
        STAIRS(0,0, "STAIRS");




        private boolean hasMilk = false;
        private int X;
        private int Y;
        private Field field;
        private Picture picture;



        GameObjectType(int X, int Y,String image) {

        }


        public void setField(Field field) {
            this.field = field;
        }


        public void setX(int x) {
            this.X = x;
        }

        public void setY(int y) {
            this.Y = y;
        }

        private boolean hasMilk() {
            return hasMilk;
        }

        public void setHasMilk(boolean hasMilk) {
            this.hasMilk = hasMilk;
        }
    }

