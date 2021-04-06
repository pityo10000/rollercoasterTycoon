package rollercoastertycoon.accident;

public class BoatSink extends AbstractAccident {
    private static final int COST = 50_000;
    private static final int VISITOR_DECREASE_PERCENTAGE = 10;
    private static final float PROBABILITY_EASY = 4.0f;
    private static final float PROBABILITY_MEDIUM = 6.0f;
    private static final float PROBABILITY_HARD = 9.0f;

    @Override
    public void happen() {

    }

    @Override
    public int getCost() {
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
}