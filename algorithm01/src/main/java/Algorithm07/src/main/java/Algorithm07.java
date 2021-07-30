public class Algorithm07 {
    //    Задание 7.1
//    Приведите пример графа.
//      -схема метрополитена.
//    Задание 7.2
//    Реализуйте базовые методы графа.
//    Задание 7.3
//    В программный код из задания 7.2 добавьте реализацию метода обхода
//    в глубину.
//    Выполните оценку времени с помощью System.nanoTime().
//    Задание 7.4
//    В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
//    Выполните оценку времени с помощью System.nanoTime().
    public static void main(String[] args) {

    }
}
class Stack{
    private int maxSize;
    private int[] stackArr;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stackArr = new int[size];
        this.top = -1;
    }

    public void push(int i){stackArr[++top] = 1;}
    public int pop(){return stackArr[top--];}
    public boolean isEmpty(){return (top == -1);}
    public int peek(){return stackArr[top];}
}
class Vertex{
    public char label;
    public boolean wasVisited;

    public Vertex(char label){
        this.label = label;
        this.wasVisited = false;
    }
}
class Graph{
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
    for(int i= 0;i<MAX_VERTS;i++){
        for(int j = 0;j<MAX_VERTS;j++){
            adjMat[i][j]=0;
        }
    }
}