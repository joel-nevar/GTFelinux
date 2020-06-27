package org.academiadecodigo.felinux.gtfo.menu;

import org.academiadecodigo.felinux.gtfo.characters.moveable.player.Player;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.felinux.gtfo.game.GameHandler;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Menu implements KeyboardHandler, MouseHandler {

    public void initializeGame(){

        GameHandler game = new GameHandler(new Field());
        game.init();
    }

    public void instructions(){};
    public void DLC(){};
    public void exit(){};

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
