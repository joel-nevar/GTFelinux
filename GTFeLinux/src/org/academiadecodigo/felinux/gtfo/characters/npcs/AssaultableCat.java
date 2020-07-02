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
        //TODO - MEXER AQUI
    }

    private boolean robbed;

    @Override
    public String getMessage() {
        return "I am an Assaultable Cat";
    }

    public void takeDamage(){
        //Character, lose lives
        super.takeLethalDamage();
        //Npc make healthBar decrease
        super.takeDamage();
    }


    public boolean isRobbed() {
        return robbed;
    }

    @Override
    public Picture getNpc() {
        return super.getNpc();
    }
}