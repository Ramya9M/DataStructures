
import java.util.*;
class Graph{

    int v;

    List<Integer> adjList[];

    Graph(int v){
        this.v = v;
        adjList = new LinkedList[v];
        for(int i=0; i<v; i++)
            adjList[i] = new LinkedList<>();
    }

    void addEdge(int u, int v, boolean undirected){
        adjList[u].add(v);
        if(undirected){
            adjList[v].add(u);
        }
    }
}





public class DailyPractice {


    public static void main(String args[]){

        Graph g = new Graph(6);
        g.addEdge(1,2,true);
    }



}
