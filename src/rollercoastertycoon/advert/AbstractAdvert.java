package rollercoastertycoon.advert;

import rollercoastertycoon.game.Difficulty;
import rollercoastertycoon.game.Game;

public abstract class AbstractAdvert implements Advert {
    protected boolean active = false;
    protected double newDailyVisitors = getDefaultNewDailyVisitors();
    protected int remainingDays = getDefaultRemainingTime();

    @Override
    public void activate() {
        if (isActive()) {
            System.out.println(getName() + " is already active for " + remainingDays + " days!");
            return;
        }

        if (Game.isPricePayable(getPrice())) {
            Game.pay(getPrice());
            active = true;
            System.out.println(getName() + " has activated!");
        } else {
            System.out.println("You don't have enough money to activate " + getName());
        }
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void calculateDailyVisitors() {
        if (active) {
            if (0 < remainingDays) {
                remainingDays--;
                newDailyVisitors /= 1.1;
                Game.addDailyVisitors(getNewDailyVisitors());
            }
            if (remainingDays == 0) {
                active = false;
                remainingDays = getDefaultRemainingTime();
            }
        } else {
            if (newDailyVisitors < getDefaultNewDailyVisitors()) {
                newDailyVisitors *= 1.1;
            }
            if (getDefaultNewDailyVisitors() < newDailyVisitors) {
                newDailyVisitors = getDefaultNewDailyVisitors();
            }
        }
    }

    @Override
    public int getNewDailyVisitors() {
        return (int) newDailyVisitors;
    }

    @Override
    public int getPrice() {
        Difficulty difficulty = Game.getDifficulty();
        switch (Game.getDifficulty()) {
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
    public double getDefaultNewDailyVisitors() {
        double defaultDailyVisitors;

        Difficulty difficulty = Game.getDifficulty();
        switch (Game.getDifficulty()) {
            case EASY:
                defaultDailyVisitors = getDefaultDailyVisitorEasy();
                break;
            case MEDIUM:
                defaultDailyVisitors = getDefaultDailyVisitorMedium();
                break;
            case HARD:
                defaultDailyVisitors = getDefaultDailyVisitorHard();
                break;
            default:
                throw new RuntimeException("Unknown difficulty exception!: " + difficulty.name());
        }

        return defaultDailyVisitors;
    }

    @Override
    public int getRemainingDays() {
        return remainingDays;
    }

    abstract int getDefaultPriceEasy();
    abstract int getDefaultPriceMedium();
    abstract int getDefaultPriceHard();

    abstract int getDefaultDailyVisitorEasy();
    abstract int getDefaultDailyVisitorMedium();
    abstract int getDefaultDailyVisitorHard();
}
