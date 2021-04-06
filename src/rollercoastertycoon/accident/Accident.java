package rollercoastertycoon.accident;

public interface Accident {
    void happen();
    int getCost();
    int getVisitorDecreasePercentage();
    float getProbability();
}
