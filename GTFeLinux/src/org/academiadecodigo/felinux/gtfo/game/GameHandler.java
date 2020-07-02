package org.academiadecodigo.felinux.gtfo.game;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.characters.Milk;
import org.academiadecodigo.felinux.gtfo.characters.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.characters.enemies.EnemyType;
import org.academiadecodigo.felinux.gtfo.characters.enemies.Lion;
import org.academiadecodigo.felinux.gtfo.characters.player.Player;
import org.academiadecodigo.felinux.gtfo.characters.player.PlayerKeyboard;
import org.academiadecodigo.felinux.gtfo.characters.npcs.AssaultableCat;
import org.academiadecodigo.felinux.gtfo.characters.npcs.Npc;
import org.academiadecodigo.felinux.gtfo.characters.npcs.NpcType;
import org.academiadecodigo.felinux.gtfo.field.Area;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.HashMap;


public class GameHandler implements Runnable {


    private static Player player;
    private static Enemy[] enemies = new Enemy[10];
    private static Npc[] rats = new Npc[5];
    private static Milk milk;
    private static Field field;
    private  static Picture oldLady ;
    private PlayerKeyboard playerKeyboard;
    private static final int ASSAULTABLE_CATS = 13;
    private static Npc[] assaultableCats = new Npc[ASSAULTABLE_CATS];
    public static boolean firstMap = true;


    public static HashMap<Area, Character> hashMap;
    private static final int INTERACT_RANGE = 25;

    public void init() {

        field = new Field();
        GameSound.BACKMUSIC.sounds.play(true);
        //Creates everything that is visual in the Canvas
        this.milk = new Milk();
        // call this on the factory thx, also 350 on Y
        this.enemies[0] = new CopCar(110, 350, "AssaultableCat_1");
        this.player = new Player("tobias.png");
        this.playerKeyboard = new PlayerKeyboard(player, enemies[0]);
        this.oldLady = new Picture(120,70,"resources/images/OldLady.png");




        //interaction
        hashMap = new HashMap<>();
    }

    public void startGame() {

        GameSound.BACKMUSIC.sounds.play(!player.isDead());
        instanceOfAssaultableCats(assaultableCats);
        instanceOfEnemies(enemies);
        instanceOfRats(rats);
        addInteractables();
        showAlways();
        showAllMap1();
        run();
    }

    private void addInteractables() {

        for (Npc rat : rats) {
            rat.addToInteractables();
        }

        for (Npc cat : assaultableCats) {
            cat.addToInteractables();
        }


    }

