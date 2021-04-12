package rollercoastertycoon.accident;

public interface Accident {
    void happen();
    String getMessage();
    long getCost();
    int getVisitorDecreasePercentage();
    float getProbability();
    boolean isAbleToHapen();
}
