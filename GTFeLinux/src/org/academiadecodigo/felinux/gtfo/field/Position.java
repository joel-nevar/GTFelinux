package org.academiadecodigo.felinux.gtfo.field;

/**
 * A position on the Field that is capable of moving around
 */
public interface Position {


    /**
     * Gets the position column
     *
     * @return the column number (int)
     */
    public int getCol();

    /**
     * Gets the position row
     *
     * @return the row number (int)
     */
    public int getRow();

    /**
     * Changes the position column of this Position
     *
     * @param column the new column (int)
     */
    public void setCol(int column);

    /**
     * Changes the position row of this Position
     *
     * @param row the new row (int)
     */
    public void setRow(int row);

    /**
     * Gets this position's SpryteType
     *
     * @return the SpryteType
     */
    public SpriteType getSpryte();

    /**
     * Not implemented yet
     *
     *
     */
    //public void move();

    /**
     * Compares this Position to the Position in the param
     *
     * @param position the position to compare
     *
     * @return true if position is the same
     */
    public boolean comparePosition(Position position);
}
