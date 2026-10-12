package Lambda;
import java.util.function.*;

public class FIType {
    public static void main(String[] args) {
        Predicate<Integer> p = n -> n%2 == 0;
        System.out.println("Predicate: " + p.test(10));

        BiFunction<Integer, Integer, Integer> fun =
                (a,b) -> a*b;
        System.out.println("Function: " + fun.apply(3,5));

        Consumer<String> c =
                name -> System.out.println(name);
        c.accept("Rahul");

        Supplier<Double> s = () -> Math.random()*100;
        System.out.println("Supplier: " + s.get());
    }
}
