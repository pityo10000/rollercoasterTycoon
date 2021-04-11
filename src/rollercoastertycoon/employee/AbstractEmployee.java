package rollercoastertycoon.employee;

abstract class AbstractEmployee implements Employee {
    private final int costPercentage;

    private String name;

    public AbstractEmployee(int costPercentage) {
        this.costPercentage = costPercentage;
    }

    @Override
    public int getCostPercentage() {
        return costPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
