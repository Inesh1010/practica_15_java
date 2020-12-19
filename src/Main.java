import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static <E> List<E> asList(E[] a) {
        return new MyCollection<E>(a);
    }

    public static class MyCollection<E> extends AbstractList<E> {

        private final E[] a;

        MyCollection(E[] array) {
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

        ArrayList<Student> studentsAL = new ArrayList<>();
        LinkedList<Student> studentsLL = new LinkedList<>();

        for (int i = 0; i < 10000000; ++i) {
            studentsAL.add(new Student(42));
            studentsLL.add(new Student(64));
        }

        System.out.println("======== ACCESS TIME =========");

        long timeStart = System.currentTimeMillis();
        Student student = studentsAL.get(9777657);
        long timeFinish = System.currentTimeMillis();

        long timeAL = timeFinish - timeStart;


        timeStart = System.currentTimeMillis();
        student = studentsLL.get(9777657);
        timeFinish = System.currentTimeMillis();

        long timeLL = timeFinish - timeStart;

        System.out.println("ARRAY LIST: " + timeAL);
        System.out.println("LINKED LIST: " + timeLL);

        // Доступ к произвольному элементу по индексу для связного списка требует больше времени,
        // т.к. для получения значения элемента с индексом i нужно пройти все элементы предшествующие i,
        // то есть доступ по индексу осуществляется за линейное время.
        // Исключениями являются первый и последний элемент, к ним доступ осуществляется за константное время.

        // В обычном массиве доступ по индексу осуществляется за константное время.

        System.out.println("===== INSERTION ======");

        student = new Student(11);

        timeStart = System.currentTimeMillis();
        studentsAL.add(77657, student);
        timeFinish = System.currentTimeMillis();

        timeAL = timeFinish - timeStart;

        timeStart = System.currentTimeMillis();
        studentsLL.add(77657, student);
        timeFinish = System.currentTimeMillis();

        timeLL = timeFinish - timeStart;

        System.out.println("ARRAY LIST: " + timeAL);
        System.out.println("LINKED LIST: " + timeLL);

        // Вставка нового элемента в произвольное место в массиве зависит от того, насколько близко к концу массива
        // добавляется элемент, так как после вставки нового элемента все элементы правее его сдвигаются.
        // Чем ближе к концу массива вставляется элемент, тем быстрее осуществляется операция вставки.

        // Вставка нового элемента в произвольное место в связном списке осуществляется за константное время, если
        // элемент вставляется с правого или левого конца связного списка и за линейное время, если в иное произвольное
        // место. Это связано с тем, что чтобы добавить новый элемент в позицию i, необходимо пройти сначала до элемента,
        // с позицией i и добавить ссылку на вставляемый элемент.

        Student[] array = new Student[10000000];

        for (int i = 0; i < 10000000; ++i) {
            array[i] = new Student(i+1);
        }

        MyCollection<Student> studentsMC = new MyCollection<>(array);

        System.out.println("===== MY COLLECTION =====");

        student = studentsMC.get(9777657);

        System.out.println("OLD STUDENT 9777657: " + student);

        studentsMC.set(9777657, new Student(-10));

        student = studentsMC.get(9777657);

        System.out.println("NEW STUDENT 9777657: " + student);

    }

}
