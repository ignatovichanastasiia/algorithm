import java.util.LinkedList;
import java.util.Queue;

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
        Graph graph = new Graph();
        System.out.println("Inserting tops from 'A' to 'H'");
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');
        System.out.println("Inserting ribs in matrix");
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(0,5);
        long a = System.nanoTime();
        graph.displayOutsideGraph(0);
        graph.backFlags();
        System.out.println("End of first method. Working timer: "+(System.nanoTime()-a));
        long b = System.nanoTime();
        graph.displayInsideGraph(0);
        graph.backFlags();
        System.out.println("End of second method. Working timer: "+(System.nanoTime()-b));

    }
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

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }
    private int getAdjUnvisitedVertex(int ver){
        for(int i = 0; i<size;i++){
            if(adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }

    public void addVertex(char label){vertexList[size++] = new Vertex(label);}
    public void addEdge(int start,int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }
    public void displayInsideGraph(int f){
        vertexList[f].wasVisited = true;
        for(int i=0;i<size;i++){
            int v = getAdjUnvisitedVertex(f);
            if(!vertexList[i].wasVisited && v!=-1){
                fullDisplayVertex(f,v);
                displayInsideGraph(i);
            }
        }
    }
    public void displayOutsideGraph(int f){
        Queue<Integer> queue = new LinkedList<>();
        vertexList[f].wasVisited = true;
        queue.add(f);
        int v2;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
            while((v2 = getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited = true;
                fullDisplayVertex(v1,v2);
                queue.add(v2);
            }
        }
    }
    public void fullDisplayVertex(int vertex1,int vertex2){
        System.out.println("Вершины "+vertexList[vertex1].label+" - "
                +vertexList[vertex2].label);
    }
    public void backFlags(){
        for (int i = 0;i<size;i++){
            vertexList[i].wasVisited = false;
        }
    }
}