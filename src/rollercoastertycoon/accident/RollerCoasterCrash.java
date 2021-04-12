package rollercoastertycoon.accident;

import rollercoastertycoon.game.Game;

public class RollerCoasterCrash extends AbstractMaintainableAccident {
    private static final long COST = 100_000L;
    private static final int VISITOR_DECREASE_PERCENTAGE = 20;
    private static final float PROBABILITY_EASY = 2.0f;
    private static final float PROBABILITY_MEDIUM = 3.0f;
    private static final float PROBABILITY_HARD = 3.5f;
    private static final String MESSAGE = "The roller coaster had a crash!";

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
        return Game.getRollerCoaster().isBuilt();
    }
}
