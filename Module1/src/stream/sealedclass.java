package stream;

public class sealedclass {
    public static void main(String[] args) {
        String day = "Saturday";
        String temp = "";
        switch (day){
            case "Monday":
                temp = "Weekday";
                break;
            case "Tuesday":
                temp = "Weekday";
                break;
            case "Wednesday":
                temp = "Weekday";
                break;
            case "Thursday":
                temp = "Weekday";
                break;
            case "Friday":
                temp = "Weekday";
                break;
            case "Saturday":
                temp = "Weekend";
                break;
            case "Sunday":
                temp = "Weekend";
                break;
        }
        System.out.println(temp);
    }
}
