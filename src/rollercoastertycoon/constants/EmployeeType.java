package rollercoastertycoon.constants;

public enum EmployeeType {
    MAINTAINER("Maintainer"),
    ACCOUNTANT("Accountant");

    private String value;

    EmployeeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
