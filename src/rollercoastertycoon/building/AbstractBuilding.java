package rollercoastertycoon.building;

import rollercoastertycoon.game.Difficulty;
import rollercoastertycoon.game.Game;
import rollercoastertycoon.game.GameException;

public abstract class AbstractBuilding implements Building {
    protected int price = getDefaultPrice();
    protected int incomePerVisitor = getDefaultIncomePerVisitor();
    protected int upgradeLevel = 0;
    protected boolean built;

    @Override
    public void build() {
        built = true;
        System.out.println(getName() + " has built!");
    }

    @Override
    public void upgrade() {
        if (upgradeLevel == 10) {
            throw new GameException(getName() + " has reached maximum upgrade level!");
        }
        upgradeLevel++;
        price = price * 2;
        incomePerVisitor += getDefaultIncomePerVisitor();
        System.out.println(getName() + " has upgraded!");
    }

    @Override
    public int getDefaultIncomePerVisitor() {
        Difficulty difficulty = Game.getDifficulty();
        switch (difficulty) {
            case EASY:
                return getDefaultIncomePerVisitorEasy();
            case MEDIUM:
                return getDefaultIncomePerVisitorMedium();
            case HARD:
                return getDefaultIncomePerVisitorHard();
            default:
                throw new RuntimeException("Unknown difficulty exception!: " + difficulty.name());
        }
    }

    @Override
    public int getDefaultPrice() {
        Difficulty difficulty = Game.getDifficulty();
        switch (difficulty) {
            case EASY:
                return getDefaultPriceEasy();
            case MEDIUM:
                return getDefaultPriceMedium();
            case HARD:
                return getDefaultPriceHard();
            default:
                throw new RuntimeException("Unknown difficulty exception!: " + difficulty.name());
        }
    }

    abstract String getName();

    abstract int getDefaultPriceEasy();
    abstract int getDefaultPriceMedium();
    abstract int getDefaultPriceHard();

    abstract int getDefaultIncomePerVisitorEasy();
    abstract int getDefaultIncomePerVisitorMedium();
    abstract int getDefaultIncomePerVisitorHard();
}
