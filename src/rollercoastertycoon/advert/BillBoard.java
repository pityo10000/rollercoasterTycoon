package rollercoastertycoon.advert;

public class BillBoard extends AbstractAdvert {
    private static final int DEFAULT_PRICE_EASY = 16_000;
    private static final int DEFAULT_PRICE_MEDIUM = 32_000;
    private static final int DEFAULT_PRICE_HARD = 64_000;
    private static final int DEFAULT_DAILY_VISITOR_EASY = 800;
    private static final int DEFAULT_DAILY_VISITOR_MEDIUM = 400;
    private static final int DEFAULT_DAILY_VISITOR_HARD = 200;
    private static final int TIME_PERIOD = 4;

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
    int getDefaultDailyVisitorEasy() {
        return DEFAULT_DAILY_VISITOR_EASY;
    }

    @Override
    int getDefaultDailyVisitorMedium() {
        return DEFAULT_DAILY_VISITOR_MEDIUM;
    }

    @Override
    int getDefaultDailyVisitorHard() {
        return DEFAULT_DAILY_VISITOR_HARD;
    }

    @Override
    public int getTimePeriod() {
        return TIME_PERIOD;
    }
}
