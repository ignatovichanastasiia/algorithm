import java.util.Random;

public class Algorithm08 {
//    Задание 8.1
//    Приведите пример использование хеш-таблиц.
//     пароли, коды, личные данные пользователей - то, что не должно находиться в открытом доступе.
//            Задание 8.2
//    Приведите примеры ключей и коллизий.
//        В примере из урока: 184, 302, 420, 544 хешируются в 7. 4 числа - один ключ.
//            Задание 8.3
//    Приведите примеры популярных и эффективных хеш-функций.
//            суммирование, возведение в степени
//            Задание 8.4
//    На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования
//    Задание 8.5
//    Перестройте программный код задания 8.4 из алгоритма линейного пробирования в алгоритм двойного хеширования.
//    Сравните отличительные черты двух алгоритмов.
//        При двойном хешировании заполняемость более плотная, меньшая вероятность коллизий.

    public static void main(String[] args) {
        Item dataItem;
        int key;
        int size = 10;
        HashTable table = new HashTable(size);
        Random rn = new Random();
        dataItem = new Item(211);
        table.insert(dataItem);
        for (int j = 0; j < 9; j++) {
            key = rn.nextInt(999);
            dataItem = new Item(key);
            table.insert(dataItem);
        }
        table.display();

    }
}

class Item {
    private int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }
}

class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable(int size) {
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key) {
        return key % arrSize;
    }

    public int hashFuncDouble(int key) {
        return 5 - key % 5;
    }

    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public void insertD(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item deleteD(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            hashVal+=stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item findD(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            hashVal+=stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    private int getPrime(int min) {
        for (int i = min + 1; true; i++) {
            if (isPrime(i)) return i;
        }
    }

    private boolean isPrime(int n) {
        for (int j = 2; (j * j <= n); j++) {
            if (n % j == 0) return false;
        }
        return true;
    }
}