package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.field.Position;
import org.academiadecodigo.felinux.gtfo.field.SpriteType;

public class AssaultableCat extends Npc {
    private boolean robbed;
    private boolean dead;



    public boolean isRobbed() {
        return robbed;
    }

    public boolean isDead() {
        return dead;
    }


    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public void setCol(int column) {

    }

    @Override
    public void setRow(int row) {

    }

    @Override
    public SpriteType getSprite() {
        return null;
    }
}
