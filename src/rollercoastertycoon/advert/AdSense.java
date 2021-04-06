package rollercoastertycoon.advert;

public class AdSense extends AbstractAdvert {
    private static final int DEFAULT_PRICE_EASY = 256_000;
    private static final int DEFAULT_PRICE_MEDIUM = 512_000;
    private static final int DEFAULT_PRICE_HARD = 1_024_000;
    private static final int DEFAULT_DAILY_VISITOR_EASY = 12_800;
    private static final int DEFAULT_DAILY_VISITOR_MEDIUM = 6_400;
    private static final int DEFAULT_DAILY_VISITOR_HARD = 3_200;
    private static final int TIME_PERIOD = 16;

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
