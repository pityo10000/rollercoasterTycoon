package rollercoastertycoon.accident;

public class BadTasteCottonCandy extends AbstractAccident {
    private static final int COST = 1_000;
    private static final int VISITOR_DECREASE_PERCENTAGE = 0;
    private static final float PROBABILITY_EASY = 16.0f;
    private static final float PROBABILITY_MEDIUM = 24.0f;
    private static final float PROBABILITY_HARD = 36.0f;

    @Override
    public void happen() {
        super.happen();

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
