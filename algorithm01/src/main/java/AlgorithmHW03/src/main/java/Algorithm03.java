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

        OWList<Model> li = new OWList<>();
        li.insert(new Model(15));
        li.insert(new Model(2));
        Random rn = new Random();
        for(int b=0; b<10;b++) {
            li.insert(new Model(rn.nextInt(25)));
        }
        System.out.println("Собран односторонний лист моделей.");
        li.display();
        System.out.println("Ищем модель 2");
        System.out.println(li.find(new Model(2)));
        System.out.println("");
        while(!li.isEmpty()){
            li.delete();
            System.out.println("Элемент стерт.");
            li.display();
        }
        System.out.println("Лист стерт.");
        li.display();

        TWList<Model> li2 = new TWList<>();
        li2.insertFirst(new Model(15));
        li2.insertLast(new Model(2));
        for(int b=0; b<10;b++) {
            li2.insertLast(new Model(rn.nextInt(25)));
        }
        System.out.println("Собран двухсторонний лист моделей.");
        li2.display();
        System.out.println("Ищем модель 2");
        System.out.println(li2.find(new Model(2)));
        System.out.println("");
        for(int h=0;h<3;h++){
            if(!li2.isEmpty()){
                li2.deleteLast();
                System.out.println("Элемент стерт c конца.");
                li2.display();
            }
        }
        while(!li2.isEmpty()){
            li2.delete();
            System.out.println("Элемент стерт с начала.");
            li2.display();
        }
        System.out.println("Двухсторонний лист стерт.");
        li2.display();
        System.out.println("");
        LinkedList<Model> li3 = new LinkedList();
        for(int b=0; b<10;b++) {
            li3.add(new Model(rn.nextInt(25)));
        }
//        System.out.println("Собран двухсторонний лист для стандартного итератора.");
//        Iterator iter = li3.iterator();
//        System.out.println("Работа итератора: перебор hasNext,next & remove: ");
//        while(iter.hasNext()){
//            System.out.println(iter.next());
//            iter.remove();
//        }
//        System.out.println("Лист стерт.");
//        li3.stream().forEach(System.out::println);

        TWList<Model> li4 = new TWList<>();
        for(int b=0; b<10;b++) {
            li4.insertFirst(new Model(rn.nextInt(25)));
        }
        System.out.println("Собран двухсторонний лист для своего итератора.");
        li4.display();
        Iterator it = li4.iterator();
        long c = System.nanoTime();
        for (int v = 0;v<4;v++){
            if (it.hasNext()) it.next();
        }
        it.remove();
        long v = System.nanoTime();
        System.out.println("Удалили 4 элемент (hasNext,next,remove): ");
        li4.display();
        System.out.println("Время работы: "+(v-c));
    }

    public static Integer[] getArr() {
        Random rand = new Random();
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(15);
        }
        return arr;
    }
}



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

