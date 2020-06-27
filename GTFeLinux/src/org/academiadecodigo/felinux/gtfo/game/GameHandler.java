package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.moveable.player.Player;
import org.academiadecodigo.felinux.gtfo.characters.npcs.Npc;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class GameHandler implements Runnable{


    private Player player;
    private Enemy[] enemies = new Enemy[10];
    private Npc[] npcs = new Npc[10];
    private Field field;
    private Picture map;
    private Picture[] objects = new Picture[10];

    public GameHandler(Field field){

        this.field = field;
        this.map = new Picture(field.getPadding(),field.getPadding(),"resources/images/backGround.png");
        this.enemies[0] = new CopCar(field, 200,200,"AssaultableCat_1");
        this.player = new Player(field);
        this.objects[0] =  new Factory().gameObjectFactory(GameObjectType.MILK);
        field.showMap();
    }

    public void init(){

        field.showMap();
        player.getPlayer().draw();
        enemies[0].getEnemyField().draw();
        objects[0].draw();

        player.getEnergyBar().draw();
        player.getHpBar().draw();
        player.getEnergyAnimation().fill();
        player.getHpAnimation().fill();
        run();

    }

    @Override
    public void run() {

        while(!player.isDead()){
            try {
                Thread.sleep(15); //35
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            enemies[0].move();
            moveAll();
            player.energyDecay();
            moveAllEnemies();
        }
    }

    private void moveAllEnemies() {
    }

    private void moveAll() {

    }
}
