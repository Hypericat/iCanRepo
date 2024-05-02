import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static boolean isNumerical(String text) {
        for (char cha : text.toCharArray()) {
            if (!"1234567890".contains(String.valueOf(cha))) return false;
        }
        return true;
    }
}
