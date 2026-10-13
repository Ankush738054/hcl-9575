package Exception;
import java.util.*;
import static java.lang.System.exit;
public class UseExit {
    public static void main() {
        try {
            System.out.println(10/0);
            exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(100);
        }
    }
}
