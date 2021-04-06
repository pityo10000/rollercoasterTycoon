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

    public void processCommand() {
        while (true) {
            GameCommand gameCommand = askCommand();
            switch (gameCommand) {
                case BUILD_CAROUSEL:
                    Game.getCarousel().build();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
                    break;
                case BUILD_BOAT_LAKE:
                    Game.getBoatLake().build();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
                    break;
                case BUILD_COTTON_CANDY_VENDOR:
                    Game.getCottonCandyVendor().build();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
                    break;
                case BUILD_GHOST_TRAIN:
                    Game.getGhostTrain().build();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
                    break;
                case BUILD_ROLLER_COASTER:
                    Game.getRollerCoaster().build();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
                    break;
                case UPGRADE_CAROUSEL:
                    Game.getCarousel().upgrade();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
                    break;
                case UPGRADE_BOAT_LAKE:
                    Game.getBoatLake().upgrade();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
                    break;
                case UPGRADE_COTTON_CANDY_VENDOR:
                    Game.getCottonCandyVendor().upgrade();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
                    break;
                case UPGRADE_GHOST_TRAIN:
                    Game.getGhostTrain().upgrade();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
                    break;
                case UPGRADE_ROLLER_COASTER:
                    Game.getRollerCoaster().upgrade();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
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
                case EXIT:
                    System.exit(0);
                    break;
                case NEXT_TURN:
                    Game.nextTurn();
                    Game.printFinanceStatus();
                    Game.printBuildingStatus();
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