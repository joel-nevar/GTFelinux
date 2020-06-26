package org.academiadecodigo.felinux.gtfo.characters.player;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerKeyboard implements KeyboardHandler {


    private Keyboard keyboard;

    public PlayerKeyboard(){

        keyboard = new Keyboard(this);
        init();
    }

    private void init(){

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        left.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        left.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        left.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent interact = new KeyboardEvent();
        interact.setKey(KeyboardEvent.KEY_E);
        interact.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent attack = new KeyboardEvent();
        attack.setKey(KeyboardEvent.KEY_SPACE);
        attack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(interact);
        keyboard.addEventListener(attack);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
