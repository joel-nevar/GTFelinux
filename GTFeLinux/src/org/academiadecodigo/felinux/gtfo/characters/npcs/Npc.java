package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Npc extends Character {

    private Picture npc;

    public Npc(int posX, int posY, String spriteName){
            this.npc = new Picture(posX,posY,"resources/images/" + spriteName + ".png");
        }



    public Picture getNpc() {
        return npc;
    }
}
