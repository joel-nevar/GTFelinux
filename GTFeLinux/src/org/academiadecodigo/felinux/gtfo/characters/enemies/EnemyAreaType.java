package org.academiadecodigo.felinux.gtfo.characters.enemies;

import org.academiadecodigo.felinux.gtfo.field.Area;

public enum EnemyAreaType {

    LION(5,290,1320,295),
    COP_CAR(5,347,1315,100);

    private Area area;

    EnemyAreaType(int xMin, int yMin, int xMax, int yMax){
        area = new Area(xMin,yMin,xMax,yMax);
    }

    public Area getArea() {
        return area;
    }
}
