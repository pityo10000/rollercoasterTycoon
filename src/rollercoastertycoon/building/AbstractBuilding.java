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
        if (Game.isPricePayable(price)) {
            Game.pay(price);
            built = true;
            System.out.println(getName() + " has built!");
        } else {
            System.out.println("You don't have enough money to build a " + getName());
        }
    }

    @Override
    public void upgrade() {
        if (!isBuilt()) {
            System.out.println("The " + getName() + " is not built yet! You can't upgrade it!");
            return;
        }
        if (upgradeLevel == 10) {
            System.out.println(getName() + " has reached maximum upgrade level!");
            return;
        }
        if (Game.isPricePayable(price)) {
            Game.pay(price);
            upgradeLevel++;
            price = price * 2;
            incomePerVisitor += getDefaultIncomePerVisitor();
            System.out.println(getName() + " has upgraded!");
        } else {
            System.out.println("You don't have enough money to upgrade the " + getName());
        }
    }

    @Override
    public int getIncomePerVisitor() {
        return incomePerVisitor;
    }

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

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isBuilt() {
        return built;
    }

    @Override
    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    abstract int getDefaultPriceEasy();
    abstract int getDefaultPriceMedium();
    abstract int getDefaultPriceHard();

    abstract int getDefaultIncomePerVisitorEasy();
    abstract int getDefaultIncomePerVisitorMedium();
    abstract int getDefaultIncomePerVisitorHard();
}
