import java.sql.SQLOutput;
import java.util.Random;

public class Algorithm04 {

    //    Задание 4.1
//    На основе данных объектного списка из задания 3.4 реализуйте простой
//    стек
//    и его базовые методы.
//    Оцените время выполнения операций с помощью базового метода System.nanoTime().
//    Задание 4.2
//    На основе данных объектного списка из задания 3.4 реализуйте простую
//    очередь
//    и его базовые методы.
//    Реализуйте вспомогательные методы.
//    Оцените время выполнения операций с помощью базового метода
//    System.nanoTime().
//    Задание 4.3
//    На основе данных объектного списка из задания 3.4 реализуйте простой
//    дек
//    и его базовые методы.
//    Оцените время выполнения операций с помощью базового метода System.nanoTime().
//    Задание 4.4
//    Реализуйте
//    приоритетную очередь
//    на основе ссылочных типов данных, например, integer.
//    Оцените время выполнения операций с помощью базового метода System.nanoTime().
//    Задание 4.5
//    На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
    public static void main(String[] args) {
        Random rn = new Random();
        long r = System.nanoTime();
        MyArrayStack stack = new MyArrayStack(5);
        System.out.println("My Array Stack born time: "+(System.nanoTime()-r));
        long q = System.nanoTime();
        stack.push(new Model((5)));
        System.out.println("My Array-Stack push time: "+(System.nanoTime()-q));
        while (!stack.isFull()){
            stack.push(new Model(rn.nextInt(10)));
        }
        System.out.println("My Array-Stack is full(isFull,push), size: "+stack.size());
        long w = System.nanoTime();
        System.out.println(stack.peek());
        System.out.println("My Array-Stack peek time: "+(System.nanoTime()-w));
        long e = System.nanoTime();
        System.out.println(stack.pop());
        System.out.println("My Array-Stack pop time: "+(System.nanoTime()-e));
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println("My Array-Stack is empty(isEmpty,pop)");
        long p = System.nanoTime();
        System.out.println("My Array-Stack isEmpty: "+ (stack.isEmpty()) + " time: "+ (System.nanoTime()-p));
        long t = System.nanoTime();
        MyArrayQueue aq = new MyArrayQueue(5);
        System.out.println("My Array-Queue born time: "+(System.nanoTime()-t));
        long y = System.nanoTime();
        aq.insert(new Model(6));
        System.out.println("My Array-Queue insert time: "+(System.nanoTime()-y));
        long u = System.nanoTime();
        System.out.println(aq.remove());
        System.out.println("My Array-Queue remove time: "+(System.nanoTime()-u));
        while (!aq.isFull()){
            aq.insert(new Model(rn.nextInt(10)));
        }
        System.out.println("My Array-Queue is full(isFull,insert), size: "+aq.size());
        long o = System.nanoTime();
        System.out.println(aq.peek());
        System.out.println("My Array-Queue peek time: "+(System.nanoTime()-o));
        while (!aq.isEmpty()){
            System.out.println(aq.remove());
        }
        System.out.println("My Array-Queue is empty(isEmpty,remove)");
        long a = System.nanoTime();
        System.out.println("My Array-Queue isEmpty: "+ (aq.isEmpty())+" time: "+ (System.nanoTime()-a));
        long s = System.nanoTime();
        MyArrayDeque ad = new MyArrayDeque(5);
        System.out.println("My Array-Deque born time: "+(System.nanoTime()-s));
        long d = System.nanoTime();
        ad.insertFirst(new Model(7));
        System.out.println("My Array-Deque insert First time: "+(System.nanoTime()-d));
        long f = System.nanoTime();
        ad.insertLast(new Model(9));
        System.out.println("My Array-Deque insert Last time: "+(System.nanoTime()-f));
        while(!ad.isFull()){
            ad.insertLast(new Model(rn.nextInt(10)));
        }
        System.out.println("My Array Deque is full(isFull,insertLast), size: "+ ad.size());
        long g = System.nanoTime();
        ad.peekFirst();
        System.out.println("My Array-Deque peekFirst time: "+(System.nanoTime()-g));
        long h = System.nanoTime();
        ad.removeFirst();
        System.out.println("My Array-Deque removeFirst time: "+(System.nanoTime()-h));
        long k = System.nanoTime();
        ad.peekLast();
        System.out.println("My Array-Deque peekLast time: "+(System.nanoTime()-k));
        long l = System.nanoTime();
        ad.removeLast();
        System.out.println("My Array-Deque removeLast time: "+(System.nanoTime()-l));
        System.out.println("My Array-Deque: ");
        ad.myDequePrint();
        long z = System.nanoTime();
        ad.clear();
        System.out.println("My Array-Deque clear time: "+(System.nanoTime()-z));
        long x = System.nanoTime();
        System.out.println("My Array-Deque isEmpty: "+ad.isEmpty()+" time: "+(System.nanoTime()-x));
        long c = System.nanoTime();
        MyListStack<Model> ls = new MyListStack();
        System.out.println("My List-Stack born time: "+(System.nanoTime()-c));
        long v = System.nanoTime();
        ls.push(new Model((5)));
        System.out.println("My List-Stack push time: "+(System.nanoTime()-v));
        for(int j = 0; j<5;j++){
            ls.push(new Model(rn.nextInt(10)));
        }
        System.out.println("My list-Stack has +5 elem(push), size: "+ls.size());
        ls.display();
        long b = System.nanoTime();
        System.out.println(ls.peek());
        System.out.println("My List-Stack peek time: "+(System.nanoTime()-b));
        long n = System.nanoTime();
        System.out.println(ls.pop());
        System.out.println("My List-Stack pop time: "+(System.nanoTime()-n));
        while (!ls.isEmpty()){
            System.out.println(ls.pop());
        }
        System.out.println("My List-Stack is empty(isEmpty,pop)");
        long m = System.nanoTime();
        System.out.println("My List-Stack isEmpty: "+ (ls.isEmpty()) + " time: "+ (System.nanoTime()-m));
        long q1 = System.nanoTime();
        MyListQueue<Model> lq = new MyListQueue();
        System.out.println("My List-Queue born time: "+(System.nanoTime()-q1));
//        push, pop, peek
        long w1 = System.nanoTime();
        lq.push(new Model(7));
        System.out.println("My List-Queue push time: "+(System.nanoTime()-w1));
        long e1 = System.nanoTime();
        System.out.println(lq.peek());
        System.out.println("My List-Queue peek time: "+(System.nanoTime()-e1));
        long r1 = System.nanoTime();
        System.out.println(lq.pop());
        System.out.println("My List-Queue pop time: "+(System.nanoTime()-r1));
        long t1 = System.nanoTime();
        System.out.println("My List-Queue isEmpty: "+lq.isEmpty()+" time: "+(System.nanoTime()-t1));
        long y1 = System.nanoTime();
        MyPriorQ pq = new MyPriorQ(5);
        System.out.println("My Priority Queue born time: "+(System.nanoTime()-y1));
//        insert,remove,peek,isEmpty,isFull,printPQ
        long u1 = System.nanoTime();
        pq.insert(7);
        System.out.println("My Priority Queue insert time: "+(System.nanoTime()-u1));
        while(!pq.isFull()) {
            pq.insert(rn.nextInt(10));
        }
        System.out.println("My Priority Queue is full, size: "+pq.size());
        System.out.println("My Priority Queue: ");
        pq.printPQ();
        System.out.println(" ");
        long o1 = System.nanoTime();
        System.out.println(pq.peek());
        System.out.println("My Priority Queue peek time: "+(System.nanoTime()-o1));
        long p1 = System.nanoTime();
        System.out.println(pq.remove());
        System.out.println("My Priority Queue remove time: "+(System.nanoTime()-p1));
        while(!pq.isEmpty()){
            pq.remove();
        }
        long a1 = System.nanoTime();
        System.out.println("My Priority Queue isEmpty: "+pq.isEmpty()+" time: "+(System.nanoTime()-a1));




    }

}

