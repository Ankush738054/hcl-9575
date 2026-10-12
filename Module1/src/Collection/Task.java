package Collection;
import java.util.*;
public class Task {
    static class student implements Comparable<student>{
        String name;
        int rollno;
        int age;
        int marks;
        public student(String name, int rollno, int age, int marks){
            this.name = name;
            this.rollno = rollno;
            this.age = age;
            this.marks = marks;
        }
        @Override
        public String toString() {
            return name + " " + rollno + " " + age + " " + marks;
        }
        public int compareTo(student o) {
            return this.age-o.age;
        }
    }
    static class MyComparator implements Comparator<student>{
        public int compare(student s1, student s2){
            return Integer.compare(s1.marks, s2.marks);
        }
    }
    public static void main(String[] args) {
        ArrayList<student> List = new ArrayList<>(10);
        List.add(new student("A",1,10,20));
        List.add(new student("B",2,30,40));
        List.add(new student("C",3,50,60));
        List.add(new student("D",4,60,30));
        List.add(new student("E",5,50,50));
        List.add(new student("F",6,20,20));
        List.add(new student("G",7,60,70));
        List.add(new student("H",8,40,40));
        List.add(new student("I",9,70,60));
        List.add(new student("J",10,70,60));


        Collections.sort(List,new MyComparator());
        System.out.println(List);
//        System.out.println(List);
//        Collections.sort(List,(x,y)-> Integer.compare(x.age,y.age));
//        System.out.println(List);
//        Collections.sort(List,(x,y)-> Integer.compare(x.marks,y.marks));
//        System.out.println(List);
    }
}
