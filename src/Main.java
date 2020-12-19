import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static <E> List<E> asList(E[] a) {
        return new arr<E>(a);
    }

    public static class arr<E> extends AbstractList<E> {

        private final E[] a;

        arr(E[] array) {
            a = array;
        }

        public E get(int index) {
            return a[index];
        }

        public E set(int index, E element) {
            E oldValue = a[index];
            a[index] = element;
            return oldValue;
        }

        public int size() {
            return a.length;
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> studAr = new ArrayList<>();
        LinkedList<Student> studLink = new LinkedList<>();

        for (int i = 0; i < 10000000; ++i) {
            studAr.add(new Student(33));
            studLink.add(new Student(45));
        }

        long t0 = System.currentTimeMillis();
        Student stud = studAr.get(7945332);
        long t1 = System.currentTimeMillis();

        long timeArList = t1 - t0;

        t0 = System.currentTimeMillis();
        stud = studLink.get(7945332);
        t1 = System.currentTimeMillis();

        long timeLinkList = t1 - t0;

        System.out.println("ArList: " + timeArList);
        System.out.println("LinkList: " + timeLinkList);


        stud = new Student(23);

        t0 = System.currentTimeMillis();
        studAr.add(84532, stud);
        t1 = System.currentTimeMillis();

        timeArList = t1 - t0;

        t0 = System.currentTimeMillis();
        studLink.add(84532, stud);
        t1 = System.currentTimeMillis();

        timeLinkList = t1 - t0;

        System.out.println("ArrayList: " + timeArList);
        System.out.println("LinkedList: " + timeLinkList);


        Student[] array = new Student[10000000];

        for (int i = 0; i < 10000000; ++i) {
            array[i] = new Student(i+2);
        }

        arr<Student> studOA = new arr<>(array);

        stud = studOA.get(7945332);
        System.out.println("студент 8987426: " + stud);
        studOA.set(7945332, new Student(-23));
        stud = studOA.get(7945332);
        System.out.println("студент 8987426: " + stud);

    }

}
