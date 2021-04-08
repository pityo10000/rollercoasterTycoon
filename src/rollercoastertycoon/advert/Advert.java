package rollercoastertycoon.advert;

public interface Advert {
    String getName();
    void activate();
    boolean isActive();
    void calculateDailyVisitors();
    int getDailyVisitors();
    int getPrice();
    double getDefaultDailyVisitorsEfficiency();
    int getDefaultRemainingTime();
    int getRemainingDays();

}
