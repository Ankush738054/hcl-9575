package Exception;

public class Excep {
    public static void main() {
        try {
            System.out.println(10/0);
        } catch (Exception e) {
//            System.out.println(e);
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(100);
        }
    }
}
