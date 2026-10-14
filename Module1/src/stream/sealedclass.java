package stream;

public class sealedclass {
    public static void main(String[] args) {
        String day = "Monday";
        String type = switch (day){
            case "Monday","Tuesday","Wednesday","Thursday","Friday" -> "Weekday";
            case "Saturday","Sunday" -> "Weekend";
            default -> "Invalid Day";
        };
        System.out.println(type);
    }
}
