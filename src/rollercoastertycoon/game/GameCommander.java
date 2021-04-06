package rollercoastertycoon.game;

import java.util.Scanner;

public class GameCommander {
    private final Scanner scanner = new Scanner(System.in);

    public GameCommand askCommand() {
        GameCommand returnedCommand = null;

        System.out.println("What's your next decision?");
        String inputCommand = scanner.nextLine();
        for (GameCommand gameCommand : GameCommand.values()) {
            if (gameCommand.getCommand().equalsIgnoreCase(inputCommand)) {
                returnedCommand = gameCommand;
            }
        }

        return returnedCommand;
    }

    public void processCommand() {
        while (true) {
            GameCommand gameCommand = askCommand();
            switch (gameCommand) {
                case BUILD_CAROUSEL:
                    Game.getCarousel().build();
                    break;
                case BUILD_BOAT_LAKE:
                    Game.getBoatLake().build();
                    break;
                case BUILD_COTTON_CANDY_VENDOR:
                    Game.getCottonCandyVendor().build();
                    break;
                case BUILD_GHOST_TRAIN:
                    Game.getGhostTrain().build();
                    break;
                case BUILD_ROLLER_COASTER:
                    Game.getRollerCoaster().build();
                    break;
                case UPGRADE_CAROUSEL:
                    Game.getCarousel().upgrade();
                    break;
                case UPGRADE_BOAT_LAKE:
                    Game.getBoatLake().upgrade();
                    break;
                case UPGRADE_COTTON_CANDY_VENDOR:
                    Game.getCottonCandyVendor().upgrade();
                    break;
                case UPGRADE_GHOST_TRAIN:
                    Game.getGhostTrain().upgrade();
                    break;
                case UPGRADE_ROLLER_COASTER:
                    Game.getRollerCoaster().upgrade();
                    break;
                case HIRE_MAINTAINER:
                    break;
                case HIRE_ACCOUNTANT:
                    break;
                case FIRE_MAINTAINER:
                    break;
                case FIRE_ACCOUNTANT:
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                case NEXT_TURN:
                    Game.nextTurn();
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