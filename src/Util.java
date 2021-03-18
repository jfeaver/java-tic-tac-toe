public class Util {
    static Integer parseInt(String maybeInt) {
        try {
            return Integer.parseInt(maybeInt, 10);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
