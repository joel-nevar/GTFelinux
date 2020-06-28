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
    private Picture enemy;
    private DirectionType directionType = DirectionType.LEFT;
    private DirectionType lastDirectionType = DirectionType.RIGHT;


    public Enemy(Field enemyField, int posX, int posY, String spriteName){
        this.enemyField = enemyField;
        this.enemy = new Picture(posX,posY,"resources/images/" + spriteName + ".png");
    }

    public Picture getEnemy() {
        return enemy;
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
            return;
        }

        if(this.enemyField.getPadding()  >= enemy.getX()){
            enemy.translate(enemyField.getCellSize()*2,0);
            return;
        }
        enemy.translate(-enemyField.getCellSize()*2,0);

        this.lastDirectionType = DirectionType.LEFT;
    }

    @Override
    public void moveRight() {
        this.directionType = DirectionType.RIGHT;

        if(this.lastDirectionType == DirectionType.LEFT){
            return;
        }

        if(this.enemyField.getSizeCol() <= enemy.getMaxX() - this.enemyField.getPadding()){
            enemy.translate(-enemyField.getCellSize()*2,0);
            return;
        }
        enemy.translate(enemyField.getCellSize()*2,0);

        this.lastDirectionType = DirectionType.RIGHT;
    }

    @Override
    public void moveUp() {
        this.directionType = DirectionType.UP;

        if(this.lastDirectionType == DirectionType.DOWN){
            return;
        }

        if(this.enemyField.getPadding() >= enemy.getY()){
            enemy.translate(0,enemyField.getCellSize()*2);
            return;
        }
        enemy.translate(0,-enemyField.getCellSize()*2);

        this.lastDirectionType = DirectionType.UP;
    }

    @Override
    public void moveDown() {
        this.directionType = DirectionType.DOWN;

        if(this.lastDirectionType == DirectionType.UP){
            return;
        }

        if(this.enemyField.getSizeRow() <= enemy.getMaxY() - this.enemyField.getPadding()){
            enemy.translate(0,-enemyField.getCellSize()*2);
            return;
        }
        enemy.translate(0,enemyField.getCellSize()*2);

        this.lastDirectionType = DirectionType.DOWN;
    }
}
