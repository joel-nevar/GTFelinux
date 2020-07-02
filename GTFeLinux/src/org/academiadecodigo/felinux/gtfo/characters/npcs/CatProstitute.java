package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.CheckpointType;
import org.academiadecodigo.felinux.gtfo.characters.player.Player;

public class CatProstitute extends Npc {

        private boolean visited;
        private CheckpointType checkpoint;

        public CatProstitute(int posX, int posY, String spriteName, int direction) {
                super(posX, posY, spriteName, direction);
        }

        @Override
        public String getMessage() {
                return "";
        }

        @Override
        public void interact() {
                Player.checkpoint = checkpoint;
        }

        public boolean isVisited() {
                return visited;
        }

        public void setVisited(boolean visited) {
                this.visited = visited;
        }

        public void setCheckpoint(CheckpointType checkpoint) {
                this.checkpoint = checkpoint;
        }
}

