package generic;
import java.util.*;

class Box<T>{
    T value;

    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value =value;
    }
}
public class generic {
    public static void main(String[] args) {
       Box<Integer> b1 = new Box<Integer>();
       b1.setValue(10);
        System.out.println(b1.getValue());

        Box<String> b2 = new Box<String>();
        b2.setValue("Ankush");
        System.out.println(b2.getValue());
    }
}
