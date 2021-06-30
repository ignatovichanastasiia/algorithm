package algorithmHW02;

import java.util.Arrays;
import java.util.Random;

public class AlgEx {
    public static void main(String[] args) {
        Random rn = new Random();

        //создание массива персон
        Person02[] perArr = new Person02[7];
        for (int i = 0; i < 7; i++) {
            int d = rn.nextInt(20);
            perArr[i] = new Person02(d);
        }
        System.out.println("Массив персон: " + Arrays.toString(perArr));
        System.out.println("Массив, как лист: " + Arrays.asList(perArr));
//        Arrays.sort(perArr); - сортировка не сработает без компарабл;
//        Arrays.compare(perArr[0],perArr[1]);- аналогично;
        long l = System.nanoTime();
        Person02[] perArrCopy = Arrays.copyOf(perArr, perArr.length);
        System.out.println("Время работы копирования: " + (System.nanoTime() - l));
        long k = System.nanoTime();
        System.out.println("Copy Массив персон: " + Arrays.toString(perArrCopy));
        System.out.println("Время работы принта toString: " + (System.nanoTime() - k));
        //создание второго массива персон
        Person02[] perArr2 = new Person02[7];
        for (int i = 0; i < 7; i++) {
            perArr2[i] = new Person02(i);
        }
        System.out.println("Второй массив персон: " + Arrays.toString(perArr2));
        Person02 key = new Person02(2);
        System.out.println("Персона-ключ: " + key.toString());
        long t = System.nanoTime();
        System.out.println("Линейный поиск по персоне ключу: " + Person02.lineSearch(perArr2, key));
        System.out.println("Время работы линейного поиска: " + (System.nanoTime() - t));
        long r = System.nanoTime();
        System.out.println("Двоичный поиск по персоне ключу: " + Person02.BiSearch(perArr2, key));
        System.out.println("Время работы двоичного поиска: " + (System.nanoTime() - r));
        int[] intArr = new int[400];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = rn.nextInt(100);
        }
        int[] intArrCopy = Arrays.copyOf(intArr, intArr.length);
        System.out.println("Массив 400эл не сорт" + Arrays.toString(intArr));
        long p = System.nanoTime();
        Arrays.sort(intArr);
        System.out.println("Время работы sort 400эл: " + (System.nanoTime() - p));
        System.out.println("Массив 400эл - сорт" + Arrays.toString(intArr));
        int[] intArrCopy2 = Arrays.copyOf(intArrCopy, intArr.length);
        long u = System.nanoTime();
        Person02.sortBubble(intArrCopy);
        System.out.println("Время работы сортировки Bubble 400эл: " + (System.nanoTime() - u));
        System.out.println("Массив 400эл - сорт" + Arrays.toString(intArrCopy));
        int[] intArrCopy3 = Arrays.copyOf(intArrCopy2, intArr.length);
        long w = System.nanoTime();
        Person02.sortGet(intArrCopy2);
        System.out.println("Время работы сортировки Get 400эл: " + (System.nanoTime() - w));
        System.out.println("Массив 400эл - сорт" + Arrays.toString(intArrCopy2));
        long z = System.nanoTime();
        Person02.sortIns(intArrCopy3);
        System.out.println("Время работы сортировки Get 400эл: " + (System.nanoTime() - z));
        System.out.println("Массив 400эл - сорт" + Arrays.toString(intArrCopy3));

    }
}

//собственный класс
class Person02 {
    private int number;

    public Person02(int j) {
        this.number = j;
    }

    @Override
    public String toString() {
        return "Person02{" +
                "number=" + number +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public static int lineSearch(Person02[] arr, Person02 key) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].getNumber();
            if (arr[i].getNumber() == key.getNumber()) {
                return i;
            }
        }
        return -1;
    }

    public static int BiSearch(Person02[] arr, Person02 key) {
        int first = 0;
        int last = arr.length - 1;
        int search = -1;

        while (first != last) {
            int middle = (first + last) / 2;
            if (arr[middle].getNumber() == key.getNumber()) {
                search = middle;
                first = last;
            }
            if (arr[middle].getNumber() < key.getNumber()) {
                first = middle + 1;
            }
            if (arr[middle].getNumber() > key.getNumber()) {
                last = middle - 1;
            }
        }
        if (arr[first].getNumber() == key.getNumber()) {
            search = first;
        }
        return search;
    }

    public static int[] sortBubble(int[] arr) {
        int buff = 0;
        boolean sort = false;
        do {
            sort = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    sort = false;
                }
            }
        } while (!sort);
        return arr;
    }

    public static int[] sortGet(int[] arr) {
        int buff = 0;
        boolean sort = false;
        while (!sort) {
            int max = arr[0];
            int key = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                buff = arr[j];
                for (int i = 1; i <= j; i++) {
                    if (max < arr[i]) {
                        max = arr[i];
                        key = i;
                    }
                }
                arr[j] = max;
                arr[key] = buff;
                max = arr[0];
                key = 0;
            }
            sort = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    sort = false;
                }
            }
        }
        return arr;
    }

    public static int[] sortIns(int[] arr) {
        int out = 0;
        boolean sort = false;
        while (!sort) {
            for (int j = arr.length - 1; j >= 0; j--) {
                int max = arr[0];
                for (int i = 1; i <= j; i++) {
                    if (max < arr[i]) {
                        max = arr[i];
                        out = i;
                    }
                }
                for(int h=out;h<j-1;h++){
                    arr[h]=arr[h+1];
                }
                arr[j]=max;
            }

            sort = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    sort = false;
                }
            }
        }
        return arr;
    }
}
//    Домашние задание №2
//        на тему: «Массивы и сортировка»
//        Задание 2.1
//        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
//        Выполните обращение к массиву и базовые операции класса Arrays.
//        Оценить выполненные методы с помощью базового класса System.nanoTime().
//        Задание 2.2
//        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
//        Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.
//        Задание 2.3
//        Создайте массив размером 400 элементов.
//        Выполните сортировку с помощью метода sort().
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Задание 2.4
//        На основе существующего массива  данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
//        Задание 2.5
//        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
//        Задание 2.6
//        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
