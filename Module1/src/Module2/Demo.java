package Module2;

public class Demo {
    public static void main(String[] args) {
        singleobject obj1 = singleobject.createInstance();
        singleobject obj2 = singleobject.createInstance();
        System.out.println(obj1.hashCode() == obj2.hashCode());
//        System.out.println();
        System.out.println(obj1.equals(obj2));
    }
}
