package rollercoastertycoon.game;

public enum GameCommand {
    BUILD_COTTON_CANDY_VENDOR("Build cotton candy vendor"),
    BUILD_BOAT_LAKE("Build boat lake"),
    BUILD_CAROUSEL("Build carousel"),
    BUILD_ROLLER_COASTER("Build roller coaster"),
    BUILD_GHOST_TRAIN("Build ghost train"),
    UPGRADE_COTTON_CANDY_VENDOR("Upgrade cotton candy vendor"),
    UPGRADE_BOAT_LAKE("Upgrade boat lake"),
    UPGRADE_CAROUSEL("Upgrade carousel"),
    UPGRADE_ROLLER_COASTER("Upgrade roller coaster"),
    UPGRADE_GHOST_TRAIN("Upgrade ghost train"),
    ACTIVATE_AD_SENSE("Activate AdSense"),
    ACTIVATE_BILL_BOARD("Activate bill board"),
    ACTIVATE_FLYER("Activate flyer"),
    ACTIVATE_NEWSPAPER("Activate newspaper"),
    ACTIVATE_TELEVISION("Activate television"),
    FIRE("Fire"),
    HIRE("Hire"),
    PRINT_FINANCE_STATUS("Print finance"),
    PRINT_BUILDING_STATUS("Print buildings"),
    PRINT_ADVERT_STATUS("Print adverts"),
    EXIT("Exit"),
    NEXT_TURN("Next turn"),
    MOTHERLOAD("Motherload"),
    UNKNOWN_COMMAND("Unknown command!");

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    private String command;
}
