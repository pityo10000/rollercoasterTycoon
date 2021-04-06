package rollercoastertycoon.game;

import rollercoastertycoon.building.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Difficulty difficulty;
    private static int estate = 250_000;
    private static int dailyVisitors = 10;
    private static Building cottonCandyVendor;
    private static Building carousel;
    private static Building ghostTrain;
    private static Building boatLake;
    private static Building rollerCoaster;
    private static List<Building> buildings = new ArrayList<>();

    public static void init(Difficulty difficulty) {
        Game.difficulty = difficulty;

        cottonCandyVendor = new CottonCandyVendor();
        carousel = new Carousel();
        ghostTrain = new GhostTrain();
        boatLake = new BoatLake();
        rollerCoaster = new RollerCoaster();

        buildings.add(cottonCandyVendor);
        buildings.add(carousel);
        buildings.add(ghostTrain);
        buildings.add(boatLake);
        buildings.add(rollerCoaster);
    }

    public static void nextTurn() {
        estate += calculateProfit();
        if (estate < 0) {
            throw new GameException("Game over! Your company has gone bankrupt!");
        }
    }

    public static void printFinanceStatus() {
        StringBuilder financeStatus = new StringBuilder("-------------Finance status-------------\n")
                .append("Estate: $").append(getEstate()).append("\n")
                .append("Profit: $").append(calculateProfit()).append("\n")
                .append("Daily visitors: ").append(dailyVisitors).append("\n");
        System.out.println(financeStatus.toString());
    }

    public static void printBuildingStatus() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        StringBuilder buildingStatus = new StringBuilder("---------------Buildings----------------\n")
                .append("Built:\n");
        for (Building building : buildings) {
            if (building.isBuilt()) {
                buildingStatus.append(ANSI_GREEN).append(building.getName()).append(" [Level: ")
                        .append(building.getUpgradeLevel()).append("] [");
                if (building.getUpgradeLevel() < 10) {
                    buildingStatus.append("Upgrade price: $").append(building.getPrice());
                } else {
                    buildingStatus.append("Can't upgrade");
                }
                buildingStatus.append("] [Income: $").append(building.getDefaultIncomePerVisitor())
                        .append("]\n").append(ANSI_RESET);
            }
        }
        buildingStatus.append("\nNot built: \n");
        for (Building building : buildings) {
            if (!building.isBuilt()) {
                buildingStatus.append(ANSI_RED).append(building.getName()).append(" [Price: $")
                        .append(building.getPrice()).append("]\n").append(ANSI_RESET);
            }
        }
        System.out.println(buildingStatus.toString());
    }

    public static boolean isPricePayable(int price) {
        return 0 <= getEstate() - price;
    }

    private static int calculateProfit() {
        return calculateIncome() - calculateCosts();
    }

    private static int calculateIncome() {
        int income = 0;
        for (Building building : buildings) {
            if (building.isBuilt()) {
                income += (building.getDefaultIncomePerVisitor() * dailyVisitors);
            }
        }
        return income;
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

    public static void pay(int price) {
        Game.estate -= price;
    }

    public static Building getCottonCandyVendor() {
        return cottonCandyVendor;
    }

    public static Building getCarousel() {
        return carousel;
    }

    public static Building getGhostTrain() {
        return ghostTrain;
    }

    public static Building getBoatLake() {
        return boatLake;
    }

    public static Building getRollerCoaster() {
        return rollerCoaster;
    }
}
