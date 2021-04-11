package rollercoastertycoon.advert;

public interface Advert {
    String getName();
    void activate();
    boolean isActive();
    void calculateDailyVisitors();
    int getNewDailyVisitors();
    int getPrice();
    double getDefaultNewDailyVisitors();
    int getDefaultRemainingTime();
    int getRemainingDays();

}
