package rollercoastertycoon.game;

import java.util.Scanner;

public class GameController {
    private final Scanner scanner = new Scanner(System.in);

    public GameCommand askCommand() {
        System.out.println("----------------------------------------");
        System.out.println("What's your next decision?");
        String inputCommand = scanner.nextLine();
        for (GameCommand gameCommand : GameCommand.values()) {
            if (gameCommand.getCommand().equalsIgnoreCase(inputCommand)) {
                return gameCommand;
            }
        }

        return GameCommand.UNKNOWN_COMMAND;
    }

    public Difficulty askDifficulty() {
        System.out.println("Welcome to Rollercoaster Tycoon v1.0");
        System.out.println("Choose difficulty (EASY, MEDIUM, HARD)");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase(GameCommand.EXIT.getCommand())) {
                System.exit(0);
            }
            for (Difficulty difficulty : Difficulty.values()) {
                if (difficulty.name().equalsIgnoreCase(input)) {
                    return difficulty;
                }
            }
            System.out.println("Unknown difficulty! Try again (EASY, MEDIUM, HARD)!");
        }
    }

    public void processCommands() {
        while (true) {
            GameCommand gameCommand = askCommand();
            switch (gameCommand) {
                case BUILD_CAROUSEL:
                    Game.getCarousel().build();
                    Game.printAllStatuses();
                    break;
                case BUILD_BOAT_LAKE:
                    Game.getBoatLake().build();
                    Game.printAllStatuses();
                    break;
                case BUILD_COTTON_CANDY_VENDOR:
                    Game.getCottonCandyVendor().build();
                    Game.printAllStatuses();
                    break;
                case BUILD_GHOST_TRAIN:
                    Game.getGhostTrain().build();
                    Game.printAllStatuses();
                    break;
                case BUILD_ROLLER_COASTER:
                    Game.getRollerCoaster().build();
                    Game.printAllStatuses();
                    break;
                case UPGRADE_CAROUSEL:
                    Game.getCarousel().upgrade();
                    Game.printAllStatuses();
                    break;
                case UPGRADE_BOAT_LAKE:
                    Game.getBoatLake().upgrade();
                    Game.printAllStatuses();
                    break;
                case UPGRADE_COTTON_CANDY_VENDOR:
                    Game.getCottonCandyVendor().upgrade();
                    Game.printAllStatuses();
                    break;
                case UPGRADE_GHOST_TRAIN:
                    Game.getGhostTrain().upgrade();
                    Game.printAllStatuses();
                    break;
                case UPGRADE_ROLLER_COASTER:
                    Game.getRollerCoaster().upgrade();
                    Game.printAllStatuses();
                    break;
                case ACTIVATE_AD_SENSE:
                    Game.getAdSense().activate();
                    Game.printAllStatuses();
                    break;
                case ACTIVATE_BILL_BOARD:
                    Game.getBillBoard().activate();
                    Game.printAllStatuses();
                    break;
                case ACTIVATE_FLYER:
                    Game.getFlyer().activate();
                    Game.printAllStatuses();
                    break;
                case ACTIVATE_NEWSPAPER:
                    Game.getNewspaper().activate();
                    Game.printAllStatuses();
                    break;
                case ACTIVATE_TELEVISION:
                    Game.getTelevision().activate();
                    Game.printAllStatuses();
                    break;
                case HIRE_MAINTAINER:
                    break;
                case HIRE_ACCOUNTANT:
                    break;
                case FIRE_MAINTAINER:
                    break;
                case FIRE_ACCOUNTANT:
                    break;
                case PRINT_FINANCE_STATUS:
                    Game.printFinanceStatus();
                    break;
                case PRINT_BUILDING_STATUS:
                    Game.printBuildingStatus();
                    break;
                case PRINT_ADVERT_STATUS:
                    Game.printAdvertStatus();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                case NEXT_TURN:
                    Game.nextTurn();
                    Game.printAllStatuses();
                    break;
                case MOTHERLOAD:
                    Game.addEstate(1_000_000);
                    break;
                default:
                    System.out.println("Wrong command! Try again!");
            }
        }
    }
}