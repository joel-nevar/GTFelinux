package org.academiadecodigo.felinux.gtfo.characters.enemies;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.DirectionType;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public abstract class Enemy extends Character{


    private EnemyAreaType enemyField;
    private boolean dead = false;
    private Picture enemy;
    private Area area;
    private Character name;

    private DirectionType lastDirectionType = DirectionType.STOP;


    public Enemy(EnemyAreaType enemyField, int posX, int posY, String spriteName, int lifeAmount) {

        super.setLives(lifeAmount);
        this.enemyField = enemyField;
        this.enemy = new Picture(posX, posY, "resources/images/" + spriteName + ".png");
        this.area = new Area(getEnemy().getX(),getEnemy().getY(), getEnemy().getWidth(), getEnemy().getHeight());
    }

    /**
     * Call this to add objects to the interactables list
     */
    @Override
    public void addToInteractables() {

        super.addToInteractables(area, name);
    }

    //Area for collisions and interactions

    public Area getArea() {
        return area;
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
    @Override
    public void move(){

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
        return dead;
    }

    //Makes the enemy die
    public void setDead() {
        dead = true;
        System.out.println("Enemy déd");
    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    public void moveLeft() {

        if (this.lastDirectionType == DirectionType.RIGH) {
            return;
        }

        if(enemyField.getArea().getX()  >= enemy.getX()){
            enemy.translate(Field.getCellSize()*2,0);
            return;
        }
        enemy.translate(-Field.getCellSize()*2,0);

        this.lastDirectionType = DirectionType.LEFT;
    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    public void moveRight() {

        if (this.lastDirectionType == DirectionType.LEFT) {
            return;
        }

        if (enemyField.getArea().getxSize() <= enemy.getMaxX() - enemyField.getArea().getX()) {
            enemy.translate(-Field.getCellSize() * 2, 0);
            return;
        }
        enemy.translate(Field.getCellSize() * 2, 0);

        lastDirectionType = DirectionType.RIGH;
    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    public void moveUp() {

        if (this.lastDirectionType == DirectionType.DOWN) {
            return;
        }

        if (enemyField.getArea().getY() >= enemy.getY()) {
            enemy.translate(0, Field.getCellSize() * 2);
            return;
        }
        enemy.translate(0, -Field.getCellSize() * 2);

        this.lastDirectionType = DirectionType.UP;
    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    public void moveDown() {

        if (this.lastDirectionType == DirectionType.UP) {
            return;
        }

        if (enemyField.getArea().getySize() <= enemy.getMaxY() - enemyField.getArea().getY()) {
            enemy.translate(0, -Field.getCellSize() * 2);
            return;
        }
        enemy.translate(0, Field.getCellSize() * 2);

        this.lastDirectionType = DirectionType.DOWN;
    }
}
