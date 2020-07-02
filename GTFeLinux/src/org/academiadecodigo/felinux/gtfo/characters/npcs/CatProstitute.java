package org.academiadecodigo.felinux.gtfo.characters.npcs;

import org.academiadecodigo.felinux.gtfo.characters.CheckpointType;
import org.academiadecodigo.felinux.gtfo.characters.player.Player;

public class CatProstitute extends Npc {

        private CheckpointType checkpoint;

        public CatProstitute(int posX, int posY, String spriteName, int direction) {
                super(posX, posY, spriteName, direction);
        }

        @Override
        public void interact() {
               Player.checkpoint  = checkpoint;
        }

        public void setCheckpoint(CheckpointType checkpoint) {
                this.checkpoint = checkpoint;
        }
}

