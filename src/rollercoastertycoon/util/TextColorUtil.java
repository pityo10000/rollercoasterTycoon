package rollercoastertycoon.util;

import rollercoastertycoon.constants.TextColor;

public class TextColorUtil {

    public static String textToRed(String text) {
        return textToColor(TextColor.RED, text);
    }

    public static String textToGreen(String text) {
        return textToColor(TextColor.GREEN, text);
    }

    private static String textToColor(TextColor color, String text) {
        return color.getValue() + text + TextColor.RESET.getValue();
    }
}
