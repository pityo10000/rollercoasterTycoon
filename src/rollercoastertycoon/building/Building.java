package rollercoastertycoon.building;

import rollercoastertycoon.game.Difficulty;

public interface Building {
    void build();
    void upgrade();
    int getDefaultIncomePerVisitor();
    int getDefaultPrice();
}
