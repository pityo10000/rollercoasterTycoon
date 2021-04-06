package rollercoastertycoon.employee;

class Accountant extends AbstractEmployee {
    private static final int COST_PERCENTAGE = 2;
    private static final int ACCIDENT_COST_REDUCE_PERCENTAGE = 50;

    public Accountant() {
        super(COST_PERCENTAGE);
    }

    public int getAccidentCostReducePercentage() {
        return ACCIDENT_COST_REDUCE_PERCENTAGE;
    }
}
