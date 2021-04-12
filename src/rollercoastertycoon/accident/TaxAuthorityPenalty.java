package rollercoastertycoon.accident;

import rollercoastertycoon.game.Game;

public class TaxAuthorityPenalty extends AbstractAccident {
    private static final int VISITOR_DECREASE_PERCENTAGE = 0;
    private static final float PROBABILITY_EASY = 0;
    private static final float PROBABILITY_MEDIUM = 0;
    private static final float PROBABILITY_HARD = 0;
    private static final String MESSAGE = "The Tax Authority gave a penalty!";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public long getCost() {
        long estate = Game.getEstate();
        return Math.max(100_000L, estate / 2L);
    }

    @Override
    public int getVisitorDecreasePercentage() {
        return VISITOR_DECREASE_PERCENTAGE;
    }

    @Override
    public float getProbabilityEasy() {
        return PROBABILITY_EASY;
    }

    @Override
    public float getProbabilityMedium() {
        return PROBABILITY_MEDIUM;
    }

    @Override
    public float getProbabilityHard() {
        return PROBABILITY_HARD;
    }

    @Override
    public boolean isAbleToHapen() {
        return true;
    }
}
