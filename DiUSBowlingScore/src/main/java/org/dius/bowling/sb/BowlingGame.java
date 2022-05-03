package org.dius.bowling.sb;

public interface BowlingGame {
    /**
     * Keeps track of pins knocked over
     * @param noOfPins knocked over per frame
     * @exception {@link BowlingGameImpl.BowlingException}
     */
    void roll(int noOfPins);

    /**
     * Calculate the score of current frame
     * @return score of current frame
     */
    int score();
}
