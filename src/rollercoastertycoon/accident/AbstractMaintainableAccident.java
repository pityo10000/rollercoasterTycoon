package rollercoastertycoon.accident;

import rollercoastertycoon.employee.EmployeeFacade;

public abstract class AbstractMaintainableAccident extends AbstractAccident {
    @Override
    public float getProbability() {
        float probability = super.getProbability();
        int probabilityReducement = EmployeeFacade.getSumCrashProbabilityReducement();
        probability -= (float) probabilityReducement;
        if (probability < 0) {
            probability = 0;
        }
        return probability;
    }
}
