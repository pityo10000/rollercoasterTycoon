package rollercoastertycoon.game;

import rollercoastertycoon.advert.AdSense;
import rollercoastertycoon.advert.Advert;
import rollercoastertycoon.advert.BillBoard;
import rollercoastertycoon.advert.Flyer;
import rollercoastertycoon.advert.Newspaper;
import rollercoastertycoon.advert.Television;
import rollercoastertycoon.building.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int DEFAULT_DAILY_VISITORS = 10;

    private static Difficulty difficulty;
    private static int estate = 250_000;
    private static int dailyVisitors = DEFAULT_DAILY_VISITORS;
    private static Building cottonCandyVendor;
    private static Building carousel;
    private static Building ghostTrain;
    private static Building boatLake;
    private static Building rollerCoaster;
    private static final List<Building> buildings = new ArrayList<>();

    private static Advert adSense;
    private static Advert billBoard;
    private static Advert flyer;
    private static Advert newspaper;
    private static Advert television;
    private static final List<Advert> adverts = new ArrayList<>();

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public static void init(Difficulty difficulty) {
        Game.difficulty = difficulty;
        initBuildings();
        initAdverts();

        printAllStatuses();
    }

    private static void initBuildings() {
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

    private static void initAdverts() {
        adSense = new AdSense();
        billBoard = new BillBoard();
        flyer = new Flyer();
        newspaper = new Newspaper();
        television = new Television();

        adverts.add(adSense);
        adverts.add(billBoard);
        adverts.add(flyer);
        adverts.add(newspaper);
        adverts.add(television);
    }

    public static void nextTurn() {
        estate += getProfit();
        if (estate < 0) {
            throw new GameException("Game over! Your company has gone bankrupt!");
        }
        handleAdverts();
    }

    private static void handleAdverts() {
        for (Advert advert : adverts) {
            advert.calculateDailyVisitors();
        }
    }

    public static void printAllStatuses() {
        printFinanceStatus();
        printBuildingStatus();
        printAdvertStatus();
    }

    public static void printFinanceStatus() {
        StringBuilder financeStatus = new StringBuilder("-------------Finance status-------------\n")
                .append("Estate: $").append(getEstate()).append("\n")
                .append("Profit: $").append(getProfit()).append("\n")
                .append("Daily visitors: ").append(getDailyVisitors()).append("\n");
        System.out.println(financeStatus.toString());
    }

    public static void printBuildingStatus() {
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

    public static void printAdvertStatus() {
        StringBuilder advertStatus = new StringBuilder();
        advertStatus.append("----------------Adverts-----------------\n")
                .append("Activated:\n");
        for (Advert advert : adverts) {
            if (advert.isActive()) {
                advertStatus.append(ANSI_GREEN).append(advert.getName()).append(" [Remaining days: ")
                        .append(advert.getRemainingDays()).append("] [Daily new visitors: ")
                        .append(advert.getDailyVisitors()).append("]\n").append(ANSI_RESET);
            }
        }
        advertStatus.append("\nInactive:\n");
        for (Advert advert : adverts) {
            if (!advert.isActive()) {
                advertStatus.append(ANSI_RED).append(advert.getName()).append(" [Price: $").append(advert.getPrice())
                        .append("] [Days: ").append(advert.getDefaultRemainingTime()).append("] [Daily visitors: ")
                        .append(advert.getDailyVisitors()).append("]\n").append(ANSI_RESET);
            }
        }
        System.out.println(advertStatus.toString());
    }

    public static boolean isPricePayable(int price) {
        return 0 <= getEstate() - price;
    }

    private static int getProfit() {
        return getIncome() - getCosts();
    }

    private static int getIncome() {
        int income = 0;
        for (Building building : buildings) {
            if (building.isBuilt()) {
                income += (building.getDefaultIncomePerVisitor() * getDailyVisitors());
            }
        }
        return income;
    }

    private static int getCosts() {
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

    public static Advert getAdSense() {
        return adSense;
    }

    public static Advert getBillBoard() {
        return billBoard;
    }

    public static Advert getFlyer() {
        return flyer;
    }

    public static Advert getNewspaper() {
        return newspaper;
    }

    public static Advert getTelevision() {
        return television;
    }

    public static int getDailyVisitors() {
        int dailyVisitors = Game.dailyVisitors;
        for (Advert advert : adverts) {
            if (advert.isActive()) {
                dailyVisitors += advert.getDailyVisitors();
            }
        }
        return dailyVisitors;
    }
}
