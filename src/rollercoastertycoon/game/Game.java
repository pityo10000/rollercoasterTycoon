package rollercoastertycoon.game;

import rollercoastertycoon.building.*;

public class Game {
    private static Difficulty difficulty;
    private static int estate = 250_000;
    private static AbstractBuilding cottonCandyVendor;
    private static AbstractBuilding carousel;
    private static AbstractBuilding ghostTrain;
    private static AbstractBuilding boatLake;
    private static AbstractBuilding rollerCoaster;

    public static void init(Difficulty difficulty) {
        Game.difficulty = difficulty;
        cottonCandyVendor = new CottonCandyVendor();
        carousel = new Carousel();
        ghostTrain = new GhostTrain();
        boatLake = new BoatLake();
        rollerCoaster = new RollerCoaster();

    }

    public static void nextTurn() {
        estate += calculateProfit();
        if (estate < 0) {
            throw new GameException("Game over! Your company has gone bankrupt!");
        }
    }

    public static void printGameStatus() {
        StringBuilder status = new StringBuilder("------------------------------------------------")
                .append("Estate: ").append(getEstate()).append("$")
                .append("Profit: ").append(calculateProfit()).append("$");
    }

    private static int calculateProfit() {
        return calculateIncome() - calculateCosts();
    }

    private static int calculateIncome() {
        return 0;
    }

    private static int calculateCosts() {
        return 0;
    }

    public static Difficulty getDifficulty() {
        return difficulty;
    }

    public static int getEstate() {
        return estate;
    }

    public static void addEstate(int estate) {
        Game.estate += estate;
    }

    public static AbstractBuilding getCottonCandyVendor() {
        return cottonCandyVendor;
    }

    public static AbstractBuilding getCarousel() {
        return carousel;
    }

    public static AbstractBuilding getGhostTrain() {
        return ghostTrain;
    }

    public static AbstractBuilding getBoatLake() {
        return boatLake;
    }

    public static AbstractBuilding getRollerCoaster() {
        return rollerCoaster;
    }
}
