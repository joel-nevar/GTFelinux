package org.academiadecodigo.felinux.gtfo.characters.moveable.enemies;

import org.academiadecodigo.felinux.gtfo.field.Area;

public enum EnemyAreaType {

    LION(100,200,1200,400),
    COP_CAR(100,200,1200,400);

    private Area area;

    EnemyAreaType(int xMin, int yMin, int xMax, int yMax){
        area = new Area(xMin,yMin,xMax,yMax);
    }

    public Area getArea() {
        return area;
    }
}
