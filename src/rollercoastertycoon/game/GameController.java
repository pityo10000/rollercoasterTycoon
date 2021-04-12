package rollercoastertycoon.game;

import rollercoastertycoon.employee.EmployeeFacade;
import rollercoastertycoon.util.TextColorUtil;

import java.util.Scanner;

public class GameController {
    private final Scanner scanner = new Scanner(System.in);

    public String askCommand() {
        System.out.println("----------------------------------------");
        System.out.println("What's your next decision?");
        return scanner.nextLine();
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
            String command = askCommand();
            if (checkAndProcessHireCommand(command)) {
                continue;
            }
            if (checkAndProcessFireCommand(command)) {
                continue;
            }

            GameCommand gameCommand = stringToGameCommand(command);
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
                    Game.addEstate(1_000_000_000L);
                    break;
                default:
                    System.out.println("Wrong command! Try again!");
            }
        }
    }

    private static boolean checkAndProcessHireCommand(String command) {
        String[] commandParts = command.split(" ");
        if (commandParts.length != 2) {
            return false;
        }
        if (!GameCommand.HIRE.getCommand().equalsIgnoreCase((commandParts[0]))) {
            return false;
        }
        try {
            int position = Integer.parseInt(commandParts[1]);
            switch (position) {
                case 1:
                    EmployeeFacade.hireMaintainer(3);
                    break;
                case 2:
                    EmployeeFacade.hireMaintainer(4);
                    break;
                case 3:
                    EmployeeFacade.hireMaintainer(5);
                    break;
                case 4:
                    EmployeeFacade.hireAccountant();
                    break;
                default:
                    System.out.println(TextColorUtil.textToRed("Unknown employee!"));
            }
            Game.printAllStatuses();
        } catch (NumberFormatException e) {
            System.out.println(TextColorUtil.textToRed("Unknown employee!"));
        }
        return true;
    }

    private static boolean checkAndProcessFireCommand(String command) {
        String[] commandParts = command.split(" ");
        if (commandParts.length != 2) {
            return false;
        }
        if (!GameCommand.FIRE.getCommand().equalsIgnoreCase(commandParts[0])) {
            return false;
        }
        try {
            int position = Integer.parseInt(commandParts[1]);
            EmployeeFacade.fire(position);
            Game.printAllStatuses();
        } catch (NumberFormatException e) {
            System.out.println(TextColorUtil.textToRed("Unrecognized position!"));
        }
        return true;
    }

    private static GameCommand stringToGameCommand(String inputCommand) {
        for (GameCommand gameCommand : GameCommand.values()) {
            if (gameCommand.getCommand().equalsIgnoreCase(inputCommand)) {
                return gameCommand;
            }
        }

        return GameCommand.UNKNOWN_COMMAND;
    }



}