package rollercoastertycoon.advert;

public class Newspaper extends AbstractAdvert {
    private static final String NAME = "Newspaper";
    private static final int DEFAULT_PRICE_EASY = 4_000;
    private static final int DEFAULT_PRICE_MEDIUM = 8_000;
    private static final int DEFAULT_PRICE_HARD = 16_000;
    private static final int DEFAULT_DAILY_VISITOR_EASY = 200;
    private static final int DEFAULT_DAILY_VISITOR_MEDIUM = 100;
    private static final int DEFAULT_DAILY_VISITOR_HARD = 50;
    private static final int TIME_PERIOD = 2;

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
    public int getDefaultRemainingTime() {
        return TIME_PERIOD;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
