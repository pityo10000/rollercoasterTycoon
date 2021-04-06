package rollercoastertycoon.advert;

public class Television extends AbstractAdvert {
    private static final int DEFAULT_PRICE_EASY = 64_000;
    private static final int DEFAULT_PRICE_MEDIUM = 128_000;
    private static final int DEFAULT_PRICE_HARD = 256_000;
    private static final int DEFAULT_DAILY_VISITOR_EASY = 3_200;
    private static final int DEFAULT_DAILY_VISITOR_MEDIUM = 1_600;
    private static final int DEFAULT_DAILY_VISITOR_HARD = 800;
    private static final int TIME_PERIOD = 8;

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
