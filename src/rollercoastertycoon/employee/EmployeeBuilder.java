package rollercoastertycoon.employee;

public class EmployeeBuilder {
    public static Accountant buildAccountant() {
        return new Accountant();
    }

    public static Maintainer buildMaintainer(int efficiency) {
        Maintainer maintainer;
        maintainer = new Maintainer(efficiency, efficiency);
        return maintainer;
    }
}
