import java.util.*;

public class Algorithm03 {
    public static void main(String[] args) {
        Integer[] mArr = getArr();
        long t = System.nanoTime();
        ArrayList<Integer> list = new ArrayList(Arrays.asList(mArr));
        System.out.println("Время преобразования ArrayL: " + (System.nanoTime() - t));
        System.out.println("Лист Array: " + list.toString());
        long i = System.nanoTime();
        LinkedList list2 = new LinkedList(Arrays.asList(mArr));
        System.out.println("Время преобразования LinkedL: " + (System.nanoTime() - i));
        System.out.println("Лист Linked: " + list2.toString());
        Integer f = 15;
        Integer r = 21;
        long q = System.nanoTime();
        list.add(f);
        System.out.println("Время add AL: " + (System.nanoTime() - q));
        long o = System.nanoTime();
        list2.add(r);
        System.out.println("Время add LL: " + (System.nanoTime() - o));
        System.out.println("Добавили последним элемент(15) AL: " + list.toString());
        System.out.println("Добавили последним элемент(21) LL: " + list2.toString());
        long w = System.nanoTime();
        System.out.println("Третий элемент(индекс 2) AL: " + list.get(2));
        System.out.println("Время get AL: " + (System.nanoTime() - w));
        long e = System.nanoTime();
        System.out.println("Третий элемент (индекс 2) LL: " + list2.get(2));
        System.out.println("Время get LL: " + (System.nanoTime() - e));
        long a = System.nanoTime();
        System.out.println("Есть ли элемент (14): " + list.contains(14));
        System.out.println("Время contains AL: " + (System.nanoTime() - a));
        long p = System.nanoTime();
        System.out.println("Есть ли элемент (14): " + list2.contains(14));
        System.out.println("Время contains LL: " + (System.nanoTime() - p));
        long y = System.nanoTime();
        System.out.println("Стираем элемент по индексу(2) AL: " + list.remove(2));
        System.out.println("Время remove AL: " + (System.nanoTime() - y));
        long s = System.nanoTime();
        System.out.println("Стираем элемент по индексу(2) LL: " + list2.remove(2));
        System.out.println("Время remove LL: " + (System.nanoTime() - s));
        long u = System.nanoTime();
        System.out.println(list.toString());
        System.out.println("Время toString: " + (System.nanoTime() - u));
        long d = System.nanoTime();
        System.out.println(list2.toString());
        System.out.println("Время toString: " + (System.nanoTime() - d));

    }

    public static Integer[] getArr() {
        Random rand = new Random();
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }
        return arr;
    }

    public class Model {
        private int num;

        public Model(int i) {
            this.num = i;
        }

        public int getNum() {
            return num;
        }
    }
//    public class OneWayList<E>{
//        private E link;
//        private OneWayList<E> next;
//
//        OneWayList(){
//
//        }
//    }

//    Задание 3.1
//    На основе массива из домашнего задания 2.1 реализуйте простой
//    список и коллекцию.
//    Оцените время выполнения преобразования.
//    Задание 3.2
//    На основе списка из задания 3.1 реализуйте основные методы
//    добавления, удаления и получения объекта или элемента из списка.
//    Оценить выполненные методы с помощью базового класса
//System.nanoTime().
//    Задание 3.3
//    Реализуйте простой односвязный список и его базовые методы.
//    Задание 3.4
//    На основе списка из задания 3.1 реализуйте простой двусторонний
//    список и его базовые методы.
//    Реализуйте список заполненный объектами из вашего класса из задания
//1.3
//    Задание 3.5
//    Реализуйте итератор на основе связанных списков из задания 3.4 и
//    выполните базовые операции итератора.
//    Оцените время выполнения операций с помощью базового метода
//System.nanoTime()
}
