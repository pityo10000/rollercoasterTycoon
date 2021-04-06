package rollercoastertycoon.building;

public class GhostTrain extends AbstractBuilding {
    private static final String NAME = "Ghost train";
    private static final int DEFAULT_PRICE_EASY = 400_000;
    private static final int DEFAULT_PRICE_MEDIUM = 600_000;
    private static final int DEFAULT_PRICE_HARD = 800_000;
    private static final int DEFAULT_INCOME_PER_VISITOR_EASY = 80;
    private static final int DEFAULT_INCOME_PER_VISITOR_MEDIUM = 40;
    private static final int DEFAULT_INCOME_PER_VISITOR_HARD = 20;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    int getDefaultPriceEasy() {
        return DEFAULT_PRICE_EASY;
    }

    @Override
    int getDefaultPriceMedium() {
        return DEFAULT_PRICE_MEDIUM;
    }

    @Override
    int getDefaultPriceHard() {
        return DEFAULT_PRICE_HARD;
    }

    @Override
    int getDefaultIncomePerVisitorEasy() {
        return DEFAULT_INCOME_PER_VISITOR_EASY;
    }

    @Override
    int getDefaultIncomePerVisitorMedium() {
        return DEFAULT_INCOME_PER_VISITOR_MEDIUM;
    }

    @Override
    int getDefaultIncomePerVisitorHard() {
        return DEFAULT_INCOME_PER_VISITOR_HARD;
    }
}
