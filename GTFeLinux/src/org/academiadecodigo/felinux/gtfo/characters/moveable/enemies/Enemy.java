package org.academiadecodigo.felinux.gtfo.characters.moveable.enemies;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.moveable.DirectionType;
import org.academiadecodigo.felinux.gtfo.characters.moveable.Moveable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public abstract class Enemy extends Character implements Moveable {

    private EnemyAreaType enemyField;
    private boolean isDead = false;
    private Picture enemy;
    private DirectionType directionType = DirectionType.LEFT;
    private DirectionType lastDirectionType = DirectionType.RIGHT;


    public Enemy(EnemyAreaType enemyField, int posX, int posY, String spriteName, int lifeAmount) {
        super.setLives(lifeAmount);
        this.enemyField = enemyField;
        this.enemy = new Picture(posX, posY, "resources/images/" + spriteName + ".png");
    }

    //Used to draw the enemy
    public Picture getEnemy() {
        return enemy;
    }

    //Used to make a walkable area for the enemy
    public EnemyAreaType getEnemyField() {
        return enemyField;
    }

    //Moves the enemy randomly (not backwards)
    public void move() {
        if (isDead()) {
            return;
        }

        int random = (int) Math.floor(Math.random() * 4);

        switch (random) {
            case 0:
                moveLeft();
                break;
            case 1:
                moveRight();
                break;
            case 2:
                moveUp();
                break;
            default:
                moveDown();
                break;
        }
    }

    //Checks if the enemy is dead to make him disappear out of the game
    public boolean isDead() {
        return isDead;
    }

    //Makes the enemy die
    public void setDead() {
        isDead = true;
        System.out.println("Enemy déd");
    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    @Override
    public void moveLeft() {

        this.directionType = DirectionType.LEFT;

        if (this.lastDirectionType == DirectionType.RIGHT) {
            //aqui
            return;
        }

        if(enemyField.getArea().getxMin()  >= enemy.getX()){
            enemy.translate(field.getCellSize()*2,0);
            return;
        }
        enemy.translate(-field.getCellSize()*2,0);

        this.lastDirectionType = DirectionType.LEFT;
    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    @Override
    public void moveRight() {
        this.directionType = DirectionType.RIGHT;

        if (this.lastDirectionType == DirectionType.LEFT) {
            return;
        }

        if (enemyField.getArea().getxMax() <= enemy.getMaxX() - enemyField.getArea().getxMin()) {
            enemy.translate(-field.getCellSize() * 2, 0);
            return;
        }
        enemy.translate(field.getCellSize() * 2, 0);

        this.lastDirectionType = DirectionType.RIGHT;
    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    @Override
    public void moveUp() {
        this.directionType = DirectionType.UP;

        if (this.lastDirectionType == DirectionType.DOWN) {
            return;
        }

        if (enemyField.getArea().getyMin() >= enemy.getY()) {
            enemy.translate(0, field.getCellSize() * 2);
            return;
        }
        enemy.translate(0, -field.getCellSize() * 2);

        this.lastDirectionType = DirectionType.UP;
    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    @Override
    public void moveDown() {
        this.directionType = DirectionType.DOWN;

        if (this.lastDirectionType == DirectionType.UP) {
            return;
        }

        if (enemyField.getArea().getyMax() <= enemy.getMaxY() - enemyField.getArea().getyMin()) {
            enemy.translate(0, -field.getCellSize() * 2);
            return;
        }
        enemy.translate(0, field.getCellSize() * 2);

        this.lastDirectionType = DirectionType.DOWN;
    }
}
