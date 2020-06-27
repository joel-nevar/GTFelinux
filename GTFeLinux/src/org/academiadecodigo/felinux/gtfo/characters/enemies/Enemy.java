package org.academiadecodigo.felinux.gtfo.characters.enemies;

import org.academiadecodigo.felinux.gtfo.characters.Moveable;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;



public abstract class Enemy implements Moveable {

    private int speed;
    private Field enemyField;
    private boolean isDead = false;
    private Picture enemyImage;

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

    public boolean isDead() {
        return isDead;
    }

    @Override
    public void moveLeft() {
        if(this.enemyField.getPadding()  > enemyImage.getX()){
            enemyImage.translate(enemyField.getCellSize() * 2,0);
            return;
        }
        enemyImage.translate(-enemyField.getCellSize() * 2 ,0);
    }

    @Override
    public void moveRight() {
        if(this.enemyField.getSizeCol() < enemyImage.getMaxX() - this.enemyField.getPadding()){
            enemyImage.translate(-enemyField.getCellSize() * 2,0);
            return;
        }
        enemyImage.translate(enemyField.getCellSize() ,0);
    }

    @Override
    public void moveUp() {
        if(this.enemyField.getPadding() > enemyImage.getY()){
            enemyImage.translate(0,enemyField.getCellSize() * 2 );
            return;
        }
        enemyImage.translate(0,-enemyField.getCellSize() * 2 );
    }

    @Override
    public void moveDown() {
        if(this.enemyField.getSizeRow() < enemyImage.getMaxY() - this.enemyField.getPadding()){
            enemyImage.translate(0,-enemyField.getCellSize() * 2);
            return;
        }
        enemyImage.translate(0,enemyField.getCellSize());
    }
}
