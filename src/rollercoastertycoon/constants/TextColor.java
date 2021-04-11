package rollercoastertycoon.constants;

public enum TextColor {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    RESET("\u001B[0m");

    private String value;

    TextColor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
