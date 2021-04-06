package rollercoastertycoon.building;

public interface Building {
    void build();
    void upgrade();
    int getDefaultIncomePerVisitor();
    int getDefaultPrice();
    int getPrice();
    boolean isBuilt();
    String getName();
    int getUpgradeLevel();
}
