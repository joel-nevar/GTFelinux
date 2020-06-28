package org.academiadecodigo.felinux.gtfo.characters.npcs;

public class CatProstitute extends Npc {

        private boolean visited;

        public CatProstitute(int posX, int posY, String spriteName) {
                super(posX, posY, spriteName);
        }


        public boolean isVisited() {
                return visited;
        }

        public void setVisited(boolean visited) {
                this.visited = visited;
        }
}

