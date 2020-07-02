package org.academiadecodigo.felinux.gtfo.characters.enemies;

import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class CowBoss extends Enemy {


    private Rectangle redLifeBar;
    private Rectangle greenLifeBar;
    private int movementCounter = 0;

    public CowBoss(int posX, int posY, String spriteName) {

        super(EnemyAreaType.COW_BOSS, posX, posY, spriteName, 10);

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

    @Override
    public void move(){

        if (isDead()) {
            return;
        }



        if(movementCounter < 25) {
            this.moveUp();
            movementCounter++;
         return;
        }

        this.moveDown();
        movementCounter++;

        if (movementCounter > 50){
            movementCounter = 0;
        }
    }
    @Override
    public void moveUp() {

        if (enemyField.getArea().getY() >= getEnemy().getY()) {
            System.out.println("Entra cima");
            getEnemy().translate(0, Field.getCellSize() * 2);
            return;
        }
        System.out.println("nao entra cima");
        getEnemy().translate(0, -Field.getCellSize() * 2);

    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    @Override
    public void moveDown() {

        if (enemyField.getArea().getySize() <= getEnemy().getMaxY() - enemyField.getArea().getY()) {
            System.out.println("Entra baixo");
            getEnemy().translate(0, -Field.getCellSize() * 2);
            return;
        }
        System.out.println("NAo entao baixo");
        getEnemy().translate(0, Field.getCellSize() * 2);


    }

}
