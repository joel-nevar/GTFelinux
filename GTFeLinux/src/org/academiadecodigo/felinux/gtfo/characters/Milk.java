package org.academiadecodigo.felinux.gtfo.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Milk extends Picture{

    private Picture milk;
    private final int posX = 1040; //1040
    private final int posY = 50;

    public Milk(){
        this.milk = new Picture(posX, posY,"resources/images/Milk.png");
    }

    //Used to draw the Milk on the map
    public Picture getMilk() {
        return milk;
    }
    //Used to delete the Milk when the player catches it
    public void drinkMeTillIDisappear(){
        this.milk.delete();
    }
}
