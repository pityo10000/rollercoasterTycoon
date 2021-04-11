package rollercoastertycoon.accident;

import rollercoastertycoon.game.Difficulty;
import rollercoastertycoon.game.Game;
import rollercoastertycoon.util.TextColorUtil;

import java.util.Random;

abstract class AbstractAccident implements Accident {
    private static final Random RANDOM = new Random();

    public void happen() {
        if (!isAbleToHapen()) {
            return;
        }

        float randomNumber = (RANDOM.nextFloat() * 100) + 1;
        if (randomNumber <= getProbability()) {
            Game.pay(getCost());
            Game.reduceDailyVisitorsByPercentage(getVisitorDecreasePercentage());
            System.out.println(TextColorUtil.textToRed(getMessage()));
        }
    }

    public float getProbability() {
        Difficulty difficulty = Game.getDifficulty();
        switch (Game.getDifficulty()) {
            case EASY:
                return getProbabilityEasy();
            case MEDIUM:
                return getProbabilityMedium();
            case HARD:
                return getProbabilityHard();
            default:
                throw new RuntimeException("Unknown difficulty exception!: " + difficulty.name());
        }
    }

    protected abstract float getProbabilityEasy();
    protected abstract float getProbabilityMedium();
    protected abstract float getProbabilityHard();
}
