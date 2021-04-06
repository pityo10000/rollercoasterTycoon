package rollercoastertycoon;

import rollercoastertycoon.game.Difficulty;
import rollercoastertycoon.game.Game;
import rollercoastertycoon.game.GameCommander;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Game.init(Difficulty.EASY);
        new GameCommander().processCommand();

    }
}
