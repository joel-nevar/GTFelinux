package org.academiadecodigo.felinux.gtfo.characters.npcs;

public class AssaultableCat extends Npc {


    private boolean robbed;
    private boolean dead;

    @Override
    public String getMessage() {
        return "I am an Assaultable Cat";
    }

    public AssaultableCat(int posX, int posY, String spriteName) {
        super(posX, posY, spriteName);
    }


    public boolean isRobbed() {
        return robbed;
    }

    public boolean isDead() {
        return dead;
    }


}
