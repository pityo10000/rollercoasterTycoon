package rollercoastertycoon.advert;

public class Flyer extends AbstractAdvert {
    private static final int DEFAULT_PRICE_EASY = 1_000;
    private static final int DEFAULT_PRICE_MEDIUM = 2_000;
    private static final int DEFAULT_PRICE_HARD = 4_000;
    private static final int DEFAULT_DAILY_VISITOR_EASY = 50;
    private static final int DEFAULT_DAILY_VISITOR_MEDIUM = 25;
    private static final int DEFAULT_DAILY_VISITOR_HARD = 13;
    private static final int TIME_PERIOD = 1;

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
