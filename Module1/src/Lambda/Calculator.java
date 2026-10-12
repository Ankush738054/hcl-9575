package Lambda;

public class Calculator {
    @FunctionalInterface
    interface calculator{
        void calc(int a, int b);
    }

    public static void main(String[] args) {
        calculator add = (int a, int b) -> {
            System.out.println("Addition: " + (a+b));
        };
        calculator sub = (int a, int b) -> {
            System.out.println("sub: " + (a-b));
        };
        calculator mul = (int a, int b) -> {
            System.out.println("Mul: " + (a*b));
        };
        calculator div = (int a, int b) -> {
            System.out.println("Div: " + (a/b));
        };
        calculator Sqr = (int a, int b) -> {
            System.out.println("SqrA: " + (a*a));
            System.out.println("SqrB: " + (b*b));
        };
        add.calc(2,5);
        sub.calc(2,5);
        mul.calc(2,5);
        div.calc(2,5);
        Sqr.calc(2,5);

    }
}
