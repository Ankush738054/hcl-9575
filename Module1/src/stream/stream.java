package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class stream {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.stream().filter(n -> n % 2 == 0).forEach(System.out::print);
        System.out.println();
        arr.stream().map(n -> n + 5).forEach(System.out::print);
        System.out.println();

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("Ankush");
        arr2.add("Aman");
        arr2.add("Ashish");
        arr2.add("Amitabh");
        arr2.add("Abhay");
        arr2.stream().filter(n -> n.startsWith("Am")).forEach(System.out::println);
        System.out.println();
        arr2.stream().sorted().forEach(System.out::println);
        System.out.println();
        arr2.stream().map(n->"Mr "+n).forEach(System.out::println);
        System.out.println();

        HashMap<String,String> mpp = new HashMap<>();
        mpp.put("Ankush","male");
        mpp.put("kajsbd","female");
        mpp.put("sjdbf","female");
        mpp.put("sljkdj","male");
        mpp.put("Abc","male");
        mpp.entrySet().stream().map(entry -> entry.getValue().equals("female") ? "Mrs. " + entry.getKey(): "Mr. " + entry.getKey()).forEach(System.out::println);
    }
}
