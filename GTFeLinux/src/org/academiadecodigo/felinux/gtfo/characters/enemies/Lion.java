package org.academiadecodigo.felinux.gtfo.characters.enemies;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Lion extends Enemy {


    private Rectangle redLifeBar;
    private Rectangle greenLifeBar;

    public Lion(int posX, int posY, String spriteName) {

        super(EnemyAreaType.LION, posX, posY, spriteName, 10);

        //hp animation stuff
        this.redLifeBar = new Rectangle(posX - 9, posY - 8, 50,7);
        this.redLifeBar.setColor(new Color(255,0,0));
        this.greenLifeBar = new Rectangle(posX - 9, posY - 8, 50,7);
        this.greenLifeBar.setColor(new Color(0,255,0));
    }
    public Rectangle getGreenLifeBar() {
        return greenLifeBar;
    }

    public Rectangle getRedLifeBar() {
        return redLifeBar;
    }

}
