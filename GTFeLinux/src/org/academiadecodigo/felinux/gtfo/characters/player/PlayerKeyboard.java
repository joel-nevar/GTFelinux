package org.academiadecodigo.felinux.gtfo.characters.player;

import org.academiadecodigo.felinux.gtfo.characters.enemies.Enemy;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.felinux.gtfo.game.GameHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


/**
 * Keyboard Handler for Player Ingame
 */
public class PlayerKeyboard implements KeyboardHandler {


    private Keyboard keyboard;
    private Player player;
    private Enemy enemy;
    private float moveSpeed = 3f;

    public PlayerKeyboard(Player player, Enemy enemy){
        this.enemy = enemy;
        this.player = player;
        keyboard = new Keyboard(this);
        init();
    }

    /**
     * Initialize Keyboard for player movement
     */
    private void init(){

        /**
         * Key pressed
         */
        KeyboardEvent eAction = new KeyboardEvent();
        eAction.setKey(KeyboardEvent.KEY_E);
        eAction.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftArrow = new KeyboardEvent();
        leftArrow.setKey(KeyboardEvent.KEY_LEFT);
        leftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightArrow = new KeyboardEvent();
        rightArrow.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent upArrow = new KeyboardEvent();
        upArrow.setKey(KeyboardEvent.KEY_UP);
        upArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downArrow = new KeyboardEvent();
        downArrow.setKey(KeyboardEvent.KEY_DOWN);
        downArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent interact = new KeyboardEvent();
        interact.setKey(KeyboardEvent.KEY_E);
        interact.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent attack = new KeyboardEvent();
        attack.setKey(KeyboardEvent.KEY_SPACE);
        attack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(eAction);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(leftArrow);
        keyboard.addEventListener(rightArrow);
        keyboard.addEventListener(upArrow);
        keyboard.addEventListener(downArrow);
        keyboard.addEventListener(interact);
        keyboard.addEventListener(attack);


        /*
         * Key Released
         */

        KeyboardEvent stopLeft = new KeyboardEvent();
        stopLeft.setKey(KeyboardEvent.KEY_A);
        stopLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopLeftArrow = new KeyboardEvent();
        stopLeftArrow.setKey(KeyboardEvent.KEY_LEFT);
        stopLeftArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopRightArrow = new KeyboardEvent();
        stopRightArrow.setKey(KeyboardEvent.KEY_RIGHT);
        stopRightArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopUpArrow = new KeyboardEvent();
        stopUpArrow.setKey(KeyboardEvent.KEY_UP);
        stopUpArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopDownArrow = new KeyboardEvent();
        stopDownArrow.setKey(KeyboardEvent.KEY_DOWN);
        stopDownArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopRight = new KeyboardEvent();
        stopRight.setKey(KeyboardEvent.KEY_D);
        stopRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopUp = new KeyboardEvent();
        stopUp.setKey(KeyboardEvent.KEY_W);
        stopUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent stopDown = new KeyboardEvent();
        stopDown.setKey(KeyboardEvent.KEY_S);
        stopDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(stopLeft);
        keyboard.addEventListener(stopRight);
        keyboard.addEventListener(stopUp);
        keyboard.addEventListener(stopDown);
        keyboard.addEventListener(stopLeftArrow);
        keyboard.addEventListener(stopRightArrow);
        keyboard.addEventListener(stopUpArrow);
        keyboard.addEventListener(stopDownArrow);


    }

    /**
     * KeyboardEvent Handler for Player actions on key press
     *
     * @param keyboardEvent self explanatory
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        //Reset Movement

        Player.dx = 0f;
        Player.dy = 0f;

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_E){
            GameHandler.changeMap();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_A){
            Player.dx -= moveSpeed;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_D){
            Player.dx += moveSpeed;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_W){
            Player.dy -= moveSpeed;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_S){
            Player.dy += moveSpeed;
        }

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_E:
                player.interact();
                break;

            case KeyboardEvent.KEY_SPACE:
                if(player.isClawUsed()){
                    return;
                }
                try {
                    player.attack(enemy);
                } catch (NullPointerException npe) {
                    System.out.println("You're attacking the air");
                }
            /*

            case KeyboardEvent.KEY_LEFT:
                case KeyboardEvent.KEY_A:
                    player.moveLeft();
                    break;
            case KeyboardEvent.KEY_RIGHT:
                case KeyboardEvent.KEY_D:
                    player.moveRight();
                    break;
            case KeyboardEvent.KEY_UP:
                case KeyboardEvent.KEY_W:
                    player.moveUp();
                    break;
            case KeyboardEvent.KEY_DOWN:
            case KeyboardEvent.KEY_S:
                player.moveDown();
                break;
            //TODO fix interact and attack keys - DONE

         */
        }
    }

    /**
     * KeyboardEvent Handler for Player actions on key released
     *
     * @param keyboardEvent self explanatory
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


        if(keyboardEvent.getKey() == KeyboardEvent.KEY_A){
            Player.dx = 0f;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_D){
            Player.dx = 0f;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_W){
            Player.dy = 0f;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_S){
            Player.dy = 0f;
        }

    }
}
