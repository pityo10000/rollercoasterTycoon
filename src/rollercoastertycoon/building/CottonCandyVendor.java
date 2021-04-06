package rollercoastertycoon.building;

public class CottonCandyVendor extends AbstractBuilding {
    private static final String NAME = "Cotton candy vendor";
    private static final int DEFAULT_PRICE_EASY = 50_000;
    private static final int DEFAULT_PRICE_MEDIUM = 100_000;
    private static final int DEFAULT_PRICE_HARD = 150_000;
    private static final int DEFAULT_INCOME_PER_VISITOR_EASY = 10;
    private static final int DEFAULT_INCOME_PER_VISITOR_MEDIUM = 5;
    private static final int DEFAULT_INCOME_PER_VISITOR_HARD = 2;

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
