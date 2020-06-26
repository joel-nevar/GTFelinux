package org.academiadecodigo.felinux.gtfo.menu;

import org.academiadecodigo.felinux.gtfo.characters.enemies.CopCar;
import org.academiadecodigo.felinux.gtfo.characters.player.Player;
import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Menu implements KeyboardHandler, MouseHandler {

    public void start(){
        Field gameField = new Field();
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
