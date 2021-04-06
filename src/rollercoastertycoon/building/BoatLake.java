package rollercoastertycoon.building;

public class BoatLake extends AbstractBuilding {
    private static final String NAME = "Boat lake";
    private static final int DEFAULT_PRICE_EASY = 200_000;
    private static final int DEFAULT_PRICE_MEDIUM = 300_000;
    private static final int DEFAULT_PRICE_HARD = 400_000;
    private static final int DEFAULT_INCOME_PER_VISITOR_EASY = 40;
    private static final int DEFAULT_INCOME_PER_VISITOR_MEDIUM = 20;
    private static final int DEFAULT_INCOME_PER_VISITOR_HARD = 10;

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
