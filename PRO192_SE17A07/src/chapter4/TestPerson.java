package chapter4;

import java.util.ArrayList;
   

public class TestPerson {

    public static void main(String[] args) {
        Student st = new Student("a", 18, "sup", 8);
        System.out.println(st);
        st.doing();
        st.evaluate();
        Teacher tc = new Teacher("d", 61, "sup", 61);
        System.out.println(tc);
        tc.doing();
        tc.evaluate();
        ArrayList<Teacher> stdList = new ArrayList<>();
        stdList.add(tc);
        stdList.add(new Teacher("A", 5, "a", 5));
        stdList.add(new Teacher("D", 61, "b", 10));
        stdList.add(new Teacher("C", 4, "c", 1));
        stdList.sort((Teacher t1, Teacher t2)->{return Double.compare(t1.getSalary(), t2.getSalary());});
        for(Teacher t:stdList) {
            System.out.println(t);
        }
        Manager mg = new Manager("b", 20, "bruh", 7, 8);
        System.out.println(mg);
        mg.doing();
        Person p = new Student("c", 20, "wut", 8);
        System.out.println(p);
        p = new Teacher("e", 4, "sup", 7);
        System.out.println(p);
        p = new Manager("bruh", 4, "sup", 5, 7);
        System.out.println(p);
        Teacher t = new Manager("sup", 5, "bruh", 5 ,7);
        System.out.println(((Teacher)t).getSalary());
    }
}
