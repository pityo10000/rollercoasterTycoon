package rollercoastertycoon.employee;

import rollercoastertycoon.constants.EmployeeType;
import rollercoastertycoon.game.Game;
import rollercoastertycoon.game.GameException;
import rollercoastertycoon.util.TextColorUtil;

public class EmployeeFacade {
    private static final int MAX_POSITIONS_AMOUNT = 6;
    private static final int MAINTAINER_POSITIONS_AMOUNT = 5;
    private static final int ACCOUNTANT_POSITIONS_AMOUNT = 1;

    private static final Position[] positions = new Position[MAX_POSITIONS_AMOUNT];

    public static void initPositions() {
        if (MAX_POSITIONS_AMOUNT != ACCOUNTANT_POSITIONS_AMOUNT + MAINTAINER_POSITIONS_AMOUNT) {
            throw new GameException("Wrong position amounts are set!");
        }
        int i = 0;
        while (i < MAINTAINER_POSITIONS_AMOUNT) {
            positions[i] = new Position(EmployeeType.MAINTAINER);
            i++;
        }
        while (i < MAX_POSITIONS_AMOUNT) {
            positions[i] = new Position(EmployeeType.ACCOUNTANT);
            i++;
        }
    }

    public static int getEmployeeSalaries() {
        int salary = 0;
        for (Position position : positions) {
            if (!position.isAvailable) {
                salary += (int) (((float) Game.getEstate() / 100F) * (float) position.getEmployee().getCostPercentage());
            }
        }
        return salary;
    }

    public static void payEmployees() {
        Game.pay(getEmployeeSalaries());
    }

    public static void hireMaintainer(int efficiency) {
        Employee maintainer = EmployeeBuilder.buildMaintainer(efficiency);
        for (Position position : positions) {
            if (EmployeeType.MAINTAINER.equals(position.getType()) && position.isAvailable()) {
                position.fill(maintainer);
                break;
            }
        }
    }

    public static void hireAccountant() {
        Employee accountant = EmployeeBuilder.buildAccountant();
        for (Position position : positions) {
            if (EmployeeType.ACCOUNTANT.equals(position.getType()) && position.isAvailable()) {
                position.fill(accountant);
                break;
            }
        }
    }

    public static void fire(int position) {
        if (position < 1 || MAX_POSITIONS_AMOUNT < position) {
            System.out.println(TextColorUtil.textToRed("There is no position " + position));
            return;
        }

        positions[position - 1].fire();
    }

    public static Position[] getPositions() {
        return positions;
    }

    public static int getSumCrashProbabilityReducement() {
        int sum = 0;

        for (int i = 0; i < MAINTAINER_POSITIONS_AMOUNT; i++) {
            Position position = positions[i];
            if (!position.isAvailable()) {
                sum += position.getEmployee().getCostPercentage();
            }
        }

        return sum;
    }

    public static class Position {
        private boolean isAvailable;
        private Employee employee;
        private EmployeeType type;

        public Position(EmployeeType type) {
            this.type = type;
            this.isAvailable = true;
        }

        public void fill(Employee employee) {
            isAvailable = false;
            this.employee = employee;
        }

        public void fire() {
            isAvailable = true;
            this.employee = null;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public EmployeeType getType() {
            return type;
        }
    }
}