class MyArrayStack {
    private int maxSize;
    private Model[] stack;
    private int top;

    public MyArrayStack(int size) {
        this.maxSize = size;
        this.stack = new Model[this.maxSize];
        this.top = -1;
    }

    public void push(Model n) {
        this.stack[++this.top] = n;
    }

    public Model pop() {
        return this.stack[this.top--];
    }

    public Model peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }
    public int size() {
        return top+1;
    }
}

class MyArrayQueue {
    private int maxSize;
    private Model[] queue;
    private int front;
    private int rear;
    private int items;

    public MyArrayQueue(int size) {
        this.maxSize = size;
        this.queue = new Model[size];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insert(Model n) {
        if (rear == maxSize - 1) rear = -1;
        queue[++rear] = n;
        items++;
    }

    public Model remove() {
        Model temp = queue[front];
        front++;
        if (front == maxSize) front = 0;
        items--;
        return temp;
    }

    public Model peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }
}

class MyArrayDeque {
    private int maxSize;
    private Model[] queue;
    private int front;
    private int rear;
    private int items;

    public MyArrayDeque(int size) {
        this.maxSize = size;
        this.queue = new Model[size];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insertLast(Model n) {
        if (rear == maxSize - 1) rear = -1;
        queue[++rear] = n;
        items++;
    }

    public void insertFirst(Model n) {
        if (front == 0) front = maxSize-1;
        queue[front] = n;
        items++;
    }

    public Model removeFirst() {
        Model temp = queue[front];
        front++;
        if (front == maxSize) front = 0;
        items--;
        return temp;
    }

    public Model removeLast() {
        Model temp = queue[rear];
        rear--;
        items--;
        return temp;
    }

    public Model peekFirst() {
        return queue[front];
    }

    public Model peekLast() {
        return queue[rear];
    }

    public void clear() {
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public void myDequePrint() {
        int i = front;
        while (i != rear) {
            if (i == maxSize) i = 0;
            System.out.print(queue[i].toString() + "; ");
            i++;
        }
        System.out.print(queue[i].toString() + "\n");
    }
}

class MyListStack<E> {
    private TWList<E> list;
    private int top;

    public MyListStack() {
        list = new TWList<E>();
        this.top = -1;
    }

    public void push(E elem) {
        list.insertLast(elem);
        top++;
    }
    public E peek(){
        return list.getLast().getValue();
    }

    public E pop() {
        top--;
        return list.deleteLast().getValue();

    }

    public boolean isEmpty() {
        return (top==-1);
    }

    public void display() {
        list.display();
    }
    public int size(){
        return top+1;
    }
}

class MyListQueue<E> {
    private TWList<E> list2;

    public MyListQueue() {
        list2 = new TWList<E>();
    }

    public void push(E elem) {
        list2.insertLast(elem);
    }

    public E pop() {
        return list2.delete().getValue();
    }

    public E peek() {
        return list2.getFirst().getValue();
    }

    public boolean isEmpty() {
        return list2.isEmpty();
    }

//    public void display() {
//        list2.display();
//    }
}

class MyPriorQ {
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public MyPriorQ(int size) {
        this.maxSize = size;
        this.queue = new int[size];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insert(int n) {
        boolean ins = false;
        if (rear == maxSize - 1) rear = -1;
        for (int i = 0; i <= rear; i++) {
            if (n < queue[i]) {
                rear++;
                for (int j = rear; j > i; j--) {
                    queue[j] = queue[j - 1];
                }
                queue[i] = n;
                items++;
                ins = true;
                break;
            }
        }
        if (ins == false) {
            queue[++rear] = n;
            items++;
        }
    }

    public int remove() {
        int temp = queue[front];
        front++;
        if (front == maxSize) front = 0;
        items--;
        return temp;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public void printPQ() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + "; ");
        }
    }
}