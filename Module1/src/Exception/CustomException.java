package Exception;


public class CustomException {
    static class InvalidAgeException extends RuntimeException {
        InvalidAgeException() {
            System.out.println("Age must be 18 or above!");
        }
    }
    public static void main(String[] args)  {
        int age = 16;
        try {
            if (age < 18) {
                throw new InvalidAgeException();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
//        if (age < 18) {
//            throw new InvalidAgeException();
//        }
//        System.out.println("Execute after exception");
    }
}
