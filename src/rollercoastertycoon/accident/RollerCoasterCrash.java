package rollercoastertycoon.accident;

public class RollerCoasterCrash extends AbstractAccident {
    private static final int COST = 100_000;
    private static final int VISITOR_DECREASE_PERCENTAGE = 20;
    private static final float PROBABILITY_EASY = 2.0f;
    private static final float PROBABILITY_MEDIUM = 3.0f;
    private static final float PROBABILITY_HARD = 3.5f;

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
