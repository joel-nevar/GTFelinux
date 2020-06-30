package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.Milk;
import org.academiadecodigo.felinux.gtfo.characters.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.player.Player;
import org.academiadecodigo.felinux.gtfo.characters.player.PlayerKeyboard;
import org.academiadecodigo.felinux.gtfo.characters.npcs.AssaultableCat;
import org.academiadecodigo.felinux.gtfo.characters.npcs.Npc;
import org.academiadecodigo.felinux.gtfo.characters.npcs.NpcType;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.felinux.gtfo.field.Field;


public class GameHandler implements Runnable {

    private Player player;
    private Enemy[] enemies = new Enemy[10];
    private Npc[] npcs = new Npc[10];
    private Milk milk;
    private Field secondMap = new Field("SecondMap");
    private Field firstMap = new Field("FirstMap");
    //private Picture[] objects = new Picture[10];
    private PlayerKeyboard playerKeyboard;
    private final int ASSAULTABLE_CATS = 8;
    private Npc[] assaultableCats = new Npc[ASSAULTABLE_CATS];

    public void init() {
        //Creates everything that is visual in the Canvas
        this.milk = new Milk();
        // call this on the factory thx, also 350 on Y
        this.enemies[0] = new CopCar(110, 350, "AssaultableCat_1");
        this.player = new Player("tobias.png");
        this.playerKeyboard =  new PlayerKeyboard(player, enemies[0]);

        for (int i = 0; i < ASSAULTABLE_CATS; i++) {
            assaultableCats[i] = Factory.npcFactory(NpcType.ASSAULTABLE_CAT,(int) (Math.random()* firstMap.getSizeCol()),(int) (Math.random()* firstMap.getSizeRow()));
        }

        showAll();
        run();
    }

    private void showAll(){

        if(firstMap.isDrawed()) {

            /** First Game Map **/
            firstMap.getMap().draw();
            System.out.println("first map drawed");
            //Objects
            milk.getMilk().draw();

            /**NPCs**/
            for (int i = 0; i < ASSAULTABLE_CATS; i++) {
                assaultableCats[i].getNpc().draw();
                ((AssaultableCat) assaultableCats[i]).getRedLifeBar().fill();
                ((AssaultableCat) assaultableCats[i]).getGreenLifeBar().fill();
            }

            /**Characters **/
            //Make a for loop when more enemies here
            enemies[0].getEnemy().draw();
            enemies[0].getEnemyField().getArea().getShowArea().draw();
            ((CopCar) enemies[0]).getRedLifeBar().fill();
            ((CopCar) enemies[0]).getGreenLifeBar().fill();

            player.getPlayer().draw();

            /**Assets**/
            for (Area area : firstMap.getNotWalkable()) {
                area.getShowArea().draw();
            }
        }
        /** Second Game Map **/
        if(!firstMap.isDrawed()) {
            //Desenhar outras coisas && esconder tudo o resto atras, provavelmente
            firstMap.getMap().delete();
            secondMap.getMap().draw();
            System.out.println("first map deleted, second drawed");
        }
        /** User Interface **/
        player.getEnergyBar().draw();
        player.getHpBar().draw();
        player.getEnergyAnimation().fill();
        player.getHpAnimation().fill();
    }

    @Override
    public void run() {
        //Game loop to create movement
        while (!player.isDead()) {
            try {

                Thread.sleep(35);

                //Check if player is attacking
                player.playerAttackVerification();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Moves all the movable classes
            moveAll();
        }
        System.out.println("GAME OVER");
    }


    private void moveAll() {
        player.move();
        player.energyDecay();
        enemies[0].move();

        //insert for loop to run enemies with an enemy counter to avoid a Null Pointer
        for (int i = 0; i < ASSAULTABLE_CATS; i++) {
            assaultableCats[i].move();
        }
    }
}
