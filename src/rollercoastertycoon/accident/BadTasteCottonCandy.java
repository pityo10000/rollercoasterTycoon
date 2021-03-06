package rollercoastertycoon.accident;

import rollercoastertycoon.game.Game;

public class BadTasteCottonCandy extends AbstractMaintainableAccident {
    private static final long COST = 1_000L;
    private static final int VISITOR_DECREASE_PERCENTAGE = 0;
    private static final float PROBABILITY_EASY = 16.0f;
    private static final float PROBABILITY_MEDIUM = 24.0f;
    private static final float PROBABILITY_HARD = 36.0f;
    private static final String MESSAGE = "A cotton candy had bad taste!";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public long getCost() {
        return COST;
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
        return Game.getCottonCandyVendor().isBuilt();
    }
}
