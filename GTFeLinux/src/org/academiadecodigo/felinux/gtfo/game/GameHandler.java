package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.moveable.player.Player;
import org.academiadecodigo.felinux.gtfo.characters.moveable.player.PlayerKeyboard;
import org.academiadecodigo.felinux.gtfo.characters.npcs.AssaultableCat;
import org.academiadecodigo.felinux.gtfo.characters.npcs.Npc;
import org.academiadecodigo.felinux.gtfo.characters.npcs.NpcType;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class GameHandler implements Runnable {


    private Player player;
    private Enemy[] enemies = new Enemy[10];
    private Field field;
    private Picture[] objects = new Picture[10];
    private PlayerKeyboard playerKeyboard;

    //Assautable cats amount and Array
    private final int ASSAULTABLE_CATS = 8;
    private Npc[] assaultableCats = new Npc[ASSAULTABLE_CATS];

    public void init() {

        this.field = new Field();
        this.enemies[0] = new CopCar(110, 300, "AssaultableCat_1");
        this.player = new Player("tobias.png");
        this.objects[0] = new Factory().gameObjectFactory(GameObjectType.MILK, 50, 65);
        this.playerKeyboard =  new PlayerKeyboard(player, enemies[0]);
        for (int i = 0; i < ASSAULTABLE_CATS; i++) {

            assaultableCats[i] = Factory.npcFactory(NpcType.ASSAULTABLE_CAT,(int) (Math.random()*field.getSizeCol()),(int) (Math.random()*field.getSizeRow()));
        }

        showAll();
        run();
    }

    private void showAll(){

        //Characters and Objects
        field.getMap().draw();
        player.getPlayer().draw();
        enemies[0].getEnemy().draw();
        enemies[0].getEnemyField().getArea().getShowArea().draw();
        objects[0].draw();

        //Npcs
        for (int i = 0; i < ASSAULTABLE_CATS; i++) {
            assaultableCats[i].getNpc().draw();
        }

        //player on top
        player.getPlayer().draw();
        //Assets / UI
        player.getEnergyBar().draw();
        player.getHpBar().draw();
        player.getEnergyAnimation().fill();
        player.getHpAnimation().fill();
        for (Area area : field.getNotWalkable()) {
            area.getShowArea().draw();
        }

    }

    @Override
    public void run() {

        while (!player.isDead()) {
            try {
                Thread.sleep(35); //35

                player.playerAttackVerification();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            moveAll();
        }
        System.out.println("GAME OVER");
    }


    private void moveAll() {
        player.move();
        player.energyDecay();
        enemies[0].move();
        //insert for loop to run enemies with an enemy counter, avoid nullpointer
        for (int i = 0; i < ASSAULTABLE_CATS; i++) {
            assaultableCats[i].move();
        }
    }
}
