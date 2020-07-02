package org.academiadecodigo.felinux.gtfo.characters;

public enum CheckpointType {

    START(50, 300),
    CHECKPOINT1(1, 1),
    CHECKPOINT2(2, 2),
    CHECKPOINT3(3, 3),
    CHECKPOINT4(4, 4);

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

