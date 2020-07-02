package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.CheckpointType;
import org.academiadecodigo.felinux.gtfo.characters.player.Player;

public class CatProstitute extends Npc {

        private boolean visited;
        private CheckpointType checkpoint;


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

        public void setCheckpoint(CheckpointType checkpoint) {
                this.checkpoint = checkpoint;
        }

        public CheckpointType getCheckpoint() {
                return checkpoint;
        }
}

