package rollercoastertycoon.employee;

public class Maintainer extends AbstractEmployee {
    private int probabilityPercentage;

    public Maintainer(int costPercentage, int probabilityReducePercentage) {
        super(costPercentage);
        this.probabilityPercentage = probabilityReducePercentage;
    }

    public int getProbabilityPercentage() {
        return probabilityPercentage;
    }
}
