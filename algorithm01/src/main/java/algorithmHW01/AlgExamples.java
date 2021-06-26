package algorithmHW01;

import java.util.ArrayList;
import java.util.List;

public class AlgExamples {
//    Домашние задание №1

//    Задание 1.1
//    Приведите пример алгоритмов и структур данных из жизни.

    //Алгоритм принятия заявок от населения, алгоритм расчета прибыли, алгоритм приготовления блюда.

//    Задание 1.2
//    Приведите пример алгоритмов и структур данных в
//    программировании.

    //Алгоритмы хранения, поиска, изменения данных, сортировки.

//            Задание 1.3
//    Напишите программный код, в котором все данные хранятся только в
//    переменных трех типов данных: Ссылочные, примитивные и своего класса
//    содержащего: конструктор и метод отображения данных.
//    Выведите написанные данные.
//            Задание 1.4
//    Дополните предыдущий код сравнением ваших данных с другой
//    переменной, данный код должен имитировать простейший поиск перебором.
//    Оцените время выполнения алгоритма с помощью базового метода
//System.nanoTime().

    public static void main(String[] args) {
        //создание, вывод данных
        Person p = new Person();
        p.toString();

        //создание листа персон
        List<Person> list = new ArrayList<>();
        for(int i = 0; i<7;i++){
            list.add(new Person());
        }
        list.toString();

        //Перебор - поиск персоны с именем t.
        String t = "1";
        long l = System.nanoTime();
        for(int j = 0; j< list.size(); j++){
            if(list.get(j).getName().equals(t)){
                list.get(j).toString();
            }
        }
        System.out.println("Время работы перебора: " + (System.nanoTime()- l));

    }
}
//собственный класс
class Person {
    private String name;
    private Integer i;

    public Person() {
        this.name = String.valueOf(i + 1);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", i=" + i +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                i.equals(person.i);
    }

    public String getName() {
        return name;
    }
}







