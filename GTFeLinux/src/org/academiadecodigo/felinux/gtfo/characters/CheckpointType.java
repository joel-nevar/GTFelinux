package org.academiadecodigo.felinux.gtfo.characters;

public enum CheckpointType {

    START(50, 300),
    CHECKPOINT1(390, 540),
    CHECKPOINT2(90, 800);

    int dx;
    int dy;


    CheckpointType(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}

