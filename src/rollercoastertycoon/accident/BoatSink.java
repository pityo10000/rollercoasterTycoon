package rollercoastertycoon.accident;

import rollercoastertycoon.game.Game;

public class BoatSink extends AbstractMaintainableAccident {
    private static final long COST = 50_000L;
    private static final int VISITOR_DECREASE_PERCENTAGE = 10;
    private static final float PROBABILITY_EASY = 4.0f;
    private static final float PROBABILITY_MEDIUM = 6.0f;
    private static final float PROBABILITY_HARD = 9.0f;
    private static final String MESSAGE = "A boat has sank!";

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
        return Game.getBoatLake().isBuilt();
    }
}
