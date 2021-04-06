package rollercoastertycoon.building;

public class RollerCoaster extends AbstractBuilding {
    private static final String NAME = "Roller coaster";
    private static final int DEFAULT_PRICE_EASY = 800_000;
    private static final int DEFAULT_PRICE_MEDIUM = 1_200_000;
    private static final int DEFAULT_PRICE_HARD = 1_600_000;
    private static final int DEFAULT_INCOME_PER_VISITOR_EASY = 160;
    private static final int DEFAULT_INCOME_PER_VISITOR_MEDIUM = 80;
    private static final int DEFAULT_INCOME_PER_VISITOR_HARD = 40;

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
