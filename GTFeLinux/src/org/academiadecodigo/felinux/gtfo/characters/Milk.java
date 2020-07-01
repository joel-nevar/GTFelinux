package org.academiadecodigo.felinux.gtfo.characters;

import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Milk extends Character{


    private Picture milk;
    private final int posX = 1280; //1040
    private final int posY = 280;
    private Area area;

    public Milk(){

        this.milk = new Picture(posX, posY,"resources/images/Milk.png");
        this.area = new Area(milk.getX(),milk.getY(),milk.getWidth(),milk.getHeight());
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
