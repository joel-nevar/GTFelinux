package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.Character;
import org.academiadecodigo.felinux.gtfo.field.Position;

public abstract class Npc extends Character {

    private Position position;
    private boolean visited;

    public Npc(){
    }

    public String getMessage() {
        return "Return this string";
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
