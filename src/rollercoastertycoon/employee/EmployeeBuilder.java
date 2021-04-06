package rollercoastertycoon.employee;

import java.util.Random;

public class EmployeeBuilder {
    private static final Random RANDOM = new Random();

    public static Accountant buildAccountant() {
        return new Accountant();
    }

    public static Maintainer buildMaintainer() {
        Maintainer maintainer;

        int efficiency = RANDOM.nextInt(3) + 1;
        maintainer = new Maintainer(efficiency, efficiency);

        return maintainer;
    }
}
