package Collection;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
//        ArrayList<Integer> numbers = new ArrayList<>();
//
//        numbers.add(10);
//        numbers.add(20);
//        numbers.add(30);
//        numbers.add(40);
//        numbers.add(50);
//        numbers.add(60);
//        numbers.add(70);
//        numbers.add(80);
//        numbers.add(90);
//        numbers.add(100);
//
//        numbers.set(2, 35);
//        numbers.set(3, 85);
//
//        System.out.println("Updated elements: " + numbers.get(2) + ", " + numbers.get(3));
//        System.out.println(numbers.indexOf(35));
//        numbers.clear();
//        numbers.addFirst(25);
//        numbers.addLast(50);
//        System.out.println("All elements"+ numbers);
//
//
//        Stack<Integer> st = new Stack<>();
//        st.push(20);
//        st.push(30);
//        st.push(40);
//        st.push(50);
//        st.push(60);
//
//        st.pop();
//        st.pop();
//        st.push(80);
//        System.out.println(st.search(40));
//        st.pop();
//        System.out.println(st.peek());
//        System.out.println(st.size());
//        System.out.println(st);

//        LinkedList<String> fruits = new LinkedList<>();
//        fruits.add("Apple");
//        fruits.add("Banana");
//        fruits.add("Mango");
//        fruits.add("Watermelon");
//        fruits.add("Pineapple");
//
//        fruits.addFirst("Orange");
//        fruits.addFirst("Grapes");


        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);

        st.pop();
        st.pop();
        st.push(80);
        st.pop();
        System.out.println(st.peek());
        System.out.println(st.size());
        System.out.println(st);

    }
}
