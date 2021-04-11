package rollercoastertycoon.accident;

public interface Accident {
    void happen();
    String getMessage();
    int getCost();
    int getVisitorDecreasePercentage();
    float getProbability();
    boolean isAbleToHapen();
}
