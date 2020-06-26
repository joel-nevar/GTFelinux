package org.academiadecodigo.felinux.gtfo.field;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum GameObjectType {

    MILK(0, 0, "Milk"),
    BUSH(0, 0, "BUSH"),
    WOODEN_BOX(0, 0, "BOX");

    private Picture picture;
    private boolean hasMilk = false;

    GameObjectType(int X, int Y, String image) {
        this.picture = new Picture(X, Y, image);

    }

    private boolean hasMilk() {
        return hasMilk;
    }

    public void setHasMilk(boolean hasMilk) {
        this.hasMilk = hasMilk;
    }
}
