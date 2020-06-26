package org.academiadecodigo.felinux.gtfo.field;

public enum GameObjectType {
    MILK(),
    BUSH(),
    WOODEN_BOX();

    private pos;

    GameObjectType(Position pos){
        this.pos = pos;
    }
}
