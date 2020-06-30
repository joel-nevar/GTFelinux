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
import org.academiadecodigo.simplegraphics.graphics.Canvas;


public class GameHandler implements Runnable {

    private static Player player;
    private static Enemy[] enemies = new Enemy[10];
    private Npc[] npcs = new Npc[10];
    private Milk milk;
    private Field firstMap = new Field("FirstMap");
    private Field secondMap = new Field("SecondMap");
    //private Picture[] objects = new Picture[10];
    private PlayerKeyboard playerKeyboard;
    private static final int ASSAULTABLE_CATS = 8;
    private static Npc[] assaultableCats = new Npc[ASSAULTABLE_CATS];
    public static boolean firstMap = false;

    public void init() {
        field = new Field();
        //Creates everything that is visual in the Canvas
        this.milk = new Milk();
        // call this on the factory thx, also 350 on Y
        this.enemies[0] = new CopCar(110, 350, "AssaultableCat_1");
        this.player = new Player("tobias.png");
        this.playerKeyboard = new PlayerKeyboard(player, enemies[0]);

        for (int i = 0; i < ASSAULTABLE_CATS; i++) {
            assaultableCats[i] = Factory.npcFactory(NpcType.ASSAULTABLE_CAT, (int) (Math.random() * field.getSizeCol()), (int) (Math.random() * field.getSizeRow()));
        }

        showAlways();
        showAll();
        run();
    }

    private void showAlways(){

        /** First Game Map **/
         field.getMap().draw();

        /**Show Player**/
        player.getPlayer().draw();

        /** Second Game Map **/
        /** User Interface **/
        player.getEnergyBar().draw();
        player.getHpBar().draw();
        player.getEnergyAnimation().fill();
        player.getHpAnimation().fill();
    }

    private static void showAll() {

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
        for (Area area : field.getNotWalkable()) {
            area.getShowArea().draw();
        }

    }


    private static void hideAll() {

        /** First Game Map **/

        Canvas.getInstance().hide(milk.getMilk());

        /**NPCs**/
        for (int i = 0; i < ASSAULTABLE_CATS; i++) {
            Canvas.getInstance().hide(assaultableCats[i].getNpc());
            Canvas.getInstance().hide(((AssaultableCat) assaultableCats[i]).getRedLifeBar());
            Canvas.getInstance().hide(((AssaultableCat) assaultableCats[i]).getGreenLifeBar());
        }

        /**Characters **/
        //Make a for loop when more enemies here
        Canvas.getInstance().hide(enemies[0].getEnemy());
        Canvas.getInstance().hide(enemies[0].getEnemyField().getArea().getShowArea());
        Canvas.getInstance().hide(((CopCar) enemies[0]).getRedLifeBar());
        Canvas.getInstance().hide(((CopCar) enemies[0]).getGreenLifeBar());


        /**Assets**/
        for (Area area : field.getNotWalkable()) {
            Canvas.getInstance().hide(area.getShowArea());
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


    public static void changeMap() {

        if (firstMap == true) {

            Field.map.load("resources/images/SecondMap.png");
            hideAll();
            firstMap = false;
            return;
        }

        Field.map.load("resources/images/FirstMap.png");
        showAll();
        firstMap = true;
        }
    }

