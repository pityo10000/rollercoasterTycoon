package rollercoastertycoon.game;

import rollercoastertycoon.accident.Accident;
import rollercoastertycoon.accident.BadTasteCottonCandy;
import rollercoastertycoon.accident.BoatSink;
import rollercoastertycoon.accident.CarouselCrash;
import rollercoastertycoon.accident.RollerCoasterCrash;
import rollercoastertycoon.accident.TaxAuthorityPenalty;
import rollercoastertycoon.advert.AdSense;
import rollercoastertycoon.advert.Advert;
import rollercoastertycoon.advert.BillBoard;
import rollercoastertycoon.advert.Flyer;
import rollercoastertycoon.advert.Newspaper;
import rollercoastertycoon.advert.Television;
import rollercoastertycoon.building.BoatLake;
import rollercoastertycoon.building.Building;
import rollercoastertycoon.building.Carousel;
import rollercoastertycoon.building.CottonCandyVendor;
import rollercoastertycoon.building.GhostTrain;
import rollercoastertycoon.building.RollerCoaster;
import rollercoastertycoon.constants.EmployeeType;
import rollercoastertycoon.employee.EmployeeFacade;
import rollercoastertycoon.util.TextColorUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int DEFAULT_DAILY_VISITORS = 10;

    private static Difficulty difficulty;
    private static long estate = 250_000;
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

    private static final List<Accident> accidents = new ArrayList<>();

    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("###,###");

    public static void init(Difficulty difficulty) {
        Game.difficulty = difficulty;
        initBuildings();
        initAdverts();
        initAccidents();
        EmployeeFacade.initPositions();

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

    private static void initAccidents() {
        accidents.add(new BadTasteCottonCandy());
        accidents.add(new BoatSink());
        accidents.add(new CarouselCrash());
        accidents.add(new RollerCoasterCrash());
        accidents.add(new TaxAuthorityPenalty());
    }

    public static void nextTurn() {
        EmployeeFacade.payEmployees();
        handleAdverts();
        handleAccidents();
        estate += getProfit();
        if (estate < 0) {
            System.out.println(TextColorUtil.textToRed("Game over! Your company has gone bankrupt!"));
            System.exit(0);
        }
    }

    private static void handleAdverts() {
        for (Advert advert : adverts) {
            advert.calculateDailyVisitors();
        }
    }

    private static void handleAccidents() {
        for (Accident accident : accidents) {
            accident.happen();
        }
    }

    public static void printAllStatuses() {
        printFinanceStatus();
        printBuildingStatus();
        printAdvertStatus();
        printEmployeeStatus();
    }

    public static void printFinanceStatus() {
        String financeStatus = "-------------Finance status-------------\n" +
                "Estate: $" + NUMBER_FORMAT.format(getEstate()) + "\n" +
                "Profit: $" + NUMBER_FORMAT.format(getProfit()) + "\n" +
                "Daily visitors: " + getDailyVisitors() + "\n";
        System.out.println(financeStatus);
    }

    public static void printBuildingStatus() {
        System.out.println("---------------Buildings----------------");
        System.out.println("Built:");
        for (Building building : buildings) {
            if (building.isBuilt()) {
                StringBuilder buildingStatus = new StringBuilder().append(building.getName())
                        .append(" [Level: ").append(building.getUpgradeLevel()).append("] [");
                if (building.getUpgradeLevel() < 10) {
                    buildingStatus.append("Upgrade price: $").append(NUMBER_FORMAT.format(building.getPrice()));
                } else {
                    buildingStatus.append("Can't upgrade");
                }
                buildingStatus.append("] [Income: $").append(NUMBER_FORMAT.format(building.getIncomePerVisitor()))
                        .append("]");
                System.out.println(TextColorUtil.textToGreen(buildingStatus.toString()));
            }
        }
        System.out.println("\nNot built:");
        for (Building building : buildings) {
            if (!building.isBuilt()) {
                String buildingStatus = building.getName() + " [Price: $" + NUMBER_FORMAT.format(building.getPrice()) + "]";
                System.out.println(TextColorUtil.textToRed(buildingStatus));
            }
        }
    }

    public static void printAdvertStatus() {
        System.out.println("----------------Adverts-----------------");
        System.out.println("Activated:");
        for (Advert advert : adverts) {
            if (advert.isActive()) {
                String advertStatus = advert.getName() + " [Remaining days: " +
                        advert.getRemainingDays() + "] [Daily new visitors: " +
                        advert.getNewDailyVisitors() + "]";
                System.out.println(TextColorUtil.textToGreen(advertStatus));
            }
        }
        System.out.println("\nInactive:");
        for (Advert advert : adverts) {
            if (!advert.isActive()) {
                String advertStatus = advert.getName() + " [Price: $" + NUMBER_FORMAT.format(advert.getPrice()) +
                        "] [Days: " + advert.getDefaultRemainingTime() + "] [Daily visitors: " +
                        advert.getNewDailyVisitors() + "]";
                System.out.println(TextColorUtil.textToRed(advertStatus));
            }
        }
    }

    public static void printEmployeeStatus() {
        System.out.println("---------------Employees----------------");
        System.out.println("Positions:");
        EmployeeFacade.Position[] positions = EmployeeFacade.getPositions();
        for (int i = 0; i < positions.length; i++) {
            EmployeeFacade.Position position = positions[i];
            StringBuilder positionStatus = new StringBuilder().append("[").append(i + 1).append("] ");
            if (position.isAvailable()) {
                positionStatus.append(" Available for ").append(position.getType().getValue().toLowerCase());
            } else {
                positionStatus.append(position.getType().getValue()).append(" [Salary: ")
                        .append(position.getEmployee().getCostPercentage()).append("% of estate] [");
                if (EmployeeType.MAINTAINER.equals(position.getType())) {
                    positionStatus.append("Efficiency: ").append(position.getEmployee().getCostPercentage()).append("%");
                } else {
                    positionStatus.append("Reduce tax penalty by 50%");
                }
                positionStatus.append("]");
            }
            System.out.println(TextColorUtil.textToGreen(positionStatus.toString()));
        }
        System.out.println("\nAvailable employees:");
        System.out.println(TextColorUtil.textToRed("[1] Maintainer [Salary: 3% of estate] [Reduce probability of Carousel/roller coaster crash and boat sink by 3%]"));
        System.out.println(TextColorUtil.textToRed("[2] Maintainer [Salary: 4% of estate] [Reduce probability of Carousel/roller coaster crash and boat sink by 4%]"));
        System.out.println(TextColorUtil.textToRed("[3] Maintainer [Salary: 5% of estate] [Reduce probability of Carousel/roller coaster crash and boat sink by 5%]"));
        System.out.println(TextColorUtil.textToRed("[4] Accountant [Salary: 2% of estate] [Reduce tax penalty by 50%]"));
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
                income += (building.getIncomePerVisitor() * getDailyVisitors());
            }
        }
        return income;
    }

    private static int getCosts() {
        return EmployeeFacade.getEmployeeSalaries();
    }

    public static Difficulty getDifficulty() {
        return difficulty;
    }

    public static long getEstate() {
        return estate;
    }

    public static void addEstate(long estate) {
        Game.estate += estate;
    }

    public static void pay(long price) {
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
        return Game.dailyVisitors;
    }

    public static void addDailyVisitors(int newDailyVisitors) {
        Game.dailyVisitors += newDailyVisitors;
    }

    public static void reduceDailyVisitors(int reduceDailyVisitors) {
        if (dailyVisitors - reduceDailyVisitors < 0) {
            dailyVisitors = 0;
        } else {
            dailyVisitors -= reduceDailyVisitors;
        }
    }

    public static void reduceDailyVisitorsByPercentage(int decreasePercentage) {
        int dailyVisitorsReduce = (int) ((double) getDailyVisitors() / (100.0) * decreasePercentage);
        reduceDailyVisitors(dailyVisitorsReduce);
    }
}
