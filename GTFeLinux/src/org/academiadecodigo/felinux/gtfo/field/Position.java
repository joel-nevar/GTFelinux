package org.academiadecodigo.felinux.gtfo.field;

import org.academiadecodigo.felinux.gtfo.game.SpriteType;

/**
 * A position on the Field that is capable of moving around
 */
public interface Position{
    
    /**
     * Gets the position column
     *
     * @return the column number (int)
     */
    int getCol();

    /**
     * Gets the position row
     *
     * @return the row number (int)
     */
    int getRow();

    /**
     * Changes the position column of this Position
     *
     * @param column the new column (int)
     */
    void setCol(int column);

    /**
     * Changes the position row of this Position
     *
     * @param row the new row (int)
     */
    void setRow(int row);

    /**
     * Gets this position's SpriteType
     *
     * @return the SpriteType
     */
    SpriteType getSprite();

    /**
     * Not implemented yet
     *
     *
     **/
    //public void move();

    /**
     * Compares this Position to the Position in the param
     *
     * @param position the position to compare
     *
     * @return true if position is the same
     */
    //boolean comparePosition(Position position);
}
