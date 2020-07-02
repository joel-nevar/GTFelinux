package org.academiadecodigo.felinux.gtfo.characters;

public enum CheckpointType {

    START(50, 300),
    CHECKPOINT1(390, 540),
    CHECKPOINT2(800, 96),
    CHECKPOINT3(1124, 465),
    CHECKPOINTMAP2(974, 339);


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

