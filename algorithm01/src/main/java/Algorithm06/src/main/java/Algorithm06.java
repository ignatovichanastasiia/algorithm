


//    Задания 6.1
//    Приведите пример использования древовидной структуры.
//          родовое дверо
//            схематичное изображение интерфейса коллекшен.
//    Задание 6.2-5.
//    Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
//    Реализуйте методы поиска и вставки узла в дерево.
//    Реализуйте базовые методы обхода дерева и метода дисплей.
//    Реализуйте поиск максимума и минимума.
//    Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().

import java.util.Arrays;
import java.util.Random;

//Mой класс из предыдущих ДЗ

class Model {
    private int num;

    public Model(int i) {
        this.num = i;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Model{" + num + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return getNum() == model.getNum();
    }
}

class Node {
    public Model element;
    public Node leftChild;
    public Node rightChild;

    public void display() {
        System.out.println(element.toString());
    }

    public static String toString(Node node){
        return node.element.toString();
    }

}

class Tree {
    private Node root;

    public void insert(Model element) {
        Node node = new Node();
        node.element = element;
        if (root == null) root = node;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (element.getNum() < current.element.getNum()) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current.element.getNum() != key) {
            if (key < current.element.getNum()) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
                if (current == null) return null;
            }

        }
        return current;
    }

    public Node min() {
        Node last = null;
        Node current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max() {
        Node last = null;
        Node current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    private void preOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    private void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public boolean delete(int num) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.element.getNum() != num) {
            parent = current;
            if (num < current.element.getNum()) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void displayTree() {
        Node current = root;
        System.out.println("1) \n");
        inOrder(root);
        System.out.println("2) \n");
        preOrder(root);
        System.out.println("3) \n");
        postOrder(root);
    }
}

//    Задание 6.6
//    Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.

class HeapSort{
    private static int heapSize;

    public static void sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize-1);
            heapSize--;
            heapify(a, 0);
        }
    }

    private static void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    private static void heapify(int[] a, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && a[i] < a[l]) {
            largest = l;
        }
        if (r < heapSize && a[largest] < a[r]) {
            largest = r;
        }
        if (i != largest) {
            swap(a, i, largest);
            heapify(a, largest);
        }
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

//    Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
//    Задание 6.7
//    Приведите пример сбалансированного дерева и его применения.
//            set & map

public class Algorithm06 {
    public static void main(String[] args) {
        long q = System.nanoTime();
        Tree tree = new Tree();
        System.out.println("newborn time: " + (System.nanoTime() - q));
        long w = System.nanoTime();
        tree.insert(new Model(5));
        System.out.println("insert time: " + (System.nanoTime() - w));
        tree.insert(new Model(8));
        tree.insert(new Model(2));
        System.out.println("inserted models 5,8,2");
        long e = System.nanoTime();
        System.out.println("find 2: " + Node.toString(tree.find(2)) + " time: " + (System.nanoTime() - e));
        long r = System.nanoTime();
        System.out.println("max: " + Node.toString(tree.max()) + " time: " + (System.nanoTime() - r));
        long t = System.nanoTime();
        System.out.println("min: " + Node.toString(tree.min()) + " time: " + (System.nanoTime() - t));
        long f = System.nanoTime();
        System.out.println("delete 2: " + tree.delete(2) + " time: " + (System.nanoTime() - f));
        Random rn = new Random();
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] arr3 = new int[10];
        for(int i=0; i<10;i++){
            arr1[i] = rn.nextInt(20);
            arr2[i] = rn.nextInt(20);
            arr3[i] = rn.nextInt(20);
        }
        long y = System.nanoTime();
        HeapSort hs = new HeapSort();
        hs.sort(arr1);
        System.out.println("sort in heap:  "+(Arrays.toString(arr1)+" time: "+(System.nanoTime()-y)));
        long u = System.nanoTime();
        arr2 = sortMerge.sortArr(arr2);
        System.out.println("sort in merge: "+(Arrays.toString(arr2)+" time: "+(System.nanoTime()-u)));
        long o = System.nanoTime();
        Arrays.sort(arr3);
        System.out.println("sort in Arrays-class: "+Arrays.toString(arr3)+" time: "+(System.nanoTime()-o));
    }
}





//Сортировка мерж с прошлого ДЗ
class sortMerge {
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
        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }
}

