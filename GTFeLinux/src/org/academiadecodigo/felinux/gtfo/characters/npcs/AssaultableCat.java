package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Assaultable cats
 */
public class AssaultableCat extends Npc {

    private boolean robbed;

    public AssaultableCat (int posX, int posY, String spriteName, int direction) {
        super(posX, posY, spriteName, direction);
    }

    @Override
    public void interact() {
        //TODO - MEXER AQUI
    }

    @Override
    public String getMessage() {
        return "I am an Assaultable Cat";
    }

    public void takeDamage(){
        //Character, lose lives
        super.takeLethalDamage();
    }


    public boolean isRobbed() {
        return robbed;
    }

    @Override
    public Picture getNpc() {
        return super.getNpc();
    }
}