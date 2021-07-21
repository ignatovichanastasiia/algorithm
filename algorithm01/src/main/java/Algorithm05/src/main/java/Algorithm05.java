import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Algorithm05 {
//    Здесь будет дз днем 21.07

    //    Задание 5.1
//    Приведите пример использования рекурсии.
//    -факториал
//    Задание 5.2
//    Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
//    public void rec(int i) {
//        i++;
//        rec(i);
//    }
//
//    public void rec2(int i) {
//        if (i > 45) {
//            System.out.println(i);
//        } else {
//            i++;
//            rec2(i);
//        }
//    Задание 5.3
//    Приведите пример изображающий стек вызова и стек вызова с рекурсией.
//    public static void main(String[] args) {
//        a();
//        b();
//        c();
//    }
//    стек вызовов: с(),b(),a(),main();
//    public static void main(String[] args) {
//        v();
//    }
//    public static void v(){
//        v();
//    }
//    стек: v(),v()......main();
//    Задание 5.4
//    Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        long g = System.nanoTime();
        arr = arrIn(5, arr);
        System.out.println("Время работы цикла: " + (System.nanoTime() - g));
        System.out.println(Arrays.toString(arr));
        long h = System.nanoTime();
        arr2 = rec(0, 5, arr2);
        System.out.println("Время работы рекурсии: " + (System.nanoTime() - h));
        System.out.println(Arrays.toString(arr2));
        long f = System.nanoTime();
        System.out.println("Результат поиска: " + recBinaryFind(11, 0, arr.length, arr) + ". Время работы поиска: " + (System.nanoTime() - f));
        int[] arr3 = new int[10];
        int[] arr4 = new int[10];
        System.out.println(Arrays.toString(fullArr(arr3)));
        long k = System.nanoTime();
        System.out.println("Сортировка слияния: "+Arrays.toString(sortArr(arr3))+". Время работы: "+(System.nanoTime()-k));
        System.out.println(Arrays.toString(fullArr(arr4)));
        long p = System.nanoTime();
        Arrays.sort(arr4);
        System.out.println("Сортировка системная: "+Arrays.toString(arr4)+". Время работы: "+(System.nanoTime()-p));


    }

    public static int[] fullArr(int[] arr) {
        Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = rn.nextInt(50);
        }
        return arr;
    }

    public static int[] arrIn(int b, int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = b;
            b++;
        }
        return arr;
    }

    public static int[] rec(int i, int b, int[] arr) {
        if (i < arr.length) {
            arr[i] = b;
            i++;
            b++;
            rec(i, b, arr);
        }
        return arr;
    }

    //    Оцените два алгоритма с помощью базового метода System.nanoTime().
//    Задание 5.5
//    Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
    public static int recBinaryFind(int search, int low, int high, int[] arr) {
        if (low > high) return arr.length;
        int mid = (low + high) / 2;
        if (arr[mid] == search) {
            return mid;
        } else if (arr[mid] < search) {
            return recBinaryFind(search, low + 1, high, arr);
        } else if (arr[mid] > search) {
            return recBinaryFind(search, low, high - 1, arr);
        }
        return -1;
    }

    //    Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.
//    Задание 5.6
//    На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
    public static int[] sortArr(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int mid = len / 2;
        return merge(sortArr(Arrays.copyOfRange(arr, 0, mid)), sortArr(Arrays.copyOfRange(arr, mid, len)));

    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        for(int i = 0;i<result.length;i++){
            result[i] = a[aIndex]<b[bIndex]?a[aIndex++]:b[bIndex++];
            if(aIndex==a.length){
                System.arraycopy(b,bIndex,result,++i,b.length-bIndex);
                break;
            }
            if(bIndex==b.length){
                System.arraycopy(a,aIndex,result,++i,a.length-aIndex);
                break;
            }
        }
        return result;
    }
//    Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().


}
