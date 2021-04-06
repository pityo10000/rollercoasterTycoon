package rollercoastertycoon.advert;

import rollercoastertycoon.game.Difficulty;
import rollercoastertycoon.game.Game;

public abstract class AbstractAdvert implements Advert {
    protected int probability;

    public AbstractAdvert() {
        this.probability = getDefaultDailyVisitory();
    }

    @Override
    public void buy() {

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
    public int getDefaultDailyVisitory() {
        Difficulty difficulty = Game.getDifficulty();
        switch (Game.getDifficulty()) {
            case EASY:
                return getDefaultDailyVisitorEasy();
            case MEDIUM:
                return getDefaultDailyVisitorMedium();
            case HARD:
                return getDefaultDailyVisitorHard();
            default:
                throw new RuntimeException("Unknown difficulty exception!: " + difficulty.name());
        }
    }

    abstract int getDefaultPriceEasy();
    abstract int getDefaultPriceMedium();
    abstract int getDefaultPriceHard();

    abstract int getDefaultDailyVisitorEasy();
    abstract int getDefaultDailyVisitorMedium();
    abstract int getDefaultDailyVisitorHard();
}
