import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static <E> List<E> asList(E[] a) {
        return new OwnArray<E>(a);
    }

    public static class OwnArray<E> extends AbstractList<E> {

        private final E[] a;

        OwnArray(E[] array) {
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

        ArrayList<Student> studentsArList = new ArrayList<>();
        LinkedList<Student> studentsLinkList = new LinkedList<>();

        for (int i = 0; i < 10000000; ++i) {
            studentsArList.add(new Student(33));
            studentsLinkList.add(new Student(45));
        }


        long t0 = System.currentTimeMillis();
        Student student = studentsArList.get(8987426);
        long t1 = System.currentTimeMillis();

        long timeArList = t1 - t0;


        t0 = System.currentTimeMillis();
        student = studentsLinkList.get(8987426);
        t1 = System.currentTimeMillis();

        long timeLinkList = t1 - t0;

        System.out.println("ArrayList: " + timeArList);
        System.out.println("LinkedList: " + timeLinkList);


        student = new Student(43);

        t0 = System.currentTimeMillis();
        studentsArList.add(77657, student);
        t1 = System.currentTimeMillis();

        timeArList = t1 - t0;

        t0 = System.currentTimeMillis();
        studentsLinkList.add(77657, student);
        t1 = System.currentTimeMillis();

        timeLinkList = t1 - t0;

        System.out.println("ArrayList: " + timeArList);
        System.out.println("LinkedList: " + timeLinkList);


        Student[] array = new Student[10000000];

        for (int i = 0; i < 10000000; ++i) {
            array[i] = new Student(i+6);
        }

        OwnArray<Student> studentsOA = new OwnArray<>(array);

        student = studentsOA.get(8987426);

        System.out.println("студент 8987426: " + student);

        studentsOA.set(8987426, new Student(-23));

        student = studentsOA.get(8987426);

        System.out.println("студент 8987426: " + student);

    }

}
