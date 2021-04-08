package rollercoastertycoon;

import rollercoastertycoon.game.Difficulty;
import rollercoastertycoon.game.Game;
import rollercoastertycoon.game.GameController;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController();
        Difficulty difficulty = controller.askDifficulty();
        Game.init(difficulty);
        controller.processCommands();

    }
}