    private void showAlways() {

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

    private static void showAllMap1() {

        //Objects

        /**NPCs**/
        for (int i = 0; i < ASSAULTABLE_CATS; i++) {
            assaultableCats[i].getNpc().draw();
            assaultableCats[i].getRedLifeBar().fill();
            assaultableCats[i].getGreenLifeBar().fill();
        }

        /**Characters **/
        //Make a for loop when more enemies here
        enemies[0].getEnemy().draw();
        enemies[0].getEnemyField().getArea().getBoundArea().draw();
        ((CopCar) enemies[0]).getRedLifeBar().fill();
        ((CopCar) enemies[0]).getGreenLifeBar().fill();


        player.getPlayer().draw();
        oldLady.draw();
        /**Assets**/
        for (Area area : field.getNotWalkable()) {
            area.getBoundArea().draw();
        }
    }

    private static void hideAllMap1() {

        /** First Game Map **/

        Canvas.getInstance().hide(milk.getMilk());

        /**NPCs**/
        for (int i = 0; i < ASSAULTABLE_CATS; i++) {
            Canvas.getInstance().hide(assaultableCats[i].getNpc());
            Canvas.getInstance().hide(assaultableCats[i].getRedLifeBar());
            Canvas.getInstance().hide(assaultableCats[i].getGreenLifeBar());
        }

        /**Characters **/
        //Make a for loop when more enemies here
        Canvas.getInstance().hide(enemies[0].getEnemy());
        Canvas.getInstance().hide(enemies[0].getEnemyField().getArea().getBoundArea());
        Canvas.getInstance().hide(((CopCar) enemies[0]).getRedLifeBar());
        Canvas.getInstance().hide(((CopCar) enemies[0]).getGreenLifeBar());


        /**Assets**/
        for (Area area : field.getNotWalkable()) {
            Canvas.getInstance().hide(area.getBoundArea());
        }
        /** User Interface **/
        player.getEnergyBar().draw();
        player.getHpBar().draw();
        player.getEnergyAnimation().fill();
        player.getHpAnimation().fill();

        Canvas.getInstance().hide(enemies[1].getEnemy());
        Canvas.getInstance().hide(enemies[1].getEnemyField().getArea().getBoundArea());
        Canvas.getInstance().hide(((Lion) enemies[1]).getRedLifeBar());
        Canvas.getInstance().hide(((Lion) enemies[1]).getGreenLifeBar());

    }

    public static void showAllMap2() {

        for (Area area : field.getNotWalkableMap2()) {
            area.getBoundArea().draw();


        }

        enemies[1].getEnemy().draw();
        enemies[1].getEnemyField().getArea().getBoundArea().draw();
        ((Lion) enemies[1]).getRedLifeBar().fill();
        ((Lion) enemies[1]).getGreenLifeBar().fill();

        milk.getMilk().draw();
        for (int i = 0; i < rats.length; i++) {
            rats[i].getNpc().draw();

        }
        oldLady.delete();
    }

    public static void hideAllMap2() {

        for (Area area : field.getNotWalkableMap2()) {
            Canvas.getInstance().hide(area.getBoundArea());

        }
        Canvas.getInstance().hide(milk.getMilk());

        for (int i = 0; i < rats.length; i++) {
            Canvas.getInstance().hide(rats[i].getNpc());
            // Canvas.getInstance().hide(((Rat) rats[i]));
            //nvas.getInstance().hide(((Rat) rats[i]));
        }

        Canvas.getInstance().hide(enemies[1].getEnemy());
        Canvas.getInstance().hide(enemies[1].getEnemyField().getArea().getBoundArea());
        Canvas.getInstance().hide(((Lion) enemies[1]).getRedLifeBar());
        Canvas.getInstance().hide(((Lion) enemies[1]).getGreenLifeBar());
    }

    @Override
    public void run() {

        //Game loop to create everything!
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

        for (int i = 0; i < rats.length; i++) {
            rats[i].move();
        }
    }


    public static void changeMap() {

        if (firstMap) {

            Field.map.load("resources/images/SecondMap.png");
            hideAllMap1();
            showAllMap2();
            GameSound.DOOR.sounds.play(true);
            firstMap = false;
            return;
        }

        Field.map.load("resources/images/FirstMap.png");
        hideAllMap2();
        showAllMap1();
        GameSound.DOOR.sounds.play(true);
        firstMap = true;
    }

    private void instanceOfRats(Npc[] rats) {
        for (int index = 0; index < rats.length; index++) {
            rats[index] = Factory.npcFactory(NpcType.RAT, Randomizer.getRandom(1200, 200),
                    Randomizer.getRandom(400, 200), index);
        }
    }

    private void instanceOfEnemies(Enemy[] enemies) {

        int[][] enemyPos = new int[13][2];
        enemyPos[0][0] = 110;
        enemyPos[0][1] = 350;
        enemyPos[1][0] = 220;
        enemyPos[1][1] = 260;

        enemies[0] = Factory.enemyFactory(EnemyType.COP_CAR, enemyPos[0][0], enemyPos[0][1], "Claw_attack");
        enemies[1] = Factory.enemyFactory(EnemyType.LION, enemyPos[1][0], enemyPos[1][1], "Cow");
    }

    private void instanceOfAssaultableCats(Npc[] assaultableCats) {
        int[][] assaultableCatPos = new int[13][2];
        //Vertical
        assaultableCatPos[0][0] = 440;
        assaultableCatPos[0][1] = 235;

        //Horizontal
        assaultableCatPos[1][0] = 671;
        assaultableCatPos[1][1] = 300;

        // Vertical
        assaultableCatPos[2][0] = 488;
        assaultableCatPos[2][1] = 456;

        //Horizontal
        assaultableCatPos[3][0] = 764;
        assaultableCatPos[3][1] = 594;


        //Vertical
        assaultableCatPos[4][0] = 950;
        assaultableCatPos[4][1] = 105;

        //Horizontal
        assaultableCatPos[5][0] = 1082;
        assaultableCatPos[5][1] = 528;

        // Vertical
        assaultableCatPos[6][0] = 641;
        assaultableCatPos[6][1] = 429;
        //H
        assaultableCatPos[7][0] = 1091;
        assaultableCatPos[7][1] = 609;
        //V
        assaultableCatPos[8][0] = 908;
        assaultableCatPos[8][1] = 462;
        //H
        assaultableCatPos[9][0] = 158;
        assaultableCatPos[9][1] = 531;

        // V
        assaultableCatPos[10][0] = 23;
        assaultableCatPos[10][1] = 420;

        //H
        assaultableCatPos[11][0] = 320;
        assaultableCatPos[11][1] = 402;

        assaultableCatPos[12][0] = 1253;
        assaultableCatPos[12][1] = 230;

        // CREATE ASSAULTABLE CATS
        for (int i = 0; i < 13; i++) {
            assaultableCats[i] = Factory.npcFactory(NpcType.ASSAULTABLE_CAT, assaultableCatPos[i][0], assaultableCatPos[i][1], i);
        }
    }

    /**
     * CALL THIS TO INTERACT WITH STUFF
     *
     * @return Character to interact with,
     * or player reference if no interactible objects in range
     * <p>
     * PLAYER BY DEFAULT
     */
    public static Character checkInteraction() {

        Area interactTarget;

        for (Area area : hashMap.keySet()) {

            interactTarget = area;

            if (Area.checkInteract(player.getArea(), interactTarget, INTERACT_RANGE)) {
                return hashMap.get(interactTarget);
            }

        }

        return player;
    }

    /**
     * Check milk location
     *
     * @return true if u got it right
     */
    public static boolean checkMilk() {

        if (!firstMap) {

            milk.drinkMeTillIDisappear();
            Area.checkInteract(player.getArea(), milk.getArea(), INTERACT_RANGE);

        }

        return false;
    }

    public enum GameSound {
        CATMEOW(new Sounds("/music/MEOW.wav")),
        CATCLAW(new Sounds("/music/knife_hit17.wav")),
        CATDIE(new Sounds("/music/catdie.wav")),
        CLICK(new Sounds("/music/click.wav")),
        DOOR(new Sounds("/music/dooropen.wav")),
        SHOOT(new Sounds("/music/shoot.wav")),
        BACKMUSIC(new Sounds("/music/backgroundMusic.wav"));

        public Sounds sounds;

        GameSound(Sounds sounds) {
            this.sounds = sounds;
        }
    }
}

//com mp3

