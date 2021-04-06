package rollercoastertycoon.game;

public enum GameCommand {
    BUILD_COTTON_CANDY_VENDOR("Build a cotton candy vendor"),
    BUILD_BOAT_LAKE("Build a boat lake"),
    BUILD_CAROUSEL("Build a carousel"),
    BUILD_ROLLER_COASTER("Build a roller coaster"),
    BUILD_GHOST_TRAIN("Build a ghost train"),
    UPGRADE_COTTON_CANDY_VENDOR("Upgrade cotton candy vendor"),
    UPGRADE_BOAT_LAKE("Upgrade boat lake"),
    UPGRADE_CAROUSEL("Upgrade carousel"),
    UPGRADE_ROLLER_COASTER("Upgrade roller coaster"),
    UPGRADE_GHOST_TRAIN("Upgrade ghost train"),
    HIRE_MAINTAINER("Hire maintainer"),
    HIRE_ACCOUNTANT("Hire accountant"),
    FIRE_MAINTAINER("Fire maintainer"),
    FIRE_ACCOUNTANT("Fire accountant"),
    EXIT("Exit"),
    NEXT_TURN("Next turn"),
    MOTHERLOAD("Motherload");

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    private String command;
}
