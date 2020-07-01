package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Assaultable cats
 */
public class AssaultableCat extends Npc {

    public AssaultableCat (int posX, int posY, String spriteName) {
        super(posX, posY, spriteName);
    }

    private boolean robbed;


    //control the route taken


    @Override
    public String getMessage() {
        return "I am an Assaultable Cat";
    }


    public boolean isRobbed() {
        return robbed;
    }

    @Override
    public Picture getNpc() {
        return super.getNpc();
    }


}