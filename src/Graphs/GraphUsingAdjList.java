package Graphs;

import java.util.*;

public class GraphUsingAdjList {

    int V;
    List<Integer> adjList[];

    GraphUsingAdjList(int V){
        this.V = V;
        this.adjList = new  LinkedList[V];
        for(int i=0; i<V; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    @Override
    public String toString() {
        return "GraphUsingAdjList{" +
                "V=" + V +
                ", adjList=" + Arrays.deepToString(adjList) +
                '}';
    }

    void addEdge(int u, int v, boolean undirected){
        adjList[u].add(v);
        if(undirected){
            adjList[v].add(u);
        }
    }

}
