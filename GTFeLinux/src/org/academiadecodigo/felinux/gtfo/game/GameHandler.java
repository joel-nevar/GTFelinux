package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.moveable.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.moveable.player.Player;
import org.academiadecodigo.felinux.gtfo.characters.moveable.player.PlayerKeyboard;
import org.academiadecodigo.felinux.gtfo.characters.npcs.Npc;
import org.academiadecodigo.felinux.gtfo.characters.npcs.NpcType;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class GameHandler implements Runnable {


    private Player player;
    private Enemy[] enemies = new Enemy[10];
    private Npc[] npcs = new Npc[10];
    private Field field;
    private Picture[] objects = new Picture[10];
    private final PlayerKeyboard playerKeyboard;

    public void init() {

        this.field = new Field();
        this.enemies[0] = new CopCar(110, 300, "AssaultableCat_1");
        this.player = new Player("tobias.png");
        this.objects[0] = new Factory().gameObjectFactory(GameObjectType.MILK, 50, 65);
        this.playerKeyboard =  new PlayerKeyboard(player, enemies[0]);
        for (int i = 0; i < 7; i++) {

            this.npcs[i] = Factory.npcFactory(NpcType.ASSAULTABLE_CAT,(int) (Math.random()*field.getSizeCol()),(int) (Math.random()*field.getSizeRow()),"AssaultableCat_"+(i+1)); {
            }
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
                //Animacao de atacar
                if(player.isClawUsed() == true){
                    player.getClawAnimation().draw();
                    player.setClawTick(player.getClawTick() + 1);
                    if(player.getClawTick() == 4){
                        System.out.println("ou entao aqui");
                        player.setClawUsed(false);
                        player.getClawAnimation().delete();
                        player.setClawTick(0);
                    }
                }
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

    }
}
