package org.dius.bowling.sb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BowlingGameTest {
    private BowlingGame game;
    private static final int MAX_ATTEMPTS = 20;

    @Before
    public void setUp() {
        game = new BowlingGameImpl();
    }


    @Test
    public void testScoreNoSpareOrStrike() {

        game.roll(4);
        game.roll(4);

        int score  = game.score();
        Assert.assertEquals(8, score);

    }
}
