package org.academiadecodigo.felinux.gtfo.characters.moveable.enemies;

import org.academiadecodigo.felinux.gtfo.characters.moveable.DirectionType;
import org.academiadecodigo.felinux.gtfo.characters.moveable.Moveable;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;



public abstract class Enemy implements Moveable {


    private int speed;
    private int life = 10;
    private Field enemyField;
    private boolean isDead = false;
    private Picture enemyImage;
    private DirectionType directionType = DirectionType.LEFT;
    private DirectionType lastDirectionType = DirectionType.RIGHT;

    public Enemy(Field enemyField, int posX, int posY, String spriteName){
        this.enemyField = enemyField;
        this.enemyImage = new Picture(posX,posY,"resources/images/" + spriteName + ".png");
    }

    public Picture getEnemyImage() {
        return enemyImage;
    }

    public Picture getPosition() {
        return this.enemyImage;
    }

    public Field getEnemyField() {
        return enemyField;
    }

    public void move(){}

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isDead() {
        return isDead;
    }

    @Override
    public void moveLeft() {

        this.directionType = DirectionType.LEFT;

        if(this.lastDirectionType == DirectionType.RIGHT){
            //System.out.println("This Direction is: " + DirectionType.LEFT + " Last Direction was: " + DirectionType.RIGHT);
            return;
        }

        if(this.enemyField.getPadding()  >= enemyImage.getX()){
            enemyImage.translate(enemyField.getCellSize()*2,0);
            return;
        }
        enemyImage.translate(-enemyField.getCellSize()*2,0);

        this.lastDirectionType = DirectionType.LEFT;
    }

    @Override
    public void moveRight() {
        this.directionType = DirectionType.RIGHT;

        if(this.lastDirectionType == DirectionType.LEFT){
            System.out.println("This Direction is: " + directionType + " Last Direction was: " + lastDirectionType);
            return;
        }

        if(this.enemyField.getSizeCol() <= enemyImage.getMaxX() - this.enemyField.getPadding()){
            enemyImage.translate(-enemyField.getCellSize()*2,0);
            return;
        }
        enemyImage.translate(enemyField.getCellSize()*2,0);

        this.lastDirectionType = DirectionType.RIGHT;
    }

    @Override
    public void moveUp() {
        this.directionType = DirectionType.UP;

        if(this.lastDirectionType == DirectionType.DOWN){
            System.out.println("This Direction is: " + directionType + " Last Direction was: " + lastDirectionType);
            return;
        }

        if(this.enemyField.getPadding() >= enemyImage.getY()){
            enemyImage.translate(0,enemyField.getCellSize()*2);
            return;
        }
        enemyImage.translate(0,-enemyField.getCellSize()*2);

        this.lastDirectionType = DirectionType.UP;
    }

    @Override
    public void moveDown() {
        this.directionType = DirectionType.DOWN;

        if(this.lastDirectionType == DirectionType.UP){
            System.out.println("This Direction is: " + directionType + " Last Direction was: " + lastDirectionType);
            return;
        }

        if(this.enemyField.getSizeRow() <= enemyImage.getMaxY() - this.enemyField.getPadding()){
            enemyImage.translate(0,-enemyField.getCellSize()*2);
            return;
        }
        enemyImage.translate(0,enemyField.getCellSize()*2);

        this.lastDirectionType = DirectionType.DOWN;
    }
}
