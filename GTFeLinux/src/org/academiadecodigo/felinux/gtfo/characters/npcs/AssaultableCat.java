package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Assaultable cats
 */
public class AssaultableCat extends Npc {

    public AssaultableCat (int posX, int posY, String spriteName, int direction) {
        super(posX, posY, spriteName, direction);
    }

    @Override
    public void interact() {
        //Do nothing
    }

    @Override
    public Picture getNpc() {
        return super.getNpc();
    }
}