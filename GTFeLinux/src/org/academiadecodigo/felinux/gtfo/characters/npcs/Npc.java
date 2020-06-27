package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.Character;

public abstract class Npc extends Character {

    private boolean visited;

    public Npc(){
    }

    public String getMessage() {
        return "Return this string";
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
