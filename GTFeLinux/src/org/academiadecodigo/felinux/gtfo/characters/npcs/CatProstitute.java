package org.academiadecodigo.felinux.gtfo.characters.npcs;

public class CatProstitute extends Npc {

        private boolean visited;


        @Override
        public String getMessage() {
                return "I am a Cat Prostitute";
        }

        public CatProstitute(int posX, int posY, String spriteName, int direction) {
                super(posX, posY, spriteName, direction);
        }


        public boolean isVisited() {
                return visited;
        }

        public void setVisited(boolean visited) {
                this.visited = visited;
        }

}

